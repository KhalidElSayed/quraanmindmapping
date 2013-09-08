package c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.hm.mindmap.App;

public class CEditText extends EditText {
	public CEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CEditText(Context context) {
		super(context);
		init();
	}

	public void init() {
		setTypeface(App.DroidFace, 1);

	}
}
