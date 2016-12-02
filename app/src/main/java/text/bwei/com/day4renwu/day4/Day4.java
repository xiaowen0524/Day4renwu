package text.bwei.com.day4renwu.day4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1.version:线程之间传递数据
 * 2.date:2016/12/2 18:49
 * 3.update:2016/12/2.
 * 4.autour:张玉杰
 */
public class Day4 {
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;
    //关闭标记
    private volatile boolean isShutDown;

    public void start() {
        logger.start();
    }

    public void stop() {
        isShutDown = true;
        logger.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
    }

    public Day4() {
        queue = new LinkedBlockingQueue<String>();
        logger = new LoggerThread();
    }

    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    if (isShutDown)
                        break;
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class GetData {
        private final ExecutorService executor = Executors.newSingleThreadExecutor();

        public Future<String> getData() {
            return executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("my data!");
                    return "hello world!";
                }
            });
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        GetData data = new GetData();
        Future<String> future = data.getData();

        //做其他事情
        System.out.println("do something!");

        String str = future.get();
        System.out.println(str);
    }
}