package E2020;
import java.util.Scanner;

public class Circular {
    public static void main(String[] args) {
        int choose = 0;
        float radius = new Algorithm().print();
        do {
            System.out.println("Choose an option:\n1.Area\n2.Perimeter");
            choose = new Scanner(System.in).nextInt();
            if (choose !=1 && choose !=2)
                System.out.println("Please enter 1 or 2");
        }while (choose !=1 && choose !=2);
        switch (choose) {
            case 1 -> System.out.println("Area:" + new Algorithm().area(radius));
            case 2 -> System.out.println("Perimeter:" + new Algorithm().perimeter(radius));
        }
    }
}

class Algorithm {
    private static final float PI = 3.1415926f;
    private static Scanner sc;
    float print() {
        System.out.println("Please enter radius:");
        sc = new Scanner(System.in);
        return sc.nextFloat();
    }
    float area(float radius) {
        return radius*radius*PI;
    }
    float perimeter(float radius) {
        return 2*radius*PI;
    }
}
