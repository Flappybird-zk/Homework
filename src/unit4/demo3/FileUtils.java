package unit4.demo3;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * 获取文件夹下所有的文件
     * @param dir
     * @return
     */
    public static List<File> getAllFiles(String dir){
        List<File> files = new ArrayList<File>();

        File file=new File(dir);
        if (file.exists() && file.isDirectory()) {
            traversal(file, files);
        }
        return files;
    }

    /**
     * 递归遍历文件夹下文件
     * @param file
     * @param files
     */
    private static void traversal(File file, List<File> files) {
        File[] fillArr= file.listFiles();
        //如果是一个空的文件夹
        if (fillArr==null) {
            return;
        }
        for (File file2 : fillArr) {
            if(file2.isFile()){
                // 若为文件，添加到文件列表
                files.add(file2);
            }else{
                // 若为目录，递归
                traversal(file2, files);
            }
        }
    }
}