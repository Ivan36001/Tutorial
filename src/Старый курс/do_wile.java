import java.util.Scanner;

public class do_wile {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int v;
        do {
            System.out.println("Введи 5");
            v = s.nextInt();
        }while(v!=5);
        System.out.println("Вы ввели 5");
    }

}
