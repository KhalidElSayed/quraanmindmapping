package com.hm.mindmap;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class App extends Application {

	// public static Typeface romanFace;
	// public static Typeface droidFace;
	public static Typeface DroidFace;
	public static Typeface ButtonFace;
	// String Roman_LOCATION_PATH = "fonts/DroidNaskh-Bold.ttf";
	// String droid_LOCATION_PATH = "fonts/droidkufiregular_0.otf";
	String Droid_LOCATION_PATH = "fonts/GS45_Arab_AndroidOS.ttf";
	//String Button_LOCATION_PATH = "fonts/AdobeArabic-Bold.otf";
	public static Context context;	
	public static int move = 0;
	public static int mainGallaryPosition = 0;
	public static int commentNo = 0;
	public static String phoneno = "";
	public static boolean lang_canged = false;
	public static String mCurrentPhotoPath=null;
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getApplicationContext();
		// romanFace = Typeface.createFromAsset(getAssets(),
		// Roman_LOCATION_PATH);
		// droidFace = Typeface.createFromAsset(getAssets(),
		// droid_LOCATION_PATH);
		DroidFace = Typeface.createFromAsset(getAssets(), Droid_LOCATION_PATH);
		ButtonFace = Typeface.createFromAsset(getAssets(), Droid_LOCATION_PATH);
//		DroidFace = Typeface.SERIF;
//		ButtonFace = Typeface.SERIF;
	}

	public static void applyCustomFont(ViewGroup list, Typeface customTypeface) {
		for (int i = 0; i < list.getChildCount(); i++) {
			View view = list.getChildAt(i);
			if (view instanceof ViewGroup) {
				applyCustomFont((ViewGroup) view, customTypeface);
			} else if (view instanceof TextView) {
				((TextView) view).setTypeface(customTypeface);
			}
		}
	}

}
