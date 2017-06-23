package utils;

public class Utils {

	public static boolean isEmpty(String searchedTerm) {
		for (int i = 0; i < searchedTerm.length(); i++) {
			if (searchedTerm.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}
}
