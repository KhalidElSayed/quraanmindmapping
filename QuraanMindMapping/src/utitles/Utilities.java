package utitles;

import android.content.Context;
import android.content.Intent;

import com.hm.mindmap.PopupActivity;
import com.uxlyapps.quaranmindmap.R;

public class Utilities {
	public static void generateRandomMotiviation(Context mContext) {
		String[] motivations = mContext.getResources().getStringArray(R.array.motivation_popup);
		String motive=motivations[(int) (Math.random()*(motivations.length-1))];
		Intent intent=new Intent(mContext,PopupActivity.class);
		intent.putExtra(PopupActivity.message_key, motive);
		intent.putExtra(PopupActivity.message_action_btn_text_key, mContext.getString(R.string.to_kahf));
		intent.putExtra(PopupActivity.message_action_btn_action_key, PopupActivity.openKahf);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);
		
	}
	public static void generateCongratulationPopup(Context mContext) {
		Intent intent=new Intent(mContext,PopupActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);
		
	}
}
