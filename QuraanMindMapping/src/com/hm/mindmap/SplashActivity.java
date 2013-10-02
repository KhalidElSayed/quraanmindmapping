package com.hm.mindmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import business.Registration;

import com.pushbots.push.Pushbots;
import com.uxlyapps.quaranmindmap.R;

public class SplashActivity extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 0;
	private String SENDER_ID = "561050736336";
	private String PUSHBOTS_APPLICATION_ID = "5234db6f4deeaed006003434";
	static boolean active;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Pushbots.init(this, SENDER_ID, PUSHBOTS_APPLICATION_ID);
		Pushbots.getInstance().setMsgReceiver(customPushReceiver.class);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 50;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					viewActvity();
				}
				finish();

				// stop();
				// }
			}
		};
		splashTread.start();
	}

	protected void viewActvity() {

		if (Registration.isRegistred()) {

			Intent i = new Intent(getApplicationContext(), SurahActivity.class);

			startActivity(i);
		} else {

			Intent i = new Intent(getApplicationContext(), Intro.class);

			startActivity(i);
		}
		finish();
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.splash, menu);
	// return true;
	// }
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		active = true;
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		active = false;
		super.onStop();
	}

	@Override
	protected void onPause() {
		active = false;
		// TODO Auto-generated method stub
		super.onPause();
	}

}
