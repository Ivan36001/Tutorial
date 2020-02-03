import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Scanner_input {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите что нибудь");
        String string = s.nextLine();
        System.out.println("Вы ввели" + string);
    }
}
