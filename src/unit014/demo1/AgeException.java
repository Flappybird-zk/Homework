package unit014.demo1;

/**
 * 年龄异常类
 */
public class AgeException extends Exception{
    // 序列化版本号
    private static final long serialVersionUID = 6234567890L;

    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
