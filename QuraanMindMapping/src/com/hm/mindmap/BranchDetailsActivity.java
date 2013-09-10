package com.hm.mindmap;

import utitles.HoloCircleSeekBar;
import utitles.HoloCircleSeekBar.OnCircleSeekBarChangeListener;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class BranchDetailsActivity extends Activity implements
		OnCompletionListener, OnCircleSeekBarChangeListener {

	private ImageButton btnPlay;
	private MediaPlayer mp;
	private HoloCircleSeekBar songProgressBar;
	private Handler mHandler = new Handler();
	public static Context CONTEXT;
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.branch_details);
		songProgressBar = (HoloCircleSeekBar) findViewById(R.id.picker);
		songProgressBar.setOnSeekBarChangeListener(this);
		btnPlay = (ImageButton) findViewById(R.id.btnPlay);
		CONTEXT = this;
		position = getIntent().getExtras().getInt("pos");
		btnPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isPlaying()) {
					btnPlay.setImageResource(R.drawable.btn_play);
					mp.pause();
					mHandler.removeCallbacks(mUpdateTimeTask);
				} else {
					try {
						btnPlay.setImageResource(R.drawable.btn_pause);
						mp.start();
						updateProgressBar();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		switch (position) {
		case 0:
			mp = MediaPlayer.create(this, R.raw.kahf1);
			break;
		case 1:
			mp = MediaPlayer.create(this, R.raw.kahf2);
			break;
		case 2:
			mp = MediaPlayer.create(this, R.raw.kahf3);
			break;
		case 3:
			mp = MediaPlayer.create(this, R.raw.kahf4);
			break;
		case 4:
			mp = MediaPlayer.create(this, R.raw.kahf5);
			break;
		case 5:
			mp = MediaPlayer.create(this, R.raw.kahf6);
			break;
		case 6:
			mp = MediaPlayer.create(this, R.raw.kahf7);
			break;
		case 7:
			mp = MediaPlayer.create(this, R.raw.kahf8);
			break;
		default:
			break;
		}

		// mp = MediaPlayer.create(this, R.raw.su18);
		mp.setLooping(true); // Set looping
		mp.setOnCompletionListener(this);
		initWebView();
	}

	private void initWebView() {
		WebView webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.addJavascriptInterface(new JSInterface(), "jsinterface");

		webView.loadUrl("file:///android_asset/html/sample_1_8.html");

		webView.setBackgroundColor(0x00000000);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isPlaying() {
		return mp.isPlaying();
	}

	@Override
	public void onProgressChanged(HoloCircleSeekBar seekBar, int progress,
			boolean fromUser) {

	}

	public int progressToTimer(int progress, int totalDuration) {
		int currentDuration = 0;
		totalDuration = (int) (totalDuration / 1000);
		currentDuration = (int) ((((double) progress) / 100) * totalDuration);

		// return current duration in milliseconds
		return currentDuration * 1000;
	}

	public void updateProgressBar() {
		mHandler.postDelayed(mUpdateTimeTask, 100);
	}

	private Runnable mUpdateTimeTask = new Runnable() {
		public void run() {
			long totalDuration = mp.getDuration();
			long currentDuration = mp.getCurrentPosition();

			// Updating progress bar
			int progress = (int) (getProgressPercentage(currentDuration,
					totalDuration));
			// Log.d("Progress", ""+progress);
			songProgressBar.setPosition(progress);
			// Running this thread after 100 milliseconds
			mHandler.postDelayed(this, 1000);
		}
	};

	public int getProgressPercentage(long currentDuration, long totalDuration) {
		Double percentage = (double) 0;

		long currentSeconds = (int) (currentDuration / 1000);
		long totalSeconds = (int) (totalDuration / 1000);

		// calculating percentage
		percentage = (((double) currentSeconds) / totalSeconds) * 100;

		// return percentage
		return percentage.intValue();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (mp != null)
			mp.release();
		mHandler.removeCallbacks(mUpdateTimeTask);

	}

	@Override
	public void onStartTrackingTouch(HoloCircleSeekBar seekBar, int progress,
			boolean fromUser) {
		mHandler.removeCallbacks(mUpdateTimeTask);
	}

	@Override
	public void onStopTrackingTouch(HoloCircleSeekBar seekBar, int progress,
			boolean fromUser) {

		mHandler.removeCallbacks(mUpdateTimeTask);
		int totalDuration = mp.getDuration();
		int currentPosition = progressToTimer(progress, totalDuration);
		mp.seekTo(currentPosition);
		updateProgressBar();
	}
}
