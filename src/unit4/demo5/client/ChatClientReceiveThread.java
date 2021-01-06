package unit4.demo5.client;

import unit4.demo5.Message;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 客户端接收信息
 */
public class ChatClientReceiveThread extends Thread {
    private Socket socket;
    private String savedAbsolutePath;

    public ChatClientReceiveThread(Socket socket, String savedAbsolutePath) {
        this.socket = socket;
        this.savedAbsolutePath = savedAbsolutePath;
    }

    @Override
    public void run() {
        ObjectInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Message message = (Message) in.readObject();
                if (Message.TYPE_CHAT.equals(message.type)) {
                    System.out.println("消息：" + new String(message.getBuffer()));
                } else if (Message.TYPE_FILE.equals(message.type)) {
                    String[] fileArr = message.getFileName().split("/");
                    String filename = fileArr[fileArr.length - 1];
                    System.out.println("文件：" + filename);
                    // 保存文件到本地
                    String diskFile = this.savedAbsolutePath + "/" + filename;
                    out = new FileOutputStream(diskFile);
                    out.write(message.getBuffer());
                    System.out.println("保存到本地" + diskFile + "成功");
                } else if (Message.TYPE_EXIT.equals(message.type)) {
                    System.out.println("接收线程退出!");
                    break;
                }else{
                    continue;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
        }
    }
}