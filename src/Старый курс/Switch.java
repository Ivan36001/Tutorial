import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Введи возраст");
        int age=s.nextInt();
        switch (age){
            case 0:
                System.out.println("Ты не родился");
                break;
            case 7:
                System.out.println("Ты пошел в школу");
                break;
            case 9:
                System.out.println("Ты в 3-ем классе");
                break;
            default:
                System.out.println("Ни одно условие не подошло");

        }
    }
}
