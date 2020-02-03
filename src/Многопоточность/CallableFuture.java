package Многопоточность;

import java.util.Random;
import java.util.concurrent.*;
// С помощью интерфейсов Callable и Future мы можем получать значения от потоков (как от обычных методов)
public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<Integer> future =executorService.submit(new Callable<Integer>() {//Завели переменную параметризованного
            //интерфейса Future кторый позволяет получать что-либо из потока благогодоря методу get(),
            // создали анонимный класс на интерфейсе Callable этот интерфейс параметризованный (мы должны указать тип
            // возвращаемого значения)
                        @Override
            public Integer call() throws Exception {//метод Call() в отличие от метода run() (который void) позволяет
                //что-либо возвращать.
                System.out.println("Starting");
                Thread.sleep(500);
                System.out.println("Finished");
                Random random =new Random();
                int randomValue=random.nextInt();
                if(randomValue<5)
                {throw new Exception ("Получили число меньше 5");}//создали исключение на случай если наше число меньше 5
                return random.nextInt();//возвращаем целое число
            }
        });
        executorService.shutdown();
        try {
            int result=future.get();//получили значение (или исключение). Метод get() выдает два исключения (см. ниже). Тут благодоря
            // методу get()  мы останавливаемся в главном потоке и дожидаемся выполнения нашего потока.
            System.out.println(result);//выводим значение на экран
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {//ловим созданное нами исключение
            Throwable ex=e.getCause();//получаем наше исключение которое является объектом класса Throwable
            // при помощи метода getCause()
            System.out.println(ex.getMessage());//выводим сообщение исключения на экран
        }

    }
}
