package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
//基于UDP协议的多线程通信
public class Test {
    public static void main(String[] args) throws SocketException {
        Server2 s = new Server2(new DatagramSocket(5002));
        Client2 c = new Client2(new DatagramSocket());
        new Thread(s).start();
        new Thread(c).start();
    }
}

//接受方
class Server2 implements Runnable {
    private DatagramSocket datagramSocket;
    public Server2(DatagramSocket d) {
        this.datagramSocket = d;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
                datagramSocket.receive(datagramPacket);
                String ip = datagramPacket.getAddress().getHostAddress();
                String str = new String(datagramPacket.getData(),0,datagramPacket.getLength());
                System.out.println("接收到来自"+ip+"的消息:"+str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//发送方
class Client2 implements Runnable {
    private DatagramSocket datagramSocket;
    public Client2(DatagramSocket d) {
        this.datagramSocket = d;
    }

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String str = null;
                str = bufferedReader.readLine();
                if (str.equals("88")) {
                    System.out.println("中断连接！");
                }
                byte[] bytes = str.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),5002);
                datagramSocket.send(datagramPacket);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //datagramSocket.close();
        }
    }
}