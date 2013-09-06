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

	}

	public int getCount() {
		// return data.size();
		return 7;
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
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row_surah_parts, null);
			holder = new ViewHolder();

			// TextView complaint_no = (TextView)
			// vi.findViewById(R.id.ProblemNoTxt);
			// TextView complaint_date = (TextView)
			// vi.findViewById(R.id.CreationDateTxt);
			// TextView complaintxt = (TextView)
			// vi.findViewById(R.id.complaintxt);
			holder.done_ch = (CheckBox) convertView.findViewById(R.id.done_ch);
			// surahParts=data.get(position);
			convertView.setTag(holder);

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
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	private class ViewHolder {
		TextView code;
		CheckBox done_ch;
	}
}
