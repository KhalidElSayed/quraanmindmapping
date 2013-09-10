package com.hm.mindmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity {
	public static String message_key = "com.quaran.message_dialog";
	public static String message_action_btn_text_key = "com.quaran.action_key_dialog";
	public static String message_action_btn_action_key = "com.quaran.action_key_dialog";
	public static final int openVote = 0;
	public static final int openKahf = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Bundle bundle = getIntent().getExtras();
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
			setTheme(android.R.style.Theme_Holo_Dialog_NoActionBar);
		else
			setTheme(android.R.style.Theme_DeviceDefault_Dialog);
		if (bundle==null){//congratulation 
			setContentView(R.layout.congratualation_popup);
			ImageView exit = (ImageView) findViewById(R.id.xButton);
			exit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					finish();
				}
			});
			
			ImageView action = (ImageView) findViewById(R.id.button);
			action.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					//TODO: vote activity

				}
			});
			return ;
		}
		setContentView(R.layout.generic_popup);
		ImageView exit = (ImageView) findViewById(R.id.x);
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
			}
		});
		
		ImageView action = (ImageView) findViewById(R.id.button);
		TextView action_text = (TextView) findViewById(R.id.textView1);
		if (bundle!=null&&bundle.getString(message_action_btn_text_key) != null
				&& !bundle.getString(message_action_btn_text_key).isEmpty()) {
			action_text.setText(bundle.getString(message_action_btn_text_key));
		}
		int actionType =openVote;
		if(bundle!=null)
		actionType=bundle.getInt(message_action_btn_action_key, 0);
		switch (actionType) {
		case openVote: {
			action.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

				}
			});
		}
			break;

		default:
			break;
		}
		TextView content = (TextView) findViewById(R.id.TextContent);
		if (bundle!=null&&bundle.getString(message_key) != null
				&& !bundle.getString(message_key).isEmpty()) {
			content.setText(bundle.getString(message_key));
		}
	
	}


}
