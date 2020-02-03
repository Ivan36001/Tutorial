package Многопоточность;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
    //ИСПОЛЬЗОВАНИЕ TRYLOCK() ДЛЯ ИЗБЕЖАНИЯ DEADLOCK
class ThreadDeadLock2 {
    public static void main(String[] args) throws InterruptedException {
        Runner2 runner=new Runner2();

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
class Runner2 {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;


        while (true) {//бесконечный цикл из которого выходим только если есть 2 лока  ЭТО КОНСТРУКЦИЯ ДЛЯ ИЗБЕГАНИЯ DEADLOCK
            try {
                firstLockTaken = lock1.tryLock();//пытается получить лок, если лок получен, то возвращает true
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {//если оба лока есть (true && true)
                    return;
                }
                if (firstLockTaken) {//если есть первый лок
                    lock1.unlock();
                }
                if (secondLockTaken) {//если есть второй лок
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);//даем возможность потокам передать локи
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1,lock2);//проверка на наличие локов,если оба есть:продолжаем выполнение
            try {Account.transfer(account1, account2, random.nextInt(100));}finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public  void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2,lock1);//БЕРЕМ ЛОКИ В ДРУГОМ ПОРЯДКЕ
            try {Account.transfer(account2, account1, random.nextInt(100));}finally {
                lock1.unlock();
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

class Account1 {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}//Если использовать synchronized (один вложенный в другой) так сделать нельзя. Т.е. если мы хотим использовать локи в разных порядках в разных
//потоках необходимо использовать класс ReentrantLock() и его метод tryLock().
