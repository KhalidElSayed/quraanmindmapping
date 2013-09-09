package com.hm.mindmap;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class JSInterface {

	public void showInfo(String ayaId) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(
				BranchDetailsActivity.CONTEXT);

		dialog.setTitle("aya info");
		dialog.setIcon(android.R.drawable.ic_dialog_info);
		dialog.setMessage("aya id is: " + ayaId);
		dialog.setNegativeButton("exit", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}
}
