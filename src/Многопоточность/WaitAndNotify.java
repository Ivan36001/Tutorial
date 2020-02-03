package Многопоточность;

import java.util.Scanner;
//методы wait() и notify() определены в классе Object. Способ общения потоков
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Wait_and_Notify wn=new Wait_and_Notify();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
class Wait_and_Notify {
    public void produce() throws InterruptedException {
  synchronized (this) {//synchronized block
      System.out.println("Producer поток стартанул...");
      wait();//метод вызывается только в пределах синхронизованного блока и на объекте на котором определен синхронизова-
      //нный блок (this). Метод: 1) Отдает intrinsic lock (пер. внутренний замок) или по другому монитор другому потоку
      //2) Ждет когда будет вызван notify() на том же объекте
      System.out.println("Produсer поток продолжил работу");//вывод после того как сработал метод notify() во 2-ом потоке
  }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);//чтобы Producer поток сработал первым
         Scanner scanner=new Scanner(System.in);
         synchronized (this){
             System.out.println("Ждем когда будет нажат enter");
             scanner.nextLine();//поток ждет когда нажмем enter
             notify();//пробуждает поток (notifyAll()-пробуждает все потоки).Метод не отдает монитор (!) т.е выполнится
             //только первое условие метода wait(). Так же метод wait() может принимать аргументы: wait(5000)-ждет 5 сек
             //пока будет вызван метод notify(), если он за это время не будет вызван поток продолжит свое выполнение
             //(только в том случае если монитор будет у него)
             Thread.sleep(5000);//только после завершения работы потока передастся монитор
                      }
    }
}//передаем монитор
//важно чтобы оба метода wait() и notify() вызывались на одном объекте