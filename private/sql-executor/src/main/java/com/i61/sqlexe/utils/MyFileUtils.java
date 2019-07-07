package com.i61.sqlexe.utils;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program: sql-executor
 * @description: 文件操作工具类
 * @author: yanyao
 * @create: 2019-07-03 17:38
 **/
public class MyFileUtils {
    public static void fileMove(List<File> files, File fileDir) {
        try {
            for (File file : files) {
                try {
                    FileUtils.moveFileToDirectory(file, fileDir, false);
                } catch (FileExistsException e) {
                    String[] fileInfo = getFileInfo(file);
                    String toPrefix=fileInfo[0];
                    String toSuffix=fileInfo[1];
                    File reNameFile = reName(file, toPrefix, toSuffix);
                    FileUtils.moveFileToDirectory(reNameFile, fileDir, false);
                    System.out.println("文件[ "+file.getName()+" ]已经存在于[ "+ fileDir.getPath()+" ] ");
                    System.out.println("将会重命名为："+reNameFile);
                }
            }
        } catch (IOException e) {
            System.out.println("移动失败！");
            e.printStackTrace();
        }
    }

    private static File reName(File old, String toPrefix, String toSuffix) {
        File directory = old.getParentFile();
        if (!directory.exists()) {
            if (directory.mkdir()) {

            }
        }
        File newFile = new File(directory, toPrefix + toSuffix);
        for (int i = 1; newFile.exists() && i < Integer.MAX_VALUE; i++) {
            newFile = new File(directory, toPrefix + '(' + i + ')' + toSuffix);
        }
        if (!old.renameTo(newFile)) {
            return old;
        }
        return newFile;
    }

    private static String[] getFileInfo(File from){
        String fileName=from.getName();
        int index = fileName.lastIndexOf(".");
        String toPrefix="";
        String toSuffix="";
        if(index==-1){
            toPrefix=fileName;
        }else{
            toPrefix=fileName.substring(0,index);
            toSuffix=fileName.substring(index,fileName.length());
        }
        return new String[]{toPrefix,toSuffix};
    }
}
