package Многопоточность;

import java.util.Scanner;

//Некогерентность кэшей: пусть у нас два ядра и на каждом выполняется свой поток, у каждого ядра есть свой кэш где храниятся наиболее важные
//данные может случится так что один из кэшей закэширует булеву переменную себе в кэш со значением true, а
//в другом потоке значение переменной изменилось и программа не завершит свое выполнение т.к значение false
//используется для завершения выполнения потока на том ядре гдг переменная закэшировалась. т.е некогерентность
//кэшей это разное значение одной и той же переменной в кэшах разных ядер.
//volatile-ключевое слово не позволяющее переменной кэшироваться в памяти ядер, переменная всегда будет находится
//в главной памяти. Т.о если потоки делят общие данный нужно использовать это ключевое слово. Используется тогда когда
//один поток пишет в переменную, а другие из нее читают.
public class ThreadVolatile3 {
    public static void main(String[] args) {
        MyThread2 myThread=new MyThread2();
        myThread.start();

        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();//тут выполнеие потока main останавливается объект scanner ждет следующую линию после
        //нажатия enter он ее получает, поток main продолжает работу и вызывается метод shutdown() на нашем потоке

        myThread.shutdown();

    }
}
class MyThread2 extends Thread{
    private volatile boolean running=true;
    public void run() {
        while(running){//по умолчания true (бесконечный цикл) пока не сработает метод shutdown()
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
      public void shutdown() {//метод меняет значение переменной для остановки цикла while
        this.running=false;
      }
    }

