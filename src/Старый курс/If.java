import java.sql.SQLOutput;

public class If {
    public static void main(String[] args) {
        int i = 10;
        if (i < 9) {
            System.out.println("No");

        } else if (i > 11) {
            System.out.println("Noo");
        } else {
            System.out.println("Ни одно из условий не подошло");
        }
    }
}
