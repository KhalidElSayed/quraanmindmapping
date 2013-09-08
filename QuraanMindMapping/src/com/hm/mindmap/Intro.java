package com.hm.mindmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import business.Registration;

public class Intro extends ParentActivity implements ViewFactory,
		OnClickListener {
	// s s
	// test pushs
	private ImageSwitcher iSwitcher;
	int[] pics = { R.drawable.ic_launcher, R.drawable.ic_launcher };
	int[] bullets = { R.drawable.off, R.drawable.on };
	// ImageButton next, perv;
	// ImageView moveLeft_img;
	// TextView intro_title;
	Button start_btn;
	ImageView[] bullets_img = new ImageView[2];
	int current = 0;
	private int downX;
	private int upX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		// Language.setCurrentLocal(getApplicationContext());
		Registration.isRegistred(true);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		iSwitcher = (ImageSwitcher) findViewById(R.id.ImageSwitcher);
		iSwitcher.setFactory(this);
		iSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
		iSwitcher.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					downX = (int) event.getX();
					// Log.i("event.getX()", " downX " + downX);
					return true;
				}

				else if (event.getAction() == MotionEvent.ACTION_UP) {
					upX = (int) event.getX();
					// Log.i("event.getX()", " upX " + downX);
					if (upX - downX > 100) {

						// curIndex current image index in array viewed by user
						current--;
						if (current >= 0) {
							iSwitcher.setImageResource(pics[current]);
						} else {
							current = 0;
						}

						// iSwitcher.setInAnimation(AnimationUtils.loadAnimation(Intro.this,android.R.anim.slide_in_left));
						// iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(Intro.this,android.R.anim.slide_out_right));

						// GalleryActivity.this.setTitle(curIndex);
					}

					else if (downX - upX > -100) {

						current++;
						if (current < 3) {
							iSwitcher.setImageResource(pics[current]);
						} else {
							current = 2;
						}

						// iSwitcher.setInAnimation(AnimationUtils.loadAnimation(Intro.this,android.R.anim.slide_out_right));
						// iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(Intro.this,android.R.anim.slide_in_left));

						// GalleryActivity.this.setTitle(curIndex);
					}
					checkImageLocation();
					return true;
				}
				checkImageLocation();
				return false;
			}
		});
		iSwitcher.setImageResource(pics[0]);
		bullets_img[0] = (ImageView) findViewById(R.id.bullets_img1);
		bullets_img[1] = (ImageView) findViewById(R.id.bullets_img2);

		start_btn = (Button) findViewById(R.id.start_btn);
		start_btn.setOnClickListener(this);
		checkImageLocation();
	}

	@Override
	public View makeView() {
		ImageView iView = new ImageView(this);
		// iView.setScaleType(ImageView.ScaleType.FIT_START);
		// if(Language.getLanguage().equals(Language.lang_ar))
		iView.setScaleType(ImageView.ScaleType.FIT_END);
		iView.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		// iView.setBackgroundColor(0xFF000000);
		return iView;
	}

	@Override
	public void onClick(View v) {

		if (v == start_btn) {
			Intent i = new Intent(getApplicationContext(), SurahActivity.class);
			startActivity(i);
			finish();
		}
	}

	private void checkImageLocation() {

		if (current == 0) {

			bullets_img[0].setImageResource(bullets[1]);
			bullets_img[1].setImageResource(bullets[0]);

		} else if (current == pics.length - 1) {

			bullets_img[0].setImageResource(bullets[0]);
			bullets_img[1].setImageResource(bullets[0]);

		} else {
			// moveLeft_img.setVisibility(View.GONE);
			bullets_img[0].setImageResource(bullets[0]);
			bullets_img[1].setImageResource(bullets[1]);

		}
	}

}
