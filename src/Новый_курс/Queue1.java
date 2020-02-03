package Новый_курс;

import java.util.LinkedList;
import java.util.Queue;

//Queue-переводится как очередь (первый пришел-первый зашел)
public class Queue1 {
    public static void main(String[] args) {

        Chelovek chel1=new Chelovek(1);
        Chelovek chel2=new Chelovek(2);
        Chelovek chel3=new Chelovek(3);
        Chelovek chel4=new Chelovek(4);

        Queue<Chelovek> ch=new LinkedList<>();//класс LinkedList реализует два интерфейса: List и Queue
        ch.add (chel3);//первый пришел в очередь первый выйдет на печать
        ch.add (chel4);
        ch.add (chel2);
        ch.add (chel1);//последний пришел в очередь последний выйдет на печать
        System.out.println(ch);

    }
}
class Chelovek {
    private int id;

    public Chelovek(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chelovek{" +
                "id=" + id +
                '}';
    }
}