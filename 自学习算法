import java.util.*;

/*
    交换机自学习算法：假定有n台计算机,交换机mac表初始为空，在多次收发帧后，建立Mac表
 */

class Com {
    int port;
    String sourceMac;
    String targetMac;

    Com(int port,String sourceMac,String targetMac) {
        this.port = port;
        this.sourceMac = sourceMac;
        this.targetMac = targetMac;
    }
}

public class Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Formatter formatter = new Formatter(System.out);
        ArrayList<Com> dataList = new ArrayList<Com>();  //帧信息组
        Map<Integer,String> macList = new HashMap<>();  //Mac表

        //  输入帧信息
        do {
            System.out.println("————请输入帧信息————");
            System.out.print("接口号：");
            int port = scanner.nextInt();
            System.out.print("源mac地址：");
            String smac = scanner.next();
            System.out.print("目标地址：");
            String tmac = scanner.next();
            dataList.add(new Com(port, smac, tmac));
            System.out.print("是否继续（Y/N）：");

            //  判断接口及mac信息是否在mac表中，不在则添加
            if (!macList.containsKey(smac)) {
                macList.put(port, smac);
            }

        } while (scanner.next().equals("Y"));

        //  输出mac表
        formatter.format("%-6s %-15s \n","接口号","Mac地址");
        macList.forEach((k,v) -> formatter.format("%-6s %-15s \n",k,v));
    }
}
