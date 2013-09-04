package c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnimatedBackGroundObject extends ImageView {

	public AnimatedBackGroundObject(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		AnimationDrawable animationDrawable1 = (AnimationDrawable) getBackground();
				animationDrawable1.start();
		
	}

}
