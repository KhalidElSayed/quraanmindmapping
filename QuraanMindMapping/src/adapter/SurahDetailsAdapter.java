package adapter;

import java.util.ArrayList;

import objects.SurahParts;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.hm.mindmap.R;
import com.hm.mindmap.SurahActivity;

public class SurahDetailsAdapter extends BaseAdapter {

	private SurahActivity activity;
	private ArrayList<SurahParts> data;
	private static LayoutInflater inflater = null;

	public SurahDetailsAdapter(SurahActivity a, ArrayList<SurahParts> d) {
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

		SurahParts surahParts;
		ViewHolder holder = null;
		surahParts = data.get(position);
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_surah_parts, null);
			holder = new ViewHolder();

			convertView.setTag(holder);
			holder.done_ch = (CheckBox) convertView.findViewById(R.id.done_ch);
			holder.part_name_txt=(TextView) convertView.findViewById(R.id.part_name_txt);
			holder.to_txt=(TextView) convertView.findViewById(R.id.to_txt);
			holder.from_txt=(TextView) convertView.findViewById(R.id.from_txt);
			holder.done_ch.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					CheckBox cb = (CheckBox) v;
					if (cb.isChecked()) {
						activity.addToCounter();
					} else {
						activity.removeFromCounter();
					}
				}
			});
		}
		holder = (ViewHolder) convertView.getTag();
		holder.done_ch.setChecked(surahParts.done);
		holder.part_name_txt.setText(surahParts.nameOfPart);
		holder.from_txt.setText(surahParts.fromAyah);
		holder.to_txt.setText(surahParts.toAyah);

		return convertView;
	}

	private void inializeValues() {
		String[] from = activity.getResources().getStringArray(R.array.from);
		String[] to = activity.getResources().getStringArray(R.array.to);
		String[] part_name = activity.getResources().getStringArray(
				R.array.part_name);

		for (int i = 0; i < part_name.length; i++) {
			SurahParts SurahParts = new SurahParts();
			SurahParts.done = false;
			SurahParts.fromAyah = from[i];
			SurahParts.toAyah = to[i];
			SurahParts.nameOfPart = part_name[i];
			data.add(SurahParts);
		}

	}

	private class ViewHolder {
		TextView from_txt;
		TextView to_txt;
		TextView part_name_txt;
		CheckBox done_ch;
	}
}
