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
import android.os.Handler;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
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
import java.util.Locale;
import java.util.Random;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class c extends Activity {
	RelativeLayout base;
    LinearLayout op,usr,main, scorelayout;
	TextView rock,sci,paper,com,yscore,escore,decide;
	int you = 0, enemy = 0;
	String g = "#aa18ff7d",r = "#aaff187d";
	String ag = "#2218ff7d",ar = "#22ff187d";
	SharedPreferences sp;
	TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
		tts();
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		base = new RelativeLayout(this);
		main = new LinearLayout(this);
		op = new LinearLayout(this);
		usr = new LinearLayout(this);
		scorelayout = new LinearLayout(this);
		rock = new TextView(this);
		sci = new TextView(this);
		paper = new TextView(this);
		yscore = new TextView(this);
		escore = new TextView(this);
		decide = new TextView(this);
		com = new TextView(this);

		main.setOrientation(LinearLayout.VERTICAL);
		op.setOrientation(LinearLayout.HORIZONTAL);
		usr.setOrientation(LinearLayout.HORIZONTAL);
		scorelayout.setOrientation(LinearLayout.HORIZONTAL);
		
		op.setGravity(Gravity.CENTER);
		usr.setGravity(Gravity.CENTER);
		rock.setGravity(Gravity.CENTER);
		sci.setGravity(Gravity.CENTER);
		paper.setGravity(Gravity.CENTER);
		com.setGravity(Gravity.CENTER);
		
		main.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		op.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,0.4f));
		usr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,0.4f));
		scorelayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,0.01f));
		
		yscore.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,0.3f));
		escore.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,0.3f));
		decide.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT,0.4f));
		rock.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,0.3f));
		sci.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,0.3f));
		paper.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,0.3f));

		scorelayout.setGravity(Gravity.CENTER);
		scorelayout.setBackgroundColor(Color.parseColor("#ff185faf"));

		yscore.setGravity(Gravity.LEFT | Gravity.CENTER);
		decide.setGravity(Gravity.CENTER);
		escore.setGravity(Gravity.RIGHT | Gravity.CENTER);
		
		yscore.setTextColor(Color.parseColor("#ffffffff"));
		escore.setTextColor(Color.parseColor("#ffffffff"));
		decide.setTextColor(Color.parseColor("#ffffffff"));
		rock.setTextColor(Color.parseColor("#ff000000"));
		sci.setTextColor(Color.parseColor("#ff000000"));
		paper.setTextColor(Color.parseColor("#ff000000"));
		com.setTextColor(Color.parseColor("#ff187dff"));
		
		yscore.setTypeface(a("a"));
		escore.setTypeface(a("a"));
		decide.setTypeface(a("a"));
		
		rock.setText("✊");
		sci.setText("✌️");
		paper.setText("✋");
		yscore.setText(you + " <- You");
		escore.setText("Enemy -> " + enemy);
		decide.setText("Click your choice");
		
		rock.setTextSize(50);
		sci.setTextSize(50);
		paper.setTextSize(50);
		com.setTextSize(50);
		yscore.setTextSize(19);
		escore.setTextSize(19);
		decide.setTextSize(15);
		
		yscore.setPadding(3,0,0,0);
		escore.setPaddingRelative(0,0,3,0);
		
		com.setRotation(180);
		
		rock.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					int a = new Random().nextInt(3);
					int b = 0;
					com.setText(jnp(a));
					a(a,b);
					sci.setVisibility(View.GONE);
					paper.setVisibility(View.GONE);
				}
			});
		sci.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					int a = new Random().nextInt(3);
					int b = 1;
					com.setText(jnp(a));
					a(a,b);
					rock.setVisibility(View.GONE);
					paper.setVisibility(View.GONE);
				}
			});
		paper.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					int a = new Random().nextInt(3);
					int b = 2;
					com.setText(jnp(a));
					a(a,b);
					rock.setVisibility(View.GONE);
					sci.setVisibility(View.GONE);
				}
			});
		op.addView(com);
		
		usr.addView(rock);
		usr.addView(sci);
		usr.addView(paper);
		
		scorelayout.addView(yscore);
		scorelayout.addView(decide);
		scorelayout.addView(escore);
			
		main.addView(op);
		main.addView(scorelayout);
		main.addView(usr);
		
		base.addView(main);
		base.addView(dialog("Exit", "Are you sure you want to get back to the menu?", "Yes", "No", new OnClickListener(){
		    @Override
			public void onClick(View p1) {
				finish();
			}
		}, new OnClickListener(){
		    @Override
			public void onClick(View p1) {
				Intent a = new Intent("Exit");
				a.putExtra("Exit",View.GONE);
				sendBroadcast(a);
			}
		}));
        setContentView(base);
    }
	void a(int a,int b){
		if(sp.getBoolean("voice",true)){
	    	speech("Jack N Poy");
		}
		if(you <= 10 && enemy <= 10){
	    	switch(a){
		    	case 0:
		        	switch(b){
	        			case 1:
			    	    	enemy++;
							op.setBackgroundDrawable(bg(Color.parseColor(g),Color.parseColor(ag)));
		    				usr.setBackgroundDrawable(bg(Color.parseColor(ar),Color.parseColor(r)));
							decide.setText("+1 for the enemy");
		        		break;
		    	    	case 2:
		        			you++;
			    			usr.setBackgroundDrawable(bg(Color.parseColor(ag),Color.parseColor(g)));
		    				op.setBackgroundDrawable(bg(Color.parseColor(r),Color.parseColor(ar)));
							decide.setText("+1 for you");
		        		break;
						default:
						    decide.setText("Its a tie");
						break;
			        }
	    		break;
			    case 1:
		    		switch(b){
		    			case 0:
			    			you++;
				    		usr.setBackgroundDrawable(bg(Color.parseColor(ag),Color.parseColor(g)));
		    				op.setBackgroundDrawable(bg(Color.parseColor(r),Color.parseColor(ar)));
							decide.setText("+1 for you");
		    			break;
		    			case 2:
					    	enemy++;
						    op.setBackgroundDrawable(bg(Color.parseColor(g),Color.parseColor(ag)));
		    				usr.setBackgroundDrawable(bg(Color.parseColor(ar),Color.parseColor(r)));
							decide.setText("+1 for the enemy");
					    break;
						default:
						    decide.setText("Its a tie");
						break;
		    		}
		    	break;
	    		case 2:
			    	switch(b){
				    	case 0:
				    		enemy++;
			    			op.setBackgroundDrawable(bg(Color.parseColor(g),Color.parseColor(ag)));
		    				usr.setBackgroundDrawable(bg(Color.parseColor(ar),Color.parseColor(r)));
							decide.setText("+1 for the enemy");
			    		break;
			    		case 1:
				    		you++;
				    		usr.setBackgroundDrawable(bg(Color.parseColor(ag),Color.parseColor(g)));
		    				op.setBackgroundDrawable(bg(Color.parseColor(r),Color.parseColor(ar)));
							decide.setText("+1 for you");
			    		break;
						default:
						    decide.setText("Its a tie");
						break;
	    			}
		    	break;
	    	}
	    	yscore.setText(you + " <- You");
			escore.setText("Enemy -> " + enemy);
			com.setRotation(180f);
			com.setTextColor(Color.parseColor("#ff000000"));
			if(you <=10 && enemy <= 10){
				yscore.setEnabled(false);
				rock.setEnabled(false);
				sci.setEnabled(false);
				paper.setEnabled(false);
				if(you < 10 && enemy < 10){
		    		new Handler().postDelayed(new Runnable(){
						@Override
						public void run() {
							showall();
						}
			   		}, 750);
				}else{
					yscore.setEnabled(true);
					com.setRotation(180);
					decide.setText((you > enemy ? "You win" : "You lose") + "\nClick to continue");
					if(sp.getBoolean("voice",true)){
					    speech((you > enemy ? "You" : "Your enemy") + " win this game");
					}
					decide.setOnClickListener(new OnClickListener(){
							@Override
							public void onClick(View p1) {
								back2zero();
							}
						});
					if(you > enemy){
						usr.setBackgroundDrawable(bg(Color.parseColor(ag),Color.parseColor(g)));
						op.setBackgroundDrawable(bg(Color.parseColor(r),Color.parseColor(ar)));
					}else{
						usr.setBackgroundDrawable(bg(Color.parseColor(ar),Color.parseColor(r)));
						op.setBackgroundDrawable(bg(Color.parseColor(g),Color.parseColor(ag)));
					}
				}
			}
		}
	}
	String jnp(int a){
		String b;
		switch(a){
			case 0:
				b = "✊";
				break;
			case 1:
				b = "✌️";
				break;
			case 2:
				b ="✋";
				break;
			default:
			    b = "X";
				break;
		}
		return b;
	}
	void showall(){
		op.setBackgroundColor(Color.TRANSPARENT);
		usr.setBackgroundColor(Color.TRANSPARENT);
		
		rock.setVisibility(View.VISIBLE);
		sci.setVisibility(View.VISIBLE);
		paper.setVisibility(View.VISIBLE);
		decide.setText("Click your choice");
		com.setText("");
		
		rock.setEnabled(true);
		sci.setEnabled(true);
		paper.setEnabled(true);
	}
	void back2zero(){
		you = 0;
		enemy = 0;
		showall();
		yscore.setText(you + " <- You");
		escore.setText("Enemy -> " + enemy);
	}
	void tts(){
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener(){
				@Override
				public void onInit(int p1) {
					tts.setLanguage(Locale.ENGLISH);
				}
			});
		tts.setSpeechRate(1);
		tts.setPitch(1);
	}
	void speech(String str){
		tts.speak(str,0,null);
	}
	Typeface a(String str){
		try{
			return Typeface.createFromAsset(getAssets(),str);
		}catch(Exception _){
			return Typeface.SERIF;
		}
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
	View a(){
		View a = new View(this);
		a.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,10));
		a.setBackgroundColor(Color.TRANSPARENT);
		return a;
	}
	View _(){
		itsv a = new itsv(this);
		a.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,5));
		return a;
	}
	Drawable bg(int... a){
		return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, a);
	}
	@Override
	public void onBackPressed() {
		if(you > 0 || enemy > 0){
			Intent a = new Intent("Exit");
			a.putExtra("Exit",View.VISIBLE);
			sendBroadcast(a);
		}else{
			super.onBackPressed();
		}
	}
}
