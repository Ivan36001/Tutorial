package Многопоточность;
//второй способ создания потока
public class Thread2 {
    public static void main(String[] args) {
        Thread thread=new Thread( new Runner());//новый объект класса Runner реализующий
        //логику метода run() помещаем в качестве аргумента в конструктор потока
        thread.start();
        System.out.println("Привет из потока main");//программа не завершит свою работу пока на окончится
        //выполнение всех потоков, в данном случае поток main завершит свою работу, а мой поток продолжит выполнение
    }
}



class Runner implements Runnable {//реализуем интерфейс (преопределяем метод)
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);//заставляет поток уснуть принимает на вход время в миллисикундах
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Привет из моего потока" + i);

        }
    }
}