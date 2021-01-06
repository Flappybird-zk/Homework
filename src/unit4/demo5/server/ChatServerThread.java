package unit4.demo5.server;

import unit4.demo5.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerThread extends Thread {
    private Socket socket;
    // 保存所有的Socket连接
    private static ArrayList<Socket> clients = new ArrayList<>();

    public ChatServerThread(Socket socket) {
        this.socket = socket;
        clients.add(socket);
        System.out.println("add client success, size:" + clients.size());
    }

    @Override
    public void run() {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        ObjectOutputStream outOther = null;

        System.out.println(Thread.currentThread().getName() + "-client[" + socket.getInetAddress() + "] connect success！");
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Message message = (Message) in.readObject();
                // 消息类型判断
                if (Message.TYPE_CHAT.equals(message.type)) {
                    System.out.println(Thread.currentThread().getName() + "收到消息:"+ new String(message.getBuffer()));
                } else if (Message.TYPE_FILE.equals(message.type)) {
                    System.out.println(Thread.currentThread().getName() + "收到文件:"+ message.getFileName());
                } else if (Message.TYPE_EXIT.equals(message.type)) {
                    out.writeObject(message);
                    System.out.println(Thread.currentThread().getName() + " client[" + socket.toString() + "] 退出");
                    break;
                }
                // 发送消息到其他客户端
                for (Socket client : clients) {
                    if (client == socket) continue;
                    outOther = new MyObjectOutputStream(client.getOutputStream());
                    outOther.writeObject(message);
                    System.out.println(Thread.currentThread().getName() + "转发给client[" + client.toString() + "信息成功");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            clients.remove(socket);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outOther != null){
                try {
                    outOther.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
