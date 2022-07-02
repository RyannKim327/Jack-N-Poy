package b;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

public class tv extends TextView {
	String _,a="";
	int __ = 0;
    public tv(Context a,String b){
		super(a);
		_ = b;
		setText("");
		a();
	}
	void a(){
		if(__ < _.length()){
			new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						a += _.charAt(__);
						setText(a);
						__++;
						a();
					}
				}, 75);
		}else{
			new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						__ = 0;
						a = "";
						setText("");
						a();
					}
				}, 5000);
		}
	}
}
