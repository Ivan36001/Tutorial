package Многопоточность;



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
///////////////////Отсет в методе main и запуск 3-ех созданных потоков//////////////////////////////////////
class ThreadCountDownLatch2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor13(i, countDownLatch)); }//назначаем нашим потокам id и даем задание
        executorService.shutdown();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
         countDownLatch.countDown();//три раза запускаем метод countDown() в потоке main чтобы наши 3 потока начали работу
        }
    }
}
class Processor13 implements Runnable {
    private int id;//порядковый номер потока
    private CountDownLatch countDownLatch;

    public Processor13 (int id, CountDownLatch countDownLatch){
        this.id=id;
        this.countDownLatch= countDownLatch;
    }

    @Override
    public void run() {//логика наших потоков
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();//ждем когда сработает защелка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток с id-"+id+" начал работу" );
    }
}