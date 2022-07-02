package b;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.graphics.Typeface;
import android.view.Gravity;
import android.os.Handler;
import android.content.Intent;
import android.graphics.Color;

public class a extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
		LinearLayout layout = new LinearLayout(this);
		tv title = new tv(this,"Jack N Poy");
		tv sub = new tv(this,"Developed by MPOP Reverse II");
		
		layout.setBackgroundColor(Color.parseColor("#ffffffff"));
		
		layout.setOrientation(LinearLayout.VERTICAL);
		
		title.setTextSize(35);
		sub.setTextSize(20);
		
		title.setTypeface(a("a"));
		sub.setTypeface(a("a"));
		
		title.setTextColor(Color.parseColor("#ff187dff"));
		sub.setTextColor(Color.parseColor("#ff181f2f"));
		
		title.setShadowLayer(5,3,3,Color.parseColor("#ff181f2f"));
		sub.setShadowLayer(5,3,3,Color.parseColor("#ff187dff"));
		
		layout.setGravity(Gravity.CENTER);
		title.setGravity(Gravity.CENTER);
		sub.setGravity(Gravity.CENTER);
		
		layout.addView(title);
		layout.addView(sub);
		
		new Handler().postDelayed(new Runnable(){
				@Override
				public void run() {
					startActivity(new Intent(a.this,b.class));
					finish();
				}
			}, 3500);
		
		setContentView(layout);
	}
	Typeface a(String _){
		try{
			return Typeface.createFromAsset(getAssets(),_);
		}catch(Exception a){
			return Typeface.SERIF;
		}
	}
}
