package unit014.demo5.utils;

import java.io.File;

public class FileUtils {
    /**
     * 创建目录
     * @param path
     * @return
     */
    public static String mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /**
     * 检测目录
     * @param path
     * @return
     */
    public static boolean exists(String path) {
        File file = new File(path);
        if (file.exists()) return true;
        return false;
    }
}
