package unit4.demo5.server;

import unit4.demo5.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerThread extends Thread{
    private Socket socket;
    private static ArrayList<Socket> clients = new ArrayList<>();

    public ChatServerThread(Socket socket) {
        this.socket = socket;
        clients.add(socket);
        System.out.println("连接池添加客户端成功,当前客户端数量:" + clients.size());
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "], client[" + socket.getInetAddress() + "]  connect success！");

        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        ObjectOutputStream outputOther = null;

        try {
            input = new ObjectInputStream(socket.getInputStream());
            output = new MyObjectOutputStream(socket.getOutputStream());

            while(true){
                Message msg = (Message) input.readObject();
                int msgType = msg.getMsgType();
//                System.out.println("=======" + msg);
                String threadName = Thread.currentThread().getName();
                if(msgType == Message.MSG_EXIT){
                    // 退出，发送指令到客户端接收线程
                    output.writeObject(msg);
                    System.out.println("收到" + threadName + "[" + socket.getLocalAddress() + "] exit." );
                    break;
                }else if(msgType == Message.MSG_CHAT){
                    System.out.println("收到" + threadName + "信息["+ new String(msg.getBuffer()) + "]");
                }else if(msgType == Message.MSG_FILE){
                    System.out.println("收到" + threadName + "文件["+ msg.getFileName() + "]");
                }else{
                    System.out.println(threadName + "other!!!");
                }

                // 分发
                for(Socket client: clients){
                    if(client == socket) continue;
                    outputOther = new MyObjectOutputStream(client.getOutputStream());
                    outputOther.writeObject(msg);
                    System.out.println("[" + threadName + "] 转发到 client[" + client.toString() + "] 成功." );
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            clients.remove(socket);
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if(outputOther != null) outputOther.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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

        }

    }
}
