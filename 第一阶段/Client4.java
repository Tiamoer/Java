import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.16.1.220",5000);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("e:\\gui.txt");
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b)) != -1) {
            fileOutputStream.write(b,0,len);
        }
        socket.close();
        inputStream.close();
        fileOutputStream.close();
    }
}
