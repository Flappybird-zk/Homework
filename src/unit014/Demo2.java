package unit014;

import java.io.File;

public class Demo2 {
    static void remove(String path){
        File files = new File(path);
        if(files.exists()){
            // 遍历当前目录文件列表
            System.out.println(files.listFiles());
            for (File file: files.listFiles()){
                // 判断若为文件，则删除；若为目录则递归调用remove()，删除目录.
                if(file.isFile()){
                    file.delete();
                    System.out.println("删除文件：" + file.getName() + ".");
                }else{

                    remove(file.getPath());
                    file.delete();
                    System.out.println("删除目录：" + file.getName() + ".");
                }
            }
        }else{
            System.out.println("文件目录不存在");
        }
    }
}
