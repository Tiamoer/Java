package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入发送的内容:");
        String str = scanner.next();
        byte[] bytes = str.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),5000);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
