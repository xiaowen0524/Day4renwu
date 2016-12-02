package text.bwei.com.day4renwu.shisi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import text.bwei.com.songjieou.R;

public class ShisiActivity extends AppCompatActivity {
    private Button button;
    private ProgressBar progressBar;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shisi);
        button = (Button) findViewById(R.id.button1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        textview = (TextView) findViewById(R.id.textView1);

        button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                //在主线程中创建AsyncTask对象，并调用execte()方法。
                ProgressbarAsyncTask asyncTask = new ProgressbarAsyncTask(textview, progressBar);
                asyncTask.execute(1000);
            }
        });
    }


}
