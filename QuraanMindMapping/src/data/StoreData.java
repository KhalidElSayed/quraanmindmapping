package data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.hm.mindmap.App;

public class StoreData {
	private static final String Language = "Lang";
	private static final String P8 = "P8";
	private static final String P7 = "P7";
	private static final String P6 = "P6";
	private static final String P5 = "P5";
	private static final String P4 = "P4";
	private static final String P3 = "P3";
	private static final String P2 = "P2";
	private static final String P1 = "P1";
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
	public void SaveP1(boolean p) {

		editor.putBoolean(P1, p);
		editor.commit();
	}

	public boolean LoadP1() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P1, false);
		return strSavedMem1;

	}
	public void SaveP2(boolean p) {

		editor.putBoolean(P2, p);
		editor.commit();
	}

	public boolean LoadP2() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P2, false);
		return strSavedMem1;

	}
	public void SaveP3(boolean p) {

		editor.putBoolean(P3, p);
		editor.commit();
	}

	public boolean LoadP3() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P3, false);
		return strSavedMem1;

	}
	public void SaveP4(boolean p) {

		editor.putBoolean(P4, p);
		editor.commit();
	}

	public boolean LoadP4() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P4, false);
		return strSavedMem1;

	}
	public void SaveP5(boolean p) {

		editor.putBoolean(P5, p);
		editor.commit();
	}

	public boolean LoadP5() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P5, false);
		return strSavedMem1;

	}
	public void SaveP6(boolean p) {

		editor.putBoolean(P6, p);
		editor.commit();
	}

	public boolean LoadP6() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P6, false);
		return strSavedMem1;

	}
	public void SaveP7(boolean p) {

		editor.putBoolean(P7, p);
		editor.commit();
	}

	public boolean LoadP7() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P7, false);
		return strSavedMem1;

	}
	public void SaveP8(boolean p) {

		editor.putBoolean(P8, p);
		editor.commit();
	}

	public boolean LoadP8() {

		boolean strSavedMem1 = sharedPreferences.getBoolean(P8, false);
		return strSavedMem1;

	}
}
