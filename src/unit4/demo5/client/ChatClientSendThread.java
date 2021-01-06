package unit4.demo5.client;

import unit4.demo5.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientSendThread extends Thread{
    private Socket socket;

    public ChatClientSendThread( Socket socket) {
        this.socket = socket;
    }

    public static void showMenu() {
        System.out.println("**************** 主菜单 ****************");
        System.out.println("1-发送消息");
        System.out.println("2-发送文件");
        System.out.println("0-退出");
        System.out.println("请输入操作");
    }

    @Override
    public void run() {
        FileInputStream fileInput = null;
        ObjectOutputStream objectOutput = null;

        Scanner sc = null;

        try {
            objectOutput = new ObjectOutputStream(socket.getOutputStream());

            while(true){
                showMenu();
                sc = new Scanner(System.in);
                String choose = sc.next();
                if(choose.equals("0")){
                    System.out.println("send exit.");
                    objectOutput.writeObject(new Message(Message.MSG_EXIT,null, "bye".getBytes()));
                    Thread.sleep(2000);
                    return;
                }else if(choose.equals("1")){
                    System.out.println("请输入聊天信息：");
                    String str = sc.next();
                    objectOutput.writeObject(new Message(Message.MSG_CHAT, null, str.getBytes()));
                    System.out.println("发送成功！");
                }else if(choose.equals("2")){
                    System.out.println("请输入您发送文件的绝对路径：");
                    String path = sc.next();
                    fileInput = new FileInputStream(path);
                    int length = fileInput.available();
                    byte[] bytes = new byte[length];
                    if(fileInput.read(bytes) != -1) {
                        objectOutput.writeObject(new Message(Message.MSG_FILE, path, bytes));
                        System.out.println("发送 [" + path + "] 成功");
                    } else {
                        System.out.println("读取失败！");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(sc != null) sc.close();
            if(fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutput != null) {
                try {
                    objectOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
