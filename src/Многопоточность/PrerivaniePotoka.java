package Многопоточность;

import java.util.Random;

public class PrerivaniePotoka {
    public static void main(String[] args) throws InterruptedException {//есключение выбрасывется в потоке на том методе
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Random random=new Random();
                for (int i = 0; i <1000_000_000 ; i++) {
                    try {
                        Thread.sleep(1);//исключение InterruptedException выбрасывется в том случае когда какие-то
                        //методы (в нашем случае sleep()) выполняются в том потоке который был прерван
                    } catch (InterruptedException e) {
                        System.out.println("Поток был прерван");
                        break;
                    }
                    // if (Thread.currentThread().isInterrupted()) {//конструкция которая понимает прерывали этот поток или нет
                        //в класса Thread вызвали статический метод currentThread() который возвращает текущий поток
                        // и на текущем потоке мы вызываем метод isInterrupted() который возвращает true если в другом потоке
                        //был вызван прерывающий метод interrupt()
                       // System.out.println("Поток был прерван");
                       // break;//вышли из цикла
                   // }
                    Math.sin(random.nextDouble());
                    System.out.println();
                }
            }
        });
        System.out.println("Старт потока");
        thread.start();
        Thread.sleep(7000);//даем потку thread поработать 1 сек
        thread.interrupt();//даем понять потоку thread что мы хотим его завершить, поток это сообщение принимает и мы
        //в этом потоке можем как угодно обработать это сообщение (для избежания состояния неопределенности как при испо-
        // льзовании метода stop())
        thread.join();//должен быть вызван после interrupt() т.к main останавливается и ждет выполнения thread
        System.out.println("Поток завершен");
    }
}
