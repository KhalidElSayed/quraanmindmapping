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

import com.uxlyapps.quaranmindmap.R;

public class TeamMemberAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<TeamMembers> data;
	private static LayoutInflater inflater = null;
	int images[] = { R.drawable.elham, R.drawable.hala, R.drawable.awady,
			R.drawable.hemdan, R.drawable.sherif };

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
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.nameEt = (TextView) convertView.findViewById(R.id.nameEt);
			holder.positionEt = (TextView) convertView
					.findViewById(R.id.positionEt);
			holder.email = (ImageView) convertView.findViewById(R.id.email);
			holder.twitter = (ImageView) convertView.findViewById(R.id.twitter);
			holder.facebook = (ImageView) convertView
					.findViewById(R.id.facebook);
			holder.positionEt = (TextView) convertView
					.findViewById(R.id.positionEt);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.img.setImageResource(TeamMembers.photo);
		holder.nameEt.setText(TeamMembers.name);
		holder.positionEt.setText(TeamMembers.position);

		holder.email.setOnClickListener(new View.OnClickListener() {
			String p = TeamMembers.email;

			public void onClick(View v) {
				sendMail(p);

			}
		});
		holder.facebook.setOnClickListener(new View.OnClickListener() {
			String p = TeamMembers.facebook;

			public void onClick(View v) {
				OpenLink(p);

			}
		});
		holder.twitter.setOnClickListener(new View.OnClickListener() {
			String p = TeamMembers.twitter;

			public void onClick(View v) {
				OpenLink(p);

			}
		});
		return convertView;
	}

	private void inializeValues() {
		String[] name = activity.getResources().getStringArray(R.array.name);
		String[] pos = activity.getResources().getStringArray(R.array.pos);
		String[] fb = activity.getResources().getStringArray(R.array.fb);
		String[] linked = activity.getResources()
				.getStringArray(R.array.linked);
		String[] mail = activity.getResources().getStringArray(R.array.mail);

		for (int i = 0; i < name.length; i++) {
			TeamMembers TeamMembers = new TeamMembers();
			// TeamMembers.done = activity.isDone(i);
			TeamMembers.name = name[i];
			TeamMembers.position = pos[i];
			TeamMembers.facebook = fb[i];
			TeamMembers.email = mail[i];
			TeamMembers.twitter = linked[i];
			TeamMembers.photo = images[i];
			// SurahParts.nameOfPart = part_name[i];

			data.add(TeamMembers);
		}

	}

	void sendMail(String m) {
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				"mailto", "", m));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "");
		activity.startActivity(Intent.createChooser(emailIntent, "Send mail"));
	}

	void OpenLink(String l) {
		activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(l)));
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
