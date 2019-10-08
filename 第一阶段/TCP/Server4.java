package TCP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("d:\\aaa.txt");
        byte[] b = new byte[1024];
        int len = 0;
        while ((len=fileInputStream.read(b))!=-1) {
            outputStream.write(b,0,len);
        }
        serverSocket.close();
        socket.close();
        outputStream.close();
        fileInputStream.close();
    }
}
