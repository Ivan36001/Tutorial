package Многопоточность;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDeadLock {
    public static void main(String[] args) throws InterruptedException {
     Runner1 runner=new Runner1();

     Thread thread1=new Thread(new Runnable() {
         @Override
         public void run() {
             runner.firstThread();
         }
     });
     Thread thread2=new Thread(new Runnable() {
         @Override
         public void run() {
             runner.secondThread();
         }
     });
     thread1.start();
     thread2.start();

     thread1.join();
     thread2.join();

     runner.finished();

    }
}
class Runner1 {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();


    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();//лок для account1
            lock2.lock();//лок для account2
            try {Account.transfer(account1, account2, random.nextInt(100));}finally {//метод transfer одновременно
                //использует два объекта account1 и account2 поэтому для синхронизации потоков эти два объекта должен
                //использовать одновременно только один поток
                lock1.unlock();//гарантируем выполнение unlock() даже если transfer() выдаст исключение
                lock2.unlock();
            }

        }
    }

    public  void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();//ЕСЛИ ТУТ ВНАЧАЛЕ ВЗЯТЬ ЛОК2 А ПОТОМ ЛОК1 ТО ПЕРВЫЙ ПОТОК ВОЗЬМЕТ ЛОК1, ВТОРОЙ ПОТОК ВОЗЬМЕТ
            //ЛОК2 И НА ЭТОМ ВЫПОЛНЕНИЕ ПРОГРАММЫ ПРИЕКРАТИТСЯ ТАК КАК ПЕРВЫЙ ПОТОК НЕ ОДТАСТ ВТОРОМУ ЛОК1 А ВТОРОЙ ПОТОК
            //НЕ ОТДАСТ ПЕРВОМУ ЛОК2-ЭТО DEADlOCK. Первый способ избежать deadlock-а это брать локи в потоках в одном
            //и том же порядке (как тут).Если всеже необходимо брать локи в разных порядках нужно использовать метод trylock()
            //см. не след. странице
            lock2.lock();
            try {Account.transfer(account2, account1, random.nextInt(100));}finally {//вызываем статический метод
                // через название класса
                lock1.unlock();//всегда нужно выполнять в finnally блоке для гарантии выполнения unlock() даже если
                // transfer() выдаст исключение
                lock2.unlock();
            }
        }
    }
        public void finished () {
            System.out.println(account1.getBalance());
            System.out.println(account2.getBalance());
            System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
        }
    }

    class Account {//эмулируем работу с банковскими счетами
        private int balance = 10000;//баланс на счете

        public void deposit(int amount) {//пополнение счета
            balance += amount;//<=> balance=balance+amount
        }

        public void withdraw(int amount) {//списание со счета
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }

        public static void transfer(Account acc1, Account acc2, int amount) {//перемещение денег с счета на счет
            acc1.withdraw(amount);//списываем деньги с одного счета
            acc2.deposit(amount);//записываем на другой счет
        }
    }
