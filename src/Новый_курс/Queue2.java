package Новый_курс;

import org.w3c.dom.ls.LSOutput;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue2 {
    public static void main(String[] args) {

        Chelovekk chel1=new Chelovekk(1);
        Chelovekk chel2=new Chelovekk(2);
        Chelovekk chel3=new Chelovekk(3);
        Chelovekk chel4=new Chelovekk(4);

        Queue<Chelovekk> ch=new ArrayBlockingQueue<>(10);//класс ArrayBlockingQueue позволяет задать максимальный размер
        //очереди
        ch.add (chel3);//первый пришел в очередь первый выйдет на печать
        ch.add (chel4);
        ch.add (chel2);
        ch.add (chel1);//последний пришел в очередь последний выйдет на печать
        System.out.println(ch.remove());//удалили первый элемент в очереди и вывели его на печать
        System.out.println(ch.peek());//вывели первый элемент в очереди на печать не удаляя его
        System.out.println(ch);
        //add()<------->offer()   группа похожих методов выполняют один и тот же функционал
        //remove()<------->poll() слева-выдают исключение при ошибке, справа-какое-то значение типа false
        //element()<------->peek()

    }
}
class Chelovekk {
    private int id;

    public Chelovekk(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chelovekk{" +
                "id=" + id +
                '}';
    }
}
