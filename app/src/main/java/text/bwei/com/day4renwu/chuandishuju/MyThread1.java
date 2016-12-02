package text.bwei.com.day4renwu.chuandishuju;

/**
 * 1.version:
 * 2.date:2016/12/2 19:07
 * 3.update:2016/12/2.
 * 4.autour:张玉杰
 */
public class MyThread1 extends Thread {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
        Thread thread = new MyThread1("world");
        thread.start();
    }
}