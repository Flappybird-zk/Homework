package unit4.demo5;

import unit4.demo5.client.ChatClient;

public class Client2 {
    public static void main(String[] args) {
        new ChatClient("./tmp/client2").begin();
    }
}