package Многопоточность;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;//папка содеожит большое количество полезных
import java.util.concurrent.BlockingQueue;
// синхронизованных (потокобезопасных)классов
//Потоковая безопасность (англ. thread-safety) — это концепция программирования, применимая к многопоточным программам.
// Код потокобезопасен, если он функционирует исправно при использовании его из нескольких потоков одновременно.
// В частности, он должен обеспечивать правильный доступ нескольких потоков к разделяемым данным.



//паттерн производитель-потребитель
public class PatternProducer_consumer {
    private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);//это потокобезопасная очередь с количеством
    // элементов не более 10-ти. Мы вынесли эту переменную в поле чтобы мы могли получить к ней доступ из всех методов.
    //Так же сделали ее статической чтобы использовать в статических методах

    public static void main(String[] args) throws InterruptedException {
        Thread thread111=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       Thread thread222=new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   consumer();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

       thread111.start();
       thread222.start();

       thread111.join();
       thread222.join();

    }
    private static void produce() throws InterruptedException {//метод-производитель
        Random random=new Random(100);//число в скобках это значение с помощью которого генерируются
        // псевдослучайные числа (к верхней границе не имеет отношения)
        while(true){
            queue.put(random.nextInt(100));//помещаем целое псевдослучайное число в очередь. Метод put() ждет пока очередь
            //не освободится (потокобезопасный метод-предназначен для работы с множеством потоков). Значение в скобках
            //верхняя граница (числа от 0-100)
        }

    }

private static void consumer() throws InterruptedException {
        while (true){
            Random random=new Random();
            Thread.sleep(100);
            if(random.nextInt(10)==5){//берем число из очереди если псевдослучайное чило равно 5
            System.out.println(queue.take());//метод ждет если в нашей очереди нет элементов (потокобезопасный метод)
            System.out.println("Размер очереди "+queue.size());
        }
      }
}
}