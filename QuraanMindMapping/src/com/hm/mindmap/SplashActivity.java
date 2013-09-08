package com.hm.mindmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import business.Registration;

public class SplashActivity extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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

}
