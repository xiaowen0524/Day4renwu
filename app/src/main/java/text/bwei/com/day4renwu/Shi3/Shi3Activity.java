package text.bwei.com.day4renwu.Shi3;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import text.bwei.com.songjieou.R;

public class Shi3Activity extends AppCompatActivity {
    //新建一个handler
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将runnable加载到handler的线程队列中去
        //  handler.post(r);
        Thread t = new Thread(r);
        t.start();
        setContentView(R.layout.activity_shi3);
        //打印activtiy线程信息
        System.out.println("activity_id---->" + Thread.currentThread().getId());
        System.out.println("activity_name---->" + Thread.currentThread().getName());
    }

    Runnable r = new Runnable() {
        public void run() {
            // TODO Auto-generated method stub
            //打印新建线程信息
            System.out.println("handler_id---->" + Thread.currentThread().getId());
            System.out.println("handler_name---->" + Thread.currentThread().getName());
            //延时10s，为了观察主界面中内容出现的时间
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

    };

}