package adapter;

import java.util.ArrayList;

import objects.TeamMembers;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hm.mindmap.R;

public class TeamMemberAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<TeamMembers> data;
	private static LayoutInflater inflater = null;

	public TeamMemberAdapter(Activity a, ArrayList<TeamMembers> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inializeValues();

	}

	public int getCount() {
		// return data.size();
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		final TeamMembers TeamMembers = data.get(position);
		ViewHolder holder = null;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_team, null);
			holder = new ViewHolder();

			convertView.setTag(holder);

			holder.nameEt = (TextView) convertView.findViewById(R.id.nameEt);
			holder.positionEt = (TextView) convertView
					.findViewById(R.id.positionEt);

		}
		holder = (ViewHolder) convertView.getTag();

		holder.nameEt.setText(TeamMembers.name);
		holder.positionEt.setText(TeamMembers.position);

		// holder.done_ch.setOnClickListener(new View.OnClickListener() {
		// int p = surahParts.part_num;
		//
		// public void onClick(View v) {
		// CheckBox cb = (CheckBox) v;
		//
		// if (cb.isChecked()) {
		//
		// activity.addToCounter(p);
		// surahParts.done = true;
		// } else {
		// activity.removeFromCounter(p);
		// surahParts.done = false;
		// }
		// }
		// });
		return convertView;
	}

	private void inializeValues() {
		String[] name = activity.getResources().getStringArray(R.array.name);
		String[] pos = activity.getResources().getStringArray(R.array.pos);
		// String[] part_name = activity.getResources().getStringArray(
		// R.array.part_name);

		for (int i = 0; i < name.length; i++) {
			TeamMembers TeamMembers = new TeamMembers();
			// TeamMembers.done = activity.isDone(i);
			TeamMembers.name = name[i];
			TeamMembers.position = pos[i];
			// SurahParts.nameOfPart = part_name[i];

			data.add(TeamMembers);
		}

	}

	void sendMail(String m) {
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				"mailto", "", "info@nabd.mobi"));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT,
				"Requests and comments from Islamiyat Al Majdouie application");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "");
		activity.startActivity(Intent.createChooser(emailIntent, "Send mail"));
	}

	private class ViewHolder {
		ImageView img;
		TextView nameEt;
		TextView positionEt;
		ImageView twitter;
		ImageView facebook;
		ImageView gmail;
		ImageView email;
	}
}
