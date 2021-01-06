package unit4.demo1;

/**
 * 学号异常类
 */
public class IdException extends Exception{
    // 序列化版本号
    private static final long serialVersionUID = 6234567891L;

    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }
}
