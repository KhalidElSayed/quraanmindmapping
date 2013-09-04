package com.hm.mindmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ParentActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	Language.setCurrentLocal(getApplicationContext());
//		ImageButton back = (ImageButton) findViewById(R.id.back_btn);
//		if (back != null)
//			back.setOnClickListener(this);
		// setContentView(R.layout.activity_parent);
	}

	@Override
	public void onClick(View v) {
//		int id = v.getId();
//		switch (id) {
//		case R.id.back_btn:
//			finish();
//			break;
//
//		default:
//			break;
//		}

	}

	// @Override
	// public void onStart() {
	// super.onStart();
	//
	// EasyTracker.getInstance().activityStart(this); // Add this
	// // method.
	// }
	//
	// @Override
	// public void onStop() {
	// super.onStop();
	// EasyTracker.getInstance().activityStop(this); // Add this
	// // method.
	// }

}
