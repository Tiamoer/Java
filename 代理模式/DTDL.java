import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理模式
public class DTDL {
    public static void main(String[] args) {
        JS o = new MB1(100);
        DL1 d = new DL1(o);
        JS proxyO = (JS) Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),d);
        proxyO.ride();
        proxyO.add();
    }
}
//工厂接口
interface JS {
    public void add();
    public void ride();
}
//目标类
class MB1 implements JS {
    int n;
    int add = 0;
    int ride = 1;
    public MB1(int n) {
        this.n = n;
    }
    @Override
    public void add() {
        for (int i=0;i<=n;i++) {
            add = add+i;
        }
        System.out.println("和为："+add);
    }
    @Override
    public void ride() {
        for (int i=1;i<=n;i++) {
            ride = ride*i;
        }
        System.out.println("积为："+ride);
    }
}
//动态代理类
class DL1 implements InvocationHandler {
    private final Object target;
    public DL1(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = method.invoke(target,args);
        return o;
    }
}