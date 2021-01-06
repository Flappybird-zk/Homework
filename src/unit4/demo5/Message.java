package unit4.demo5;

import java.io.Serializable;


public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    // 消息类型：chat|file|exit
    public String type;
    public static final String TYPE_CHAT = "chat";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_EXIT = "exit";
    // 文件
    private String fileName;
    // 消息
    private final byte[] buffer;

    public Message(String type, String fileName, byte[] buffer) {
        this.type = type;
        this.fileName = fileName;
        this.buffer = buffer;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getBuffer() {
        return buffer;
    }
}