package unit4.demo4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void run(){
        User user = new User("admin", "123456");
        UserMessage userMsg = new UserMessage();
        userMsg.setUser(user);

        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(userMsg);
            input = new ObjectInputStream(socket.getInputStream());
            userMsg = (UserMessage) input.readObject();
            if(userMsg.getMsgType().equals("success")){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        run();
    }
}
