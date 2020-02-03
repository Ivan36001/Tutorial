package Многопоточность;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CountDownLatch-пер. защелка обратного отчета
//не нужно думать о синхронизации т.к класс находится в пакете java.util.concurrent.CountDownLatch
public class ThreadCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);//CountDownLatch это такой класс при создании объектов которого
        //мы в качестве аргумента передаем число которое означает сколько раз мы должны вызвать метод countDown() чтобы
        //метод await() больше не ждал. В нашем случае после 3-ех кратного вызова метода поток main продолжит работу
        ExecutorService executorService= Executors.newFixedThreadPool(3);//создаем поол из 3-ех потоков
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(i, countDownLatch)); }//даем задание нашим 3-ем потокам
        executorService.shutdown();//прекращаем назначение заданий
        System.out.println("Ждем 3 секунды");
        countDownLatch.await();//ожидаем когда метод countDown() выполнится 3 раза после запускаем поток main
        System.out.println("Latch is opened, main thread is proceeding");

    }
}
class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(int i, CountDownLatch countDownLatch){
        this.countDownLatch= countDownLatch;
    }

    @Override
    public void run() {//что будут делать наши 3 потока (каждый спит 3 сек, затем выполняет метод countDown())
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}

