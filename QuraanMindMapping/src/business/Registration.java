package business;

import data.StoreData;

public class Registration {
	public static boolean isRegistred() {

	//	 return new StoreData().LoadRegister();
		// return false;
		return true;
	}

	public static String getRegisteredPhone() {
		// return new StoreData().LoadPhoneNumber();
	return "0540614448";// 40783
//		 return "0";
	}

	public static void isRegistred(boolean b) {
		new StoreData().SaveRegister(b);
	}

	public static void savePhone(String b) {
		new StoreData().SavePhoneNumber(b);
	}
}
