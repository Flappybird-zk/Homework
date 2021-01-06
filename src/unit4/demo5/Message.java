package unit4.demo5;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = -2083775012764186780L;
    // 消息类型：0退出；1文字；2文件
    private int msgType;
    public static final int MSG_EXIT = 0;
    public static final int MSG_CHAT = 1;
    public static final int MSG_FILE = 2;

    // 文件
    private String fileName;
    // 内容
    private final byte[] buffer;

    public Message(int msgType, String fileName, byte[] buffer) {
        this.msgType = msgType;
        this.fileName = fileName;
        this.buffer = buffer;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getBuffer() {
        return buffer;
    }
}
