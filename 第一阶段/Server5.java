import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {
    public static void main(String[] args) {
        new Thread(new Server51()).start();
    }
}
class Server51 extends Thread {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream in;
    private FileOutputStream fileOutputStream;
    private int id = 1;
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("系统准备就绪！");
                System.out.println("正在等待客户端上线！");
                serverSocket = new ServerSocket(5000);
                socket = serverSocket.accept();
                System.out.println("客户端已上线！");
                in = socket.getInputStream();
                fileOutputStream = new FileOutputStream("d:\\文件"+id+".txt");
                byte[] b = new byte[1024];
                int len = 0;
                System.out.println("开始接收第"+id+"个文件！");
                id++;
                while ((len=in.read(b))!= -1) {
                    fileOutputStream.write(b,0,len);
                }
                System.out.println("接收完毕！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    fileOutputStream.close();
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}