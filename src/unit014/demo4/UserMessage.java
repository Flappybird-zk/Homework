package unit014.demo4;

import java.io.Serializable;

public class UserMessage implements Serializable {
    private static final long serialVersionUID = 1234567891L;

    private String msgType;
    private User user;

    public UserMessage() {
    }

    public UserMessage(String msgType, User user) {
        this.msgType = msgType;
        this.user = user;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "类型：" + msgType + ",用户信息：" + user;
    }
}
