package text.bwei.com.day4renwu.shisan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import text.bwei.com.songjieou.R;

public class ShisanActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shisan);
        iv = (ImageView) findViewById(R.id.iv);
        //变大
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        //时间
        sa.setDuration(3000);

        iv.setAnimation(sa);
        //延迟
        iv.postDelayed(new Runnable() {
            public void run() {
                //消失
                iv.setVisibility(View.GONE);
                //销毁
                ShisanActivity.this.finish();
            }
        }, 3000);
    }


}
