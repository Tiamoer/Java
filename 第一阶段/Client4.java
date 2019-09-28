import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLoopbackAddress(),5000);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("f:\\gui.txt");
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b)) == -1) {
            fileOutputStream.write(b,0,len);
        }
        socket.close();
        inputStream.close();
        fileOutputStream.close();
    }
}
