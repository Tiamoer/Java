
import java.io.*;

public class Base {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //第一种获取字节码文件的方法
        Person o = new Person();
        Class c = o.getClass();
        System.out.println(c);
        //第二种获取字节码文件的方法
        Class c2 = Class.forName("Person");
        System.out.println(c2);
        //第三种获取字节码文件的方法
        Class c3 = Person.class;
        System.out.println(c3);

        //通过加载器将字节码文件加载
        Person p1 = new Person();
        Class c4 = p1.getClass();
        ClassLoader cl = c4.getClassLoader();
        System.out.println(cl);
    }
}

class Person {
    String name;
    int age;
    public void xs() {
        System.out.println("Hello！");
    }
    @Override
    public String toString() {
        return "132";
    }
}