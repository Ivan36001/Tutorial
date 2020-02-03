package Многопоточность;

import java.util.concurrent.Semaphore;

//этот класс нужен когда много потоков делят один ресурс (сервер, канал связи)
public class ThreadSemaphore1 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);// в качестве аргумента конструктор принимает количество потоков которые
        //одновременно могут делить ресурс( П: сколько потоков могут отправлять данные на сервер). permits-пер. разрешение
        //потки могут отдавать или забирать разрешение на использование ресурса.
        try {
            semaphore.acquire();//вызываем в случае когда мы в потоке начинаем взаимодействие с ресурсом (берем разрешение)
            //метод acquire() ждет если все разрешения заняты
            semaphore.acquire();
            semaphore.acquire();
            System.out.println("Все разрешения истрачены");
            semaphore.acquire();//здесь поток main встанет т.к. у нас нет больше разрешений
            System.out.println("Эта надпись никогда не выведится");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();//отдает разрешение на пользование ресурсом
        System.out.println(semaphore.availablePermits());//метод возвращает количество разрешений которые у нас свободны

    }

}
