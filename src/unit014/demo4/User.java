package unit014.demo4;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1234567890L;

    private String userName;
    private String password;

    public User(){
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "用户名：" + userName + ",密码：" + password;
    }
}
