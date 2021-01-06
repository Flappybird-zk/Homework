package unit4.demo5.client;

import unit4.demo5.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    // 设置相对路径
    private String savedPath;

    public ChatClient(String savedPath) {
        this.savedPath = savedPath;
    }

    public void run(){
        // 建立连接
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 接收
        String savedAbsolutePath = FileUtils.mkdirs(savedPath);
        new ChatClientReceiveThread(savedAbsolutePath, socket).start();
        // 发送
        new ChatClientSendThread(socket).start();
    }
}

