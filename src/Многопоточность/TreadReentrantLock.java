package Многопоточность;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//ReentrantLock(пер. входящий замок) полностью дублирует функционал ключевого слова synchronized
//но с особенностями (см. далее Deadlock)
public class TreadReentrantLock {
    public static void main(String[] args) throws InterruptedException {
     Task task=new Task();//монитор этого объекта будут делить два потока
     Thread thread1=new Thread(new Runnable() {
         @Override
         public void run() {
             task.firestTread();//для объекта вызываем инкриментирующий метод первого потока
         }
     });
     Thread thread2=new Thread(new Runnable() {
         @Override
         public void run() {
             task.secondTread();//для объекта вызываем инкриментирующий метод второго потока
         }
     });
     thread1.start();//запускаем наши потоки
     thread2.start();

     thread1.join();//ждем окончания выполнения наших потоков
     thread2.join();

     task.showCounter();//печатаем переменную
    }
}
class Task{
    private int counter;
    private Lock lock =new ReentrantLock();//новый объект класса ReentrantLock со ссылкой в интерфейсе Lock

    private void increment(){
        for (int i = 0; i < 10000 ; i++) {//метод инкрементирующий переменную
            counter++;
        }
    }
     public void firestTread(){//метод инкрементирующий переменную для первого потока
        lock.lock();//какой поток первым начал выполняться такой и започит доступ к монитору
        increment();//инкриментируем переменную counter до 10000 (если этот поток взял первым монитор) или с 10000-20000
         //если взял вторым
        lock.unlock();//поток выполнился, монитор передаем другому потоку-анлок
     }
     public void secondTread(){//метод инкрементирующий переменную для второго потока
         lock.lock();//какой поток первым начал выполняться такой и залочит доступ к монитору
         increment();
         lock.unlock();//поток выполнился монитор передаем другому потоку-анлок
     }
     public void showCounter(){
         System.out.println(counter);//метод печатающий нашу переменную
     }
}