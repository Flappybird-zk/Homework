package unit014.demo5.client;

import unit014.demo5.Message;
import unit014.demo5.utils.FileUtils;
import unit014.demo5.utils.MenuUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端发送信息
 */
public class ChatClientSendThread extends Thread {
    private Socket socket;

    public ChatClientSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        FileInputStream in = null;
        ObjectOutputStream out = null;

        Scanner sc = null;

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            while(true) {
                MenuUtils.mainMenu();
                System.out.println("请选择指令：");
                sc = new Scanner(System.in);
                String choose = sc.next();
                if("1".equals(choose)){
                    System.out.println("请输入信息：");
                    String str = sc.next();
                    out.writeObject(new Message("chat", null, str.getBytes()));
                    System.out.println("发送成功！");
                }
                if("2".equals(choose)) {
                    System.out.println("请输入文件的绝对路径:");
                    String path = sc.next();
                    if(!FileUtils.exists(path)){
                        System.out.println("文件[" + path + "]不存在！");
                        continue;
                    }
                    in = new FileInputStream(path);
                    int length = in.available();
                    byte[] bytes = new byte[length];
                    if(in.read(bytes) != -1) {
                        out.writeObject(new Message("file", path, bytes));
                        System.out.println("发送文件 [" + path + "] 成功");
                    } else {
                        System.out.println("读取文件失败！");
                    }
                } else if("0".equals(choose)){
                    System.out.println("发送线程退出！");
                    out.writeObject(new Message(Message.TYPE_EXIT,null,null));
                    Thread.sleep(1000);
                    break;
                } else {
                    continue;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            assert sc != null;
            sc.close();

            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}