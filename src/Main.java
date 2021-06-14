import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		String[] arr = new String[3];
		arr[0] = "(setf *random-state* \n(make-random-state t))";
		arr[1] = "(pprint \n(random (parse-integer (nth 0 num)))";
		arr[2] = "(defun myprinter (s) \n(pprint s))";
		for (int i = 0; i < arr.length; i++) {
			System.out.println(validate(arr[i], '(', ')'));
		}

	}

	/**
	 * 
	 * @param s string to validate
	 * @param left left left parameter to compare to right
	 * @param right right parameter to compare to left
	 * @return true if the left character appears as often as the right character
	 */
	public static Boolean validate(String s, char left, char right) {
		HashMap<Character, Integer> map = new HashMap<>();
		// char left = '(';
		// char right = ')';
		map.put(left, 0);
		map.put(right, 0);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == left) {
				int temp = map.get(left);
				map.put(left, temp + 1);
			} else if (s.charAt(i) == right) {
				int temp = map.get(right);
				map.put(right, temp + 1);
			}
		}
		if (map.get(left) == map.get(right)) {
			return true;
		} else {
			return false;
		}
	}

}
