package b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class b extends Activity {
	RelativeLayout base;
	LinearLayout layout;
	Button play,settings,about,exit;
	SharedPreferences sp;
	TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		base = new RelativeLayout(this);
		layout = new LinearLayout(this);
		title = new TextView(this);
		play = new Button(this);
		settings = new Button(this);
		about = new Button(this);
		exit = new Button(this);
		ShapeDrawable button = new ShapeDrawable(new RoundRectShape(new float[]{15,15,15,15,15,15,15,15},null,null));
		
		button.getPaint().setColor(Color.parseColor("#ff187dff"));
		
		//button.getPaint().setShadowLayer(15,5,5,Color.parseColor("#ff181f2f"));
		
		base.setGravity(Gravity.CENTER);
		layout.setGravity(Gravity.CENTER);
		title.setGravity(Gravity.CENTER);
		
		base.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		layout.setPadding(5,5,5,5);
		title.setPadding(0,0,0,50);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		
		title.setText("Jack N\' Poy");
		play.setText("Play Now");
		settings.setText("Turn voice: " + (sp.getBoolean("voice",true) ? "on" : "off"));
		about.setText("About");
		exit.setText("Exit");
		
		title.setTextSize(50);
		
		title.setTypeface(a("a"));
		play.setTypeface(a("a"));
		settings.setTypeface(a("a"));
		about.setTypeface(a("a"));
		exit.setTypeface(a("a"));
		
		title.setTextColor(Color.parseColor("#ff187dff"));
		play.setTextColor(Color.parseColor("#ffffffff"));
		settings.setTextColor(Color.parseColor("#ffffffff"));
		about.setTextColor(Color.parseColor("#ffffffff"));
		exit.setTextColor(Color.parseColor("#ffffffff"));
		
		title.setShadowLayer(5,3,3,Color.parseColor("#ff181f2f"));
		
		base.setBackgroundColor(Color.parseColor("#ffffffff"));
		play.setBackgroundDrawable(button);
		settings.setBackgroundDrawable(button);
		about.setBackgroundDrawable(button);
		exit.setBackgroundDrawable(button);
		
		play.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					startActivity(new Intent(b.this,c.class));
				}
			});
		settings.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					sp.edit().putBoolean("voice",!sp.getBoolean("voice",true)).commit();
					settings.setText("Turn voice: " + (sp.getBoolean("voice",true) ? "on" : "off"));
				}
			});
		about.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					Intent a = new Intent("About");
					a.putExtra("About",View.VISIBLE);
					sendBroadcast(a);
				}
			});
		exit.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					Intent a = new Intent("Confirmation");
					a.putExtra("Confirmation",View.VISIBLE);
					sendBroadcast(a);
				}
			});
		
		layout.addView(title);
		layout.addView(play);
		layout.addView(a());
		layout.addView(settings);
		layout.addView(a());
		layout.addView(about);
		layout.addView(a());
		layout.addView(exit);
		
		base.addView(layout);
		base.addView(dialog("About", "Jack N Poy is a virtual randomized game app developed by MPOP Reverse II. The game is one of the pending projects held on 2020. This is not the first or the second release, the group was already release the first version of the app. Since we share this for free, we never allow anyone who, to sell this. If you wanna modify this, please remove our name in the list, specially avoid to add us in the credits.\nThank you for using/playing our game.\n-MPOP Reverse II", "Close","", new OnClickListener(){
		    @Override
			public void onClick(View p1) {
			    Intent a = new Intent("About");
				a.putExtra("About",View.GONE);
				sendBroadcast(a);
			}
		},null));
		base.addView(dialog("Confirmation", "Are you sure you want to close the app?","Yes","No", new OnClickListener(){
		    @Override
			public void onClick(View p1) {
				finishAffinity();
			}
		}, new OnClickListener(){
		    @Override
			public void onClick(View p1) {
				Intent a = new Intent("Confirmation");
				a.putExtra("Confirmation",View.GONE);
				sendBroadcast(a);
			}
		}));
		setContentView(base);
	}
    View a(){
		View a = new View(this);
		a.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,10));
		a.setBackgroundColor(Color.TRANSPARENT);
		return a;
	}
	View _(){
		itsv a = new itsv(this);
		a.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,5));
		//a.setBackgroundColor(Color.parseColor("#44187dff"));
		return a;
	}
	RelativeLayout dialog(final String title,String mess,String cls,String cls2,OnClickListener click,OnClickListener click2){
		final RelativeLayout h = new RelativeLayout(this);
		final LinearLayout a = new LinearLayout(this);
		tv b = new tv(this,title);
		TextView c = new TextView(this);
		Button d = new Button(this);
		Button e = new Button(this);
		ShapeDrawable f = new ShapeDrawable(new RoundRectShape(new float[]{15,15,15,15,15,15,15,15},null,null));
		ShapeDrawable g = new ShapeDrawable(new RoundRectShape(new float[]{15,15,15,15,15,15,15,15},null,null));
		
		f.getPaint().setColor(Color.parseColor("#ffffffff"));
		g.getPaint().setColor(Color.parseColor("#ff187dff"));
		
		f.getPaint().setShadowLayer(5,0,0,Color.parseColor("#ff181f2f"));
		
		a.setBackgroundDrawable(f);
		d.setBackgroundDrawable(g);
		e.setBackgroundDrawable(g);
		h.setBackgroundColor(Color.parseColor("#aa181f2f"));
		
		a.setOrientation(LinearLayout.VERTICAL);
		
		h.setPadding(8,8,8,8);
		a.setPadding(10,10,10,10);
		c.setPadding(0,10,0,10);
		
		b.setTextColor(Color.parseColor("#ff187dff"));
		c.setTextColor(Color.parseColor("#ff187dff"));
		d.setTextColor(Color.parseColor("#ffffffff"));
		e.setTextColor(Color.parseColor("#ffffffff"));
		
		h.setVisibility(View.GONE);
		
		registerReceiver(new BroadcastReceiver(){
				@Override
				public void onReceive(Context p1, Intent p2) {
					AlphaAnimation alp;
					if(p2.getIntExtra(title,View.GONE) == View.VISIBLE){
						alp = new AlphaAnimation(0f,1f);
					}else{
						alp = new AlphaAnimation(1f,0f);
					}
					alp.setDuration(150);
					h.setAnimation(alp);
					h.setVisibility(p2.getIntExtra(title,View.GONE));
	        	}
			}, new IntentFilter(title));
		
		c.setText(mess);
		d.setText(cls);
		e.setText(cls2);
		
		b.setTextSize(25);
		c.setTextSize(19);
		
		b.setTypeface(a("a"));
		c.setTypeface(a("a"));
		d.setTypeface(a("a"));
		
		a.setGravity(Gravity.CENTER);
		b.setGravity(Gravity.CENTER);
		d.setGravity(Gravity.CENTER);
		h.setGravity(Gravity.CENTER);
		
		a.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		c.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		d.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		e.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		h.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		d.setOnClickListener(click);
		e.setOnClickListener(click2);
		
		h.setOnLongClickListener(new OnLongClickListener(){
				@Override
				public boolean onLongClick(View p1) {
					return false;
				}
			});
		
		a.addView(b);
		a.addView(_());
		a.addView(c);
		a.addView(d);
		if(!cls2.isEmpty()){
	    	a.addView(a());
    		a.addView(e);
		}
		a.addView(a());
		h.addView(a);
		return h;
	}
	Typeface a(String a){
		try{
			return Typeface.createFromAsset(getAssets(),a);
		}catch(Exception _){
			return Typeface.SERIF;
		}
	}
	@Override
	public void onBackPressed() {
		Intent a = new Intent("Confirmation");
		a.putExtra("Confirmation",View.VISIBLE);
		sendBroadcast(a);
	}
	
}
