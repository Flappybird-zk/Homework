package unit4.demo5.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void run(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Thread.sleep(2000);
            System.out.println("server start.");
            while(true){
                Socket socketAccept = serverSocket.accept();
                new ChatServerThread(socketAccept).start();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
