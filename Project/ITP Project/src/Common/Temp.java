package Common;

public class Temp {

	private static String studentID;
	private static String userAccount;
	private static String username;

	public static String getStudentID() {
		return studentID;
	}

	public static void setStudentID(String studentID) {
		Temp.studentID = studentID;
	}

	public static String getUserAccount() {
		return userAccount;
	}

	public static void setUserAccount(String userAccount) {
		Temp.userAccount = userAccount;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Temp.username = username;
	}
}
