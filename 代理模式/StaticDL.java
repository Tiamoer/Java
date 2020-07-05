//静态代理模式
public class StaticDL {
    public static void main(String[] args) {
        DL d = new DL(new MB(100));
        d.add();
    }
}
//接口
interface Add {
    public void add();
}
//目标类
class MB implements Add {
    int n;
    public MB(int n) {
        this.n = n;
    }
    @Override
    public void add() {
        System.out.println("1~"+n+"的和为：");
    }
}
//代理类
class DL implements Add {
    private MB m;
    private int sum = 0;
    public DL(MB m) {
        this.m = m;
    }
    @Override
    public void add() {
        for (int i = 0;i<=m.n;i++) {
            sum = sum+i;
        }   //自己写的啥 自己也不知道
        m.add();
        System.out.println(sum);
    }
}