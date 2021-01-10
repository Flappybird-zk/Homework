package unit014.demo4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void run(){
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Socket socketAccept = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("server start...");
            Thread.sleep(2000);
            socketAccept = serverSocket.accept();
            input = new ObjectInputStream(socketAccept.getInputStream());
            UserMessage userMsg = (UserMessage) input.readObject();
            User user = userMsg.getUser();
            if(user.getUserName().equals("admin") && user.getPassword().equals("123456")){
                userMsg.setMsgType("success");
            }else{
                userMsg.setMsgType("success");
            }
            output = new ObjectOutputStream(socketAccept.getOutputStream());
            output.writeObject(userMsg);
        } catch (IOException | InterruptedException | ClassNotFoundException e) {
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
            if(socketAccept != null) {
                try {
                    socketAccept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
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
