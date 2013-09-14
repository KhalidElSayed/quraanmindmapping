package com.hm.mindmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.uxlyapps.quaranmindmap.R;
public class AboutAppActivity extends ParentActivity {
	private Button vote;
	private Button useApp;
	private Button share;
	private Button team;
	private Button feedback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.activity_about_app);
		super.onCreate(savedInstanceState);
		findViews();
	}

	private void findViews() {
		vote = (Button) findViewById(R.id.vote);
		useApp = (Button) findViewById(R.id.useApp);
		share = (Button) findViewById(R.id.share);
		team = (Button) findViewById(R.id.team);
		feedback = (Button) findViewById(R.id.feedback);

		vote.setOnClickListener(this);
		useApp.setOnClickListener(this);
		share.setOnClickListener(this);
		team.setOnClickListener(this);
		feedback.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == vote) {
			// Handle clicks for vote
		} else if (v == useApp) {
			startActivity(new Intent(getApplicationContext(), HowToUseActivity.class));
		} else if (v == share) {
			// Handle clicks for share
		} else if (v == team) {
			startActivity(new Intent(getApplicationContext(), AboutTeamActivity.class));
		} else if (v == feedback) {
			// Handle clicks for feedback
		} else {
			super.onClick(v);
		}

	}
}
