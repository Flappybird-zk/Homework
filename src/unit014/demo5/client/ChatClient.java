package unit014.demo5.client;


import unit014.demo5.utils.FileUtils;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    // 保存文件到本地磁盘的绝对路径
    private String savedAbsolutePath;

    public ChatClient(String savedPath) {
        this.savedAbsolutePath  = FileUtils.mkdirs(savedPath);
    }

    public void begin() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 接收消息线程
        new ChatClientReceiveThread(socket, savedAbsolutePath).start();
        // 发送消息线程
        new ChatClientSendThread(socket).start();
    }
}
