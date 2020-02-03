package Многопоточность;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//имитируем соединение к серверу
public class ThreadSemaphore2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(200);//создали пул из 200 потоков
        Connection connection=Connection.getConnection();
        for (int i = 0; i <200 ; i++) {//назначаем работу нашим потокам
           executorService.submit(new Runnable() {
               @Override
               public void run() {
                   try {
                       connection.work();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
class Connection {
    private static Connection connection=new Connection();//создаем единственный объект connection
    private int connectionCount;//заводим переменную для инкрементации/декриментации
    private Semaphore semaphore=new Semaphore(10);//устанавливаем ограничение на пользование ресурсом
    private Connection(){//приватный конструктор разрешает создание только одного объекта в классе этот паттерн
        // называется Singleton


    }
    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();//берем разрешение. Тут 11-ый поток будет ждать пока не освободится разрешение
        try {
            doWork();//делаем работу потоком
        }finally {
            semaphore.release();//отдаем разрешение
        }
    }//даже если doWork() выдаст исключение работа продолжится и разрешение будет передано другому потоку


    private void doWork() throws InterruptedException {//этот метод не можем вызвать в main (т.к. он приватный)
        synchronized (this){
            connectionCount++;//инкрементируем переменную
            System.out.println(connectionCount);
        }
        Thread.sleep(5000);
        synchronized (this){
            connectionCount--;//декрементируем переменную
        }
    }
}