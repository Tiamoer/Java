import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
//通过反射获取以及设置成员变量
public class FieldClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("CC");
        Constructor constructor = c.getConstructor();
        CC cc = (CC) constructor.newInstance();

        //反射公共成员变量
        Field name = c.getField("name");
        name.set(cc,"张三");  //设置值
        System.out.println(name.get(cc));   //通过反射获取值

        //反射私有成员变量
        Field id = c.getDeclaredField("id");
        id.setAccessible(true); //设置访问方式为暴力访问
        id.set(cc,200);
        System.out.println(id.get(cc));
    }
}

class CC {
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
    public CC(String name, int id) {
        this.name = name;
        this.id = id;
    }
    private CC(long birthday) {
        System.out.println(birthday);
    }
    public CC() {

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