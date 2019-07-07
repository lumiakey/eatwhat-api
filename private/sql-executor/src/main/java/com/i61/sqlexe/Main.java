package com.i61.sqlexe;

import com.i61.sqlexe.service.ExecutorRecordService;
import com.i61.sqlexe.utils.JGitUtil;
import com.i61.sqlexe.utils.MyFileUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.*;

import static com.i61.sqlexe.utils.JGitUtil.*;

/**
 * @program: sql-executor
 * @description: sql-executor入口
 * @author: yanyao
 * @create: 2019-07-04 17:45
 **/
public class Main {

    static ExecutorRecordService executorRecordService = new ExecutorRecordService();

    static String executorName = null;
    static List<File> exeSuccessFiles = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static String ALL = "all";
    public static void main(String[] args) {
        Map<String, JdbcConf> dbConf = SqlExecutorHelper.parseDbConf();
        /*JGitUtil.gitClone();*/
        HashMap<String, File> fileHashMap = new HashMap<>();
        System.out.println("请输入执行目录：");
        File[] workDir = workPath.listFiles();
        if (workDir == null) {
            System.out.println(system+":"+gitlab +" 下为空");
            System.exit(0);
        }
        System.out.print("| ");
        for (File temp : workDir) {
            if (".git".equals(temp.getName()) || ".gitignore".equals(temp.getName())) {
                continue;
            }
            fileHashMap.put(temp.getName(), temp);
            System.out.print(temp.getName() + " " + "|" + " ");
        }
        System.out.println();
        String mainDir = in.nextLine();
        File file = fileHashMap.get(mainDir);
        while (file == null) {
            System.out.println("请检查输入是否正确！！");
            mainDir = in.nextLine();
            file = fileHashMap.get(mainDir);
        }
        fileHashMap.putAll(showDirectory(file));
        String choose = in.nextLine();
        if (choose.startsWith("-exe ")) {
            mainDir = handleCommand(choose, dbConf);
        } else {
            handleFile(file,choose,fileHashMap,dbConf);
        }
        switch (mainDir) {
            case "test":
                break;
            case "preprod":
                MyFileUtils.fileMove(exeSuccessFiles,release);
                break;
            case "release":
                MyFileUtils.fileMove(exeSuccessFiles, release_his);
                break;
            default:
                break;
        }
        if (executorName == null) {
            System.out.printf("请输入姓名作为gitlab更新的记录：");
            executorName = in.nextLine();
        }
//        JGitUtil.gitPush(executorName);
    }

    private static String handleCommand(String choose, Map<String, JdbcConf> dbConf) {
        //处理路径
        String[] command = choose.split(" ");
        String[] path = command[1].split(File.separator);
        String mainDir = path[0];
        File workFile = new File(workPath.getPath() + File.separator + path);
        executor(workFile, dbConf);
        return mainDir;
    }

    private static HashMap<String, File> showDirectory(File file) {
        HashMap<String, File> fileHashMap = new HashMap<>();
        if (file.isDirectory()) {
            System.out.println("输入【all】执行"+file.getPath()+"下所有.sql || 输入文件名执行sql或进入文件夹");
            File[] files = file.listFiles();
            if (files != null) {
                for (File temp : files) {
                    fileHashMap.put(temp.getName(), temp);
                    System.out.println(temp.getName());
                }
            }
        }
        return fileHashMap;
    }
    private static void handleFile(File file, String choose, HashMap<String,File> fileHashMap, Map<String, JdbcConf> dbConf) {
        if (ALL.equals(choose)) {
            allTestDir(file,fileHashMap,dbConf);
        } else {
            //指定某个文件或文件夹
            File newFile = fileHashMap.get(choose);
            if (newFile.isDirectory()) {
                fileHashMap.putAll(showDirectory(newFile));
                String newChoose = in.nextLine();
                handleFile(newFile, newChoose, fileHashMap,dbConf);
            } else {
                if (newFile.getName().endsWith(".sql")) {
                    executor(newFile, dbConf);
                }
            }
        }
    }

    private static boolean executor(File file,Map<String, JdbcConf> dbConf) {
        boolean result = false;
        try {
            //校验是否执行过
            if (executorRecordService.isExist(system, file.getName())) {
                System.out.println("已经执行过" + file.getPath() + "!!");
                System.out.println("请输入执行人强制执行：");
                executorName = in.nextLine();
            } else {
                executorName = null;
            }
            result = doExecutor(file,dbConf.get(SqlExecutorHelper.parseDbNameByFile(file)));
            if (result) {
                exeSuccessFiles.add(file);
                executorRecordService.addExecutorRecord(system,gitlab,executorName,file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean doExecutor(File file,JdbcConf jdbcConf) throws Exception  {
        if(!file.getName().endsWith(".sql")){
            System.out.println("sql文件格式不正确:"+file.getName());
            return false;
        }
        if(file.isDirectory() || !file.getName().matches("\\w+_\\d{8}_?\\d*.sql")){
            System.err.println("sql文件格式不正确:"+file.getAbsolutePath());
            return false;
        }
        long b=System.currentTimeMillis();
        System.out.println("running sql="+file.getName());
        if(jdbcConf==null){
            throw new RuntimeException("without dbconf,sqlFile="+file.getName());
        }
        String sqlText = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
        Collection<String> sqls = SqlParser.getInstance().parseSqlText(sqlText);
        if(sqls==null || sqls.isEmpty()){
            throw new RuntimeException("illegal sqlFile="+file.getAbsolutePath());
        }
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcConf.jdbcUrl,jdbcConf.userName,jdbcConf.password);
        connection.setAutoCommit(false);
        Statement sta = connection.createStatement();
        sqls.forEach(sql -> {
            try {
                sta.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException("illegal sql="+sql+" in sqlFile="+file.getName(),e);
            }
        });
        connection.commit();
        System.out.println("run finish sql="+file.getName()+",use time="+(System.currentTimeMillis()-b)+"ms\n");
        return true;
    }


    private static void releaseDbResource(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void allTestDir(File file,HashMap<String,File> fileHashMap,Map<String, JdbcConf> dbConf) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File temp : files) {
                    if (temp.isDirectory()) {
                        allTestDir(temp,fileHashMap,dbConf);
                    } else {
                        if (temp.getName().endsWith(".sql")) {
                            executor(temp, dbConf);
                        }
                    }
                }
            }
        }
    }
}
