package c;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.uxlyapps.quaranmindmap.R;

public class PopUpDialog {
	Activity activity;
	private Dialog ErrorDialog;

	public PopUpDialog(Activity activity) {
		super();
		this.activity = activity;
	}

	
	

	public void show(int title,int data) {
		ErrorDialog = new Dialog(activity);
		ErrorDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		ErrorDialog.setContentView(R.layout.tutorial_dialog);
	
		ErrorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
		ErrorDialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ErrorDialog.getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		OnClickListener closeDialog=new OnClickListener() {
			@Override
			public void onClick(View v) {
				ErrorDialog.dismiss();
			}
		};
		TextView title2 = (TextView) ErrorDialog
				.findViewById(R.id.title);
		title2.setText(title);
		TextView info = (TextView) ErrorDialog
				.findViewById(R.id.info);
		info.setText(data);
		ImageButton cancle = (ImageButton) ErrorDialog
				.findViewById(R.id.closeDialog_btn);
		cancle.setOnClickListener(closeDialog);
		ErrorDialog.show();
	}
}
