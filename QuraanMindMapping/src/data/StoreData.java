package data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.hm.mindmap.App;

public class StoreData {
	private static final String Language = "Lang";
	private Context context;
	String DATABASE_NAME = "com.hm.mindmap";
	private String phoneNumber = "PNUM";
	private String register = "REG";
	private String report_tut = "report_tut";
	private String list_tut = "list_tut";
	private SharedPreferences sharedPreferences;
	private Editor editor;


	public StoreData() {
		super();
		this.context = App.context;
		sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
				Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
	}

	public void SavePhoneNumber(String value) {
		editor.putString(phoneNumber, value);
		editor.commit();
	}

	public String LoadPhoneNumber() {

		String strSavedMem1 = sharedPreferences.getString(phoneNumber, "");
		return strSavedMem1;

	}

	public void SaveLanguage(String value) {

		editor.putString(Language, value);
		editor.commit();
	}

	public String LoadLanguage() {

		String strSavedMem1 = sharedPreferences.getString(Language, "ar");
		return strSavedMem1;

	}

	public void SaveRegister(boolean reg) {

		editor.putBoolean(register, reg);
		editor.commit();
	}

	public boolean LoadRegister() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(register, false);
		return strSavedMem1;

	}
	public void SaveFirstViewReport(boolean reg) {

		editor.putBoolean(report_tut, reg);
		editor.commit();
	}

	public boolean LoadFirstViewReport() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(report_tut, true);
		return strSavedMem1;

	}
	public void SaveFirstViewList(boolean reg) {

		editor.putBoolean(list_tut, reg);
		editor.commit();
	}

	public boolean LoadFirstViewList() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(list_tut, true);
		return strSavedMem1;

	}
}
