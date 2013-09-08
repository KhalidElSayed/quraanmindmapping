package business;

import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import data.StoreData;

public class Language {
	//
	private static String language = "en_US";
	public static String lang_ar = "ar";
	public static String lang_en = "en_US";
	public static void setCurrentLocal(Context c) {
		SharedPreferences prefs = c.getSharedPreferences(
				"com.pp.modon", Context.MODE_PRIVATE);
		Locale locale = new Locale(getLanguage());
		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		c.getResources().updateConfiguration(config, null);
		prefs.edit().putString("lang", getLanguage()).commit();
		
	}

	public static String getLanguage() {
		return new StoreData().LoadLanguage();
	}

	public static void setLanguage(String language) {
		Language.language = language;
		new StoreData().SaveLanguage(language);
	}
	
	

}
