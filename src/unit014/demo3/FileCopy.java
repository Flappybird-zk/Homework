package unit014.demo3;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileCopy{
    public static void copy(String filePath, String toFilePath){
        java.io.File files = new java.io.File(filePath);
        java.io.File toFiles = new java.io.File(toFilePath);

        new Thread(){
            public void run(){
                if(files.isFile()){
                    // 如果是文件，直接复制
                    copyFile(files, toFiles);
                    System.out.println("文件：" + filePath + "复制到" + toFilePath + "。");
                }else{
                    // 如果是目录，若复制到自己的子文件夹中，则不允许操作
                    if(toFilePath.replace("/", "\\").toLowerCase().startsWith(filePath.replace("/", "\\").toLowerCase())){
                        System.out.println("禁止复制到自己的子文件夹");
                        return;
                    }

                    ExecutorService pool = Executors.newFixedThreadPool(20);
                    for(File file: FileUtils.getAllFiles(filePath)){
                        String source = file.getAbsolutePath();
                        String dest = source.replace(files.getPath(), toFilePath + "/");
                        System.out.println("从" + source + ">> " + dest + "。");
                        if(file.isFile()){
                            pool.execute(new Runnable() {
                                @Override
                                public void run() {
                                    File destFile = new File(dest);
                                    destFile.getParentFile().mkdirs();
                                    copyFile(file, destFile);
                                }
                            });
                        }else{
                            new File(dest).mkdirs();
                        }
                    }
                    pool.shutdown();
                }
            }
        }.start();
    }

    public static void copyFile(java.io.File file, java.io.File toFile){
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(file);
            output = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = input.read(buffer)) != -1){
                output.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
