package unit014.demo5;

import unit014.demo5.client.ChatClient;

public class Client2 {
    public static void main(String[] args) {
        new ChatClient("./tmp/client2").begin();
    }
}