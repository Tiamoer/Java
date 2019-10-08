package UDP;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
//从网页下下载图片
public class downloadPictures {
    public static void main(String[] args) {
        String urlAddress = "http://www.oneme.top/img/img1.gif";
        URL url;
        InputStream inputStream;
        OutputStream outputStream;
        try {
            url = new URL(urlAddress);
            inputStream = url.openStream();
            outputStream = new FileOutputStream("e:\\img1.gif");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=inputStream.read(bytes))!=-1) {
                outputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
