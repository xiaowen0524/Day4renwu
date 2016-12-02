package text.bwei.com.day4renwu.chuandishuju;

/**
 * 1.version:
 * 2.date:2016/12/2 19:08
 * 3.update:2016/12/2.
 * 4.autour:张玉杰
 */
public class MyThread2 implements Runnable {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.setName("world");
        Thread thread = new Thread(myThread);
        thread.start();
    }
}
