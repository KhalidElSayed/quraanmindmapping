package com.hm.mindmap;

import android.os.Bundle;
import android.view.View;
import c.PopUpDialog;
import com.uxlyapps.quaranmindmap.R;

public class MindMapActivity extends ParentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.activity_mind_map);
		super.onCreate(savedInstanceState);
		findViewById(R.id.help).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new PopUpDialog(MindMapActivity.this).show(
						R.string.mindmap_tit, R.string.mindmap_data);
			}
		});
	}

}
