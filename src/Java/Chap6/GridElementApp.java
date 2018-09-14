import java.util.Map;
import java.util.HashMap;

public class GridElementApp {
	static HashMap<Character, Integer> getGridVar(char arr[][], HashMap<Character, Integer> m, int size) {
		if (size > 0) {
			int i = arr[0].length - 1;
			while (i >= 0) {
				if (!m.containsKey(arr[i][size - 1])) {
					m.put(arr[i][size - 1], 0);
				}
				m.put(arr[i][size - 1], m.get(arr[i][size - 1]) + 1);
				i--;
			}
			getGridVar(arr, m, size - 1);
		}
		return m;
	}
	public static void main(String[] args) {
		char arr[][] = {{'0', '1', ' '}, {'2', '3', '5'}, {'5', '6', '0'}};
		HashMap<Character, Integer> m = getGridVar(arr, new HashMap<Character, Integer>(), 3);
		for (Map.Entry e : m.entrySet()) {
			System.out.println("'" + e.getKey() + "'" + "->" + e.getValue()); 
		}
	}
}
