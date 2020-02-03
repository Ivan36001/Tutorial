package Многопоточность;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//synchronized block-позволяет синхронизироваться по двум или более разным объектам (мониторам) позволяя использовать
//несколько потоков одновременно. В отличии от synchronized method.

public class TreadSynchronizedBlock {
       public static void main(String[] args) throws InterruptedException {
        new Worker().main();//вызываем метод считающий время исполнения программы
           }
}
class Worker {
    Random random=new Random();//С помощью этого класса мы получаем псевдослучайное число

    Object lock1=new Object();//создаем два объекта для одновременного выполнения 2-ух потоков
    Object lock2=new Object();//можно в качестве объекта использовать даже наши list-ы (но так не принято)

    private List<Integer> list1=new ArrayList<>();//ArrayList1 куда мы будем добавлять случайные числа
    private List<Integer> list2=new ArrayList<>();//ArrayList2 куда мы будем добавлять случайные числа

    public void addToList1() throws InterruptedException {//метод для добавления в list1
        synchronized (lock1) {//берем монитор объекта lock1 для одновременной работы потоков (если бы объект был один то
            //выполнялся только один метод addToList так как synchronized использовал только один монитор)
            Thread.sleep(1);//на каждой итерации цикла спим 1 мсек
            list1.add(random.nextInt(100));//получаем число в диапазоне 0-100 и помещаем его в list1
        }
    }


    public void addToList2() throws InterruptedException {//метод для добавления в list2
        synchronized (lock2) {//синхронизируемся на мониторе объекта lock2 для одновременной работы потоков
            Thread.sleep(1);//на каждой итерации цикла спим 1 мсек
            list2.add(random.nextInt(100));//получаем число в диапазоне 0-100 и помещаем его в list2
        }
    }

    public void worK() throws InterruptedException {//вызываем методы добавления в списки 1000 раз (доб. 1000 чисел в
        //list1 и list2)
        for (int i=1;i<=1000; i++){
            addToList1();
            addToList2();
        }
    }



    public void main() throws InterruptedException {//не статический метод main для выполнения нужен объект
        long before=System.currentTimeMillis();//время на начало исполнения программы


        Thread thread11=new Thread(new Runnable() {
            @Override
            public void run() {//передаем потоку тот код котрый мы хотим выполнить (поставляя ему в качестве аргумента
                //анонимный класс в котором описана логика работы
                try {
                    worK();
                } catch (InterruptedException e) {//т.о в двух потоках у нас будет вызываться метод work()
                    e.printStackTrace();
                }
            }
        });

        Thread thread22=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worK();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread11.start();//запускаем потоки
        thread22.start();

        thread11.join();//ждем выполнения наших потоков
        thread22.join();

        long after=System.currentTimeMillis();//время конца исполнения программы
        System.out.println("Программа выполнилась за "+(after-before)+" ms");
        System.out.println("list1 : "+ list1.size());
        System.out.println("list2 : "+ list2.size());

    }
}