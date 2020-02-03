package Многопоточность;

import java.util.LinkedList;
import java.util.Queue;

//использование wait() и notify() для реализации паттерна Producer-Consumer (низкоуровневая реализация) в большинстве
//случаев будем использовать классы из пакета java.util.concurrent (уже потокобезопасные и в них вообще не надо задумывытся о потокобезопасености и использовать synchronized и т.д.)
public class Wait_notify_for_Prod_Cons {

    public static void main(String[] args) throws InterruptedException {
        ProduserConsumer pc=new ProduserConsumer();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
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
class ProduserConsumer {
    private Queue<Integer> queue=new LinkedList<>();//создали не потокобезопасный связанный список для реализации ее при
    //помощи наших методов wait() и notify()
    private final int LIMIT=10;//максимальное кол-во элементов в связанном списке
    private final Object lock=new Object();//создали объект для синхронизации (должен для синхронизации быть константой)


    public void produce() throws InterruptedException {//добавляем элементы
        int value=0;//создали переменную для инкрементации
        while (true){//бесконечный цикл
            synchronized (lock){
                while (queue.size()==LIMIT){//цикл while вместо if для чтобы еще раз прокрутиться и удостоверится
                    lock.wait();//если размер очереди раве 9-ти передаем монитор
                }
                queue.offer(value++);
                lock.notify();

            }
        }

    }


    public void consume() throws InterruptedException {//убираем элементы
        while (true){
            synchronized (lock){
                while (queue.size()==0){
                    lock.wait();//если размер очереди равен нулю передаем монитор первому потоку для добавления элементов
                }
                int value=queue.poll();//берем элемент из очереди и называем его value
                System.out.println(value);//печатаем взятый элемент
                System.out.println("Размер очереди-"+queue.size());//печатаем размер очереди
                lock.notify();//выполняем первое условие для wait() в первом потоке
            }
            Thread.sleep(1000);//ждем еще секунду чтобы producer успевал заполнить очередь (поток засыпоет и передает
           // монитор)
        }

    }
}//передаем монитор первому потоку для добавления нового  элемента (выполняем 2-ое условие wait())
//Вначале размер очереди 0. Если монитор у первого потока: он добавляет в цикле 10 элементов->передает монитор второму
//потоку он берет один элемент, засыпает и передает монитор первому потоку который добавляет туда еще элемент и т.д
//Если вначале монитор у второго потока у него сразу срабатывает метод wait() и инициатива передается первому потоку и
//все происходит как описано выше для первого потока