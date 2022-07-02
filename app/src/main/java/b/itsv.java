package b;
import android.view.View;
import android.content.Context;
import android.animation.ValueAnimator;
import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.animation.ObjectAnimator;
import android.view.animation.Animation;

public class itsv extends View{
	String r = "#aaff187d", g = "#aa7dff18", b ="#aa187dff";
    public itsv(Context a){
		super(a);
		ValueAnimator v = ObjectAnimator.ofInt(this,"backgroundColor",new int[]{Color.parseColor(r),Color.parseColor(g),Color.parseColor(b)});
		v.setDuration(1500);
		v.setEvaluator(new ArgbEvaluator());
		v.setRepeatCount(Animation.INFINITE);
		v.setRepeatMode(Animation.REVERSE);
		v.start();
	}
}
