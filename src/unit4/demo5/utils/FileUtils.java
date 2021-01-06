package unit4.demo5.utils;

import java.io.File;

public class FileUtils {
    // 创建目录方法
    public static String mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
