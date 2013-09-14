package com.hm.mindmap;

import java.util.ArrayList;

import objects.TeamMembers;
import adapter.TeamMemberAdapter;
import android.os.Bundle;
import android.widget.ListView;
import com.uxlyapps.quaranmindmap.R;

public class AboutTeamActivity extends ParentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.activity_about_team);
		super.onCreate(savedInstanceState);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new TeamMemberAdapter(this, new ArrayList<TeamMembers>()));
	}

}
