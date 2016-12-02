package text.bwei.com.day4renwu.ba;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.version:
 * 2.date:2016/12/2 19:32
 * 3.update:2016/12/2.
 * 4.autour:张玉杰
 */
public class Test_3 {

    class Bank {

        private int account = 100;

        //需要声明这个锁
        private Lock lock = new ReentrantLock();

        public int getAccount() {
            return account;
        }

        /**
         * 用同步方法实现
         */
        //这里不再需要synchronized
        public void save(int money) {
            lock.lock();
            try {
                account += money;

            } finally {
                lock.unlock();
            }
        }

        /**
         * 用同步代码块实现
         */
        public void save1(int money) {
            synchronized (this) {
                account += money;
            }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                // bank.save1(10);
                bank.save(10);
                System.out.println(i + "账户余额为：" + bank.getAccount());
            }
        }

    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);

        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();

        System.out.println("线程2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        Test_3 test = new Test_3();
        test.useThread();
    }

}
