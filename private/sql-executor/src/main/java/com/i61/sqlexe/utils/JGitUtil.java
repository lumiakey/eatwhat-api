package com.i61.sqlexe.utils;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * @program: sql-executor
 * @description: git工具类
 * @author: yanyao
 * @create: 2019-07-03 17:36
 **/
public class JGitUtil {
//    private static String dev_runConfigLink = "E:\\project\\sql-executor\\src\\main\\resources\\runConfig.properties";
    private static String dev_runConfigLink =".." + File.separator + ".." + File.separator + ".." + File.separator + "runConfig.properties";
    public static File workPath = new File("."+File.separator+"workPath");
    public static File release = new File(workPath + "." + File.separator + "release");
    public static File release_his = new File(workPath + "." + File.separator + "release_his");
    private static UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new UsernamePasswordCredentialsProvider("sql_manager", "sql_manager123");
    public static String system = null;
    public static String gitlab = null;
    static{
        Properties pRunConfig = null;
        try {
            FileInputStream inputStream = new FileInputStream(dev_runConfigLink);
            pRunConfig = new Properties();
            pRunConfig.load(inputStream);
        } catch (Exception e) {
            System.out.println("runConfig.properties配置错误，未能成功读取！");
            e.printStackTrace();
        }
        system = pRunConfig.getProperty("System");
        gitlab = pRunConfig.getProperty("Gitlab");
    }

    public static void gitClone() {
        FileUtils.deleteQuietly(workPath);
        try {
            CloneCommand cloneCommand = Git.cloneRepository();
            cloneCommand.setCredentialsProvider(usernamePasswordCredentialsProvider);
            cloneCommand.setURI(gitlab).setDirectory(workPath).call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public static void gitPush(String executorName) {
        try {
            Git push = Git.open(workPath);
            try {
                push.add().addFilepattern(".").call();
                push.commit().setMessage(executorName+"跑sql").call();
                push.push().setCredentialsProvider(
                        usernamePasswordCredentialsProvider).call();
                push.close();
            } catch (GitAPIException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
