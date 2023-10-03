import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome In The Student Database System");
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            int a = 0;
            System.out.println("Please enter your choice "+"\n0 to start"+"\n1 to exit\n");
            a = sc.nextInt();
            switch (a){
                case 0 : System.out.println("HELLO");
                         Maincontroler maincontroler = new Maincontroler();
                         maincontroler.start();
                         break;
                case 1 : System.out.println("ThankYOU");
                            System.exit(0);
            }
        }


        System.out.println("Hello world!");
    }
}