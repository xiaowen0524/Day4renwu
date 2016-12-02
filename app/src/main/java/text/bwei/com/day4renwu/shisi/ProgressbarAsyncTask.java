package text.bwei.com.day4renwu.shisi;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 生成类的对象，并调用execte方法之后
 * 首先执行的是onProexecute()方法
 * 其次执行的是doInBackgroup方法
 * @author
 *
 */
public class ProgressbarAsyncTask extends AsyncTask<Integer,Integer,String>{

	private TextView textview;
	private ProgressBar progressBar;

	public ProgressbarAsyncTask(TextView textview, ProgressBar progressBar) {
		super();
		this.textview=textview;
		this.progressBar=progressBar;
		
	}
	/**
	 * 这里Integer参数对应AsyncTask中的第一个参数
	 * 这里的String返回值对应AsyncTask的第三个参数
	 * 该方法并不运行在UI线程中，主要用于异步操作所，所以在该方法中不能对UI当中的空间进行设置和修改
	 * 但是可以调用publishProgress方法触发onProgressUpdata对UI进行操作
	 */
	@Override
	protected String doInBackground(Integer... params) {
		NetOperator netOperator=new NetOperator();
		int i=0;
		for (i = 10; i < 100; i+=10) {
			netOperator.operator();
			//更新实时进度
			publishProgress(i);
		}
		return i+params[0].intValue()+"";
	}
	/**
	 * 这里的String参数对应的AsyncTask中的第三个参数（也就是接收doInbackground的返回值）
	 * 在doInBackground方法执行结束之后运行，并且运行在线程当中，可以对UI控件进行设置
	 */
	@Override
	protected void onPostExecute(String result) {
		textview.setText("异步操作执行结束"+result);
	}
	/**
	 * 该方法运行在UI线程当中，并且可以对UI控件进行设置
	 */
	@Override
	protected void onPreExecute() {
		textview.setText("开始执行异步线程");
	}
	/**
	 * 这里的Integer参数对应AsyncTask中的第二个参数
	 * 在doInBackground方法中，每次调用publishprogress方法都会触发onprogressUpdata执行
	 * onProgressUpdata 是在UI线程中执行，所以可以对UI控件进行操作
	 */
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
	}

	
}
