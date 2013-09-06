package com.hm.mindmap;

import java.util.ArrayList;

import objects.SurahParts;
import adapter.SurahDetailsAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import c.CTextView;

public class SurahActivity extends ParentActivity {
	private ImageView circleImg;
	private CTextView percTxt;
	private ImageButton mindmapBtn;
	private ImageButton virtueBtn;
	private ListView surahDetailsList;
	int totalparts = 0;
	int[] parts = { R.drawable.whole_circle, R.drawable.whole_circle1,
			R.drawable.whole_circle2, R.drawable.whole_circle3,
			R.drawable.whole_circle3, R.drawable.whole_circle5,
			R.drawable.whole_circle6, R.drawable.whole_circle7,
			R.drawable.whole_circle8 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_surah);
		super.onCreate(savedInstanceState);
		findViews();
		surahDetailsList.setAdapter(new SurahDetailsAdapter(this,
				new ArrayList<SurahParts>()));
	}

	private void findViews() {
		circleImg = (ImageView) findViewById(R.id.circle_img);
		percTxt = (CTextView) findViewById(R.id.perc_txt);
		mindmapBtn = (ImageButton) findViewById(R.id.mindmap_btn);
		virtueBtn = (ImageButton) findViewById(R.id.virtue_btn);
		surahDetailsList = (ListView) findViewById(R.id.surah_details_list);

		mindmapBtn.setOnClickListener(this);
		virtueBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == mindmapBtn) {
			// Handle clicks for mindmapBtn
		} else if (v == virtueBtn) {
			// Handle clicks for virtueBtn
		} else {
			super.onClick(v);
		}
	}

	public void addToCounter() {
		totalparts++;
		circleImg.setImageResource(parts[totalparts]);
	}

	public void removeFromCounter() {
		totalparts--;
		circleImg.setImageResource(parts[totalparts]);
	}
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.surah, menu);
	// return true;
	// }
	//
}
