import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //通过反射获取对象的构造方法
        Class c = Class.forName("BB");
        Constructor cst = c.getConstructor();  //获取对象的所有构造方法
        BB b = (BB)cst.newInstance();   //获取对象的
        b.show3();

        //通过反射获取对象的公共有参构造方法
        Class c3 = Class.forName("BB");
        Constructor cst3 = c3.getConstructor(String.class,int.class);
        BB b3 = (BB)cst3.newInstance("张三",2022);
        b3.show2();

        //通过反射获取对象的私有有参构造方法
        Class c2 = Class.forName("BB");
        Constructor cst2 = c2.getDeclaredConstructor(long.class);
        cst2.setAccessible(true);   //设置访问方式为暴力访问 可访问private修饰的构造方法
        BB b2 = (BB)cst2.newInstance(46451);
    }
}

class BB {
    //成员变量
    public String name;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //构造方法
    public BB(String name, int id) {
        this.name = name;
        this.id = id;
    }
    private BB(long birthday) {
        System.out.println(birthday);
    }
    public BB() {

    }

    //成员方法
    public static void show() {
        System.out.println("公共静态方法");
    }
    public void show3() {
        System.out.println("公共非静态方法");
    }
    public void show2() {
        System.out.println(name+"  "+id);
    }
    private void show4() {
        System.out.println("私有方法");
    }
}
