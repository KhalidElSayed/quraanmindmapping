package c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.hm.mindmap.App;

public class CButton extends Button {
	public CButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CButton(Context context) {
		super(context);
		init();
	}

	public void init() {
		setTypeface(App.ButtonFace, 1);

	}
}
