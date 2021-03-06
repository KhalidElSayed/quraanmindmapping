package c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hm.mindmap.App;

public class CTextView extends TextView {
	public CTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CTextView(Context context) {
		super(context);
		init();
	}

	public void init() {
		setTypeface(App.DroidFace, 1);

	}
}
