package com.hm.mindmap;

import java.util.ArrayList;

import objects.SurahParts;
import utitles.Utilities;
import adapter.SurahDetailsAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import c.CTextView;
import c.PopUpDialog;
import data.StoreData;
import com.uxlyapps.quaranmindmap.R;

public class SurahActivity extends ParentActivity {
	private ImageView circleImg;
	private CTextView percTxt;
	private ImageButton mindmapBtn;
	private ImageButton virtueBtn, aboutus_btn;
	private ListView surahDetailsList;
	int totalparts = 0;
	StoreData data = new StoreData();
	int[] parts = { R.drawable.whole_circle, R.drawable.whole_circle1,
			R.drawable.whole_circle2, R.drawable.whole_circle3,
			R.drawable.whole_circle4, R.drawable.whole_circle5,
			R.drawable.whole_circle6, R.drawable.whole_circle7,
			R.drawable.whole_circle8 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_surah);
		super.onCreate(savedInstanceState);
		findViews();
		surahDetailsList.setAdapter(new SurahDetailsAdapter(this,
				new ArrayList<SurahParts>()));
		for (int i = 0; i < parts.length; i++) {
			if (isDone(i))
				totalparts++;

		}
		surahDetailsList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
						Intent i = new Intent(getApplicationContext(),
								BranchDetailsActivity.class);
						i.putExtra("pos", pos);
						startActivity(i);
						// startActivity(new Intent(getApplicationContext(),
						// BranchDetailsActivity.class));

					}
				});
		circleImg.setImageResource(parts[totalparts]);

		percTxt.setText(getPercetage());

		Utilities.generateRandomMotiviation(this);
	}

	private void findViews() {
		circleImg = (ImageView) findViewById(R.id.circle_img);
		percTxt = (CTextView) findViewById(R.id.perc_txt);
		mindmapBtn = (ImageButton) findViewById(R.id.mindmap_btn);
		virtueBtn = (ImageButton) findViewById(R.id.virtue_btn);
		aboutus_btn = (ImageButton) findViewById(R.id.aboutus_btn);
		surahDetailsList = (ListView) findViewById(R.id.surah_details_list);

		mindmapBtn.setOnClickListener(this);
		virtueBtn.setOnClickListener(this);
		aboutus_btn.setOnClickListener(this);
	}

	private CharSequence getPercetage() {
		Double d = (double) (totalparts * 100 / (parts.length - 1));
		return Math.round(d) + " %";
	}

	@Override
	public void onClick(View v) {
		if (v == mindmapBtn) {
			//
			startActivity(new Intent(getApplicationContext(),
					MindMapActivity.class));
		} else if (v == virtueBtn) {
			new PopUpDialog(this).show(R.string.virtue_tit,
					R.string.virtue_data);
		} else if (v == aboutus_btn) {
			startActivity(new Intent(getApplicationContext(),
					AboutAppActivity.class));
		} else {
			super.onClick(v);
		}
	}

	public void addToCounter(int i) {
		if (totalparts < parts.length - 1)
			totalparts++;
		circleImg.setImageResource(parts[totalparts]);
		percTxt.setText(getPercetage());
		updateParts(i, true);
	}

	public void removeFromCounter(int i) {
		if (totalparts > 0)
			totalparts--;
		circleImg.setImageResource(parts[totalparts]);
		percTxt.setText(getPercetage());
		updateParts(i, false);
	}

	private void updateParts(int i, boolean b) {
		switch (i) {
		case 0:
			data.SaveP1(b);
			break;
		case 1:
			data.SaveP2(b);
			break;
		case 2:
			data.SaveP3(b);
			break;
		case 3:
			data.SaveP4(b);
			break;
		case 4:
			data.SaveP5(b);
			break;
		case 5:
			data.SaveP6(b);
			break;
		case 6:
			data.SaveP7(b);
			break;
		case 7:
			data.SaveP8(b);
			break;
		default:
			break;
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.surah, menu);
	// return true;
	// }
	//

	public boolean isDone(int i) {
		switch (i) {
		case 0:
			return data.LoadP1();

		case 1:
			return data.LoadP2();

		case 2:
			return data.LoadP3();

		case 3:
			return data.LoadP4();

		case 4:
			return data.LoadP5();

		case 5:
			return data.LoadP6();

		case 6:
			return data.LoadP7();

		case 7:
			return data.LoadP8();

		default:
			return false;
		}

	}

}
