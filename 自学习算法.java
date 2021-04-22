import java.util.*;
import java.util.regex.Pattern;

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

        /**
         * @formatter 格式化输出字符串
         * @dataList 存放每个帧对象的队列，可有可无
         * @macList 存放Mac地址表的哈希表，因为哈希表的键唯一特性，就不用对输入的数据做端口号去重，还能自动实现Mac表中Mac地址的更新
         */

        Scanner scanner = new Scanner(System.in);
        Formatter formatter = new Formatter(System.out);
        ArrayList<Com> dataList = new ArrayList<Com>();  //帧信息组
        Map<Integer,String> macList = new HashMap<>();  //Mac表

        final String regex = "([A-Fa-f0-9]{2}-){5}[A-Fa-f0-9]{2}";

        //  输入帧信息
        for (;;) {
            System.out.println("————请输入帧信息————");
            System.out.print("接口号：");
            int port = scanner.nextInt();
            System.out.print("源mac地址：");
            String smac = scanner.next();
            System.out.print("目标地址：");
            String tmac = scanner.next();

            //  使用正则表达式，校验是否为Mac地址
            if (!(Pattern.matches(regex,smac) && Pattern.matches(regex,tmac))) {
                System.out.println("请输入正确的Mac地址！");
                continue;
            }

            dataList.add(new Com(port, smac, tmac));
            System.out.print("是否继续（Y/N）：");

            //  判断接口及mac信息是否在mac表中，不在则添加
            if (!macList.containsValue(smac)) {
                macList.put(port, smac);
            }

            if (!scanner.next().equals("Y")) break;
        }

        //  输出mac表
        formatter.format("%-6s %-15s \n","接口号","Mac地址");
        macList.forEach((k,v) -> formatter.format("%-6s %-15s \n",k,v));
    }
}
