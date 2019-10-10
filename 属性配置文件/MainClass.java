import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class MainClass {
    //创建配置文件对象
    public static Properties properties = null;
    public static void main(String[] args) {
        if (properties == null) {
            properties = new Properties();
            //创建字节输入流 使用类加载器将配置文件加载在流上
            InputStream inputStream = MainClass.class.getClassLoader().getResourceAsStream("StudentInfo.properties");
            try {
                //将流加载到属性文件对象上
                properties.load(inputStream);
                System.out.println(properties.getProperty("Student.name"));
                System.out.println(properties.getProperty("Student.age"));
                System.out.println(properties.getProperty("Student.address"));
                System.out.println(properties.getProperty("Student.hobby"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //替换信息
        String[] name = new String[]{"张三"};
        String[] age = new String[]{"20"};
        String[] address = new String[]{"甘肃省庆阳市"};
        String[] hobby = new String[]{"Computer","Bike"};
        //MessageFormat.format()方法，实现替换属性值
        System.out.println(MessageFormat.format(properties.getProperty("Student.name"),name));
        System.out.println(MessageFormat.format(properties.getProperty("Student.age"),age));
        System.out.println(MessageFormat.format(properties.getProperty("Student.address"),address));
        System.out.println(MessageFormat.format(properties.getProperty("Student.hobby"),hobby));
    }
}
