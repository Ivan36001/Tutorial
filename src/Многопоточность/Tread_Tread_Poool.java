package Многопоточность;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//создание пула потоков
public class Tread_Tread_Poool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);//вызываем статический метод
        // newFixedThreadPool() из класса Executors в качестве аргумента этот метод принимает количество потоков, объект
        //executorService-это наш пул потоков
      for(int i=0; i<5; i++){
          executorService.submit(new Work(i));}//нашим потокам передаем 5 заданий. На вход метода поставляем объект
          //класса реализующего интерфейс Runnable, таким образом описывая эти заданиия ( в методе run())
     executorService.shutdown();// сообщаем службе-исполнителю, что он не может принимать новые задачи,
          // но уже отправленные задачи продолжают выполняться
          System.out.println("Все задачи переданы и начали свое выполнение");

          executorService.awaitTermination(1, TimeUnit.DAYS);//awaitTermination-переводится как ожидание окончания. На вход метода
          //передаем то время которое мы можем ждать. Если в течении этого времени задачи не выполнятся, то продолжаем
          //выполнение программы. При вызове этого метода поток main останавливается

    }
}
class Work implements Runnable{
    private int id;

    public Work(int id){//делаем идентификатор задания
        this.id=id;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work "+id+" was completed");
    }
}
//два работника перетаскивают 5 коробок