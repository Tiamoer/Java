package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//接收端
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
        datagramSocket.receive(datagramPacket);
        String ip = datagramPacket.getAddress().getHostAddress();
        String str = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(ip+"---"+str);
    }
}
