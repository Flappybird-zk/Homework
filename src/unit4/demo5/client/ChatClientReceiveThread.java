package unit4.demo5.client;

import unit4.demo5.Message;
import unit4.demo5.utils.FileUtils;

import java.io.*;
import java.net.Socket;

public class ChatClientReceiveThread extends Thread{
    private Socket socket;
    // 下载文件的保存的绝对路径
    private String downloadPath;

    public ChatClientReceiveThread(String downloadPath, Socket socket) {
        this.downloadPath = downloadPath;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInput = null;
        FileOutputStream fileOutput = null;

        try {
            objectInput = new ObjectInputStream(socket.getInputStream());
            while(true){
                Message msg = (Message) objectInput.readObject();
                int msgType = msg.getMsgType();
                if(msgType == Message.MSG_EXIT){
                    System.out.println("receive exit.");
                    break;
                }else if(msgType == Message.MSG_CHAT){
                    System.out.println("新消息：" + new String(msg.getBuffer()));
                }else if(msgType == Message.MSG_FILE){
                    String[] fileArr = msg.getFileName().split("/");
                    String filename = fileArr[fileArr.length - 1];
                    System.out.println("接收到文件：" + filename);
                    //保存文件到本地
                    String diskFile = this.downloadPath + "/" + filename;
                    fileOutput = new FileOutputStream(diskFile);
                    fileOutput.write(msg.getBuffer());
                    System.out.println("保存到本地" + diskFile + "成功");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fileOutput != null) {
                try {
                    fileOutput.close();
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
            if(objectInput != null) {
                try {
                    objectInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
