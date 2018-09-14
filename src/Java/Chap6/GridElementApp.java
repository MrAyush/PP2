import java.util.Map;
import java.util.HashMap;

public class GridElementApp {
	final static int MAX = 10;
	static HashMap<Character, Integer> getGridVar(char arr[][], HashMap<Character, Integer> m, int size) {
		if (size > 0) {
			int i = arr[0].length - 1;
			while (i >= 0) {
				if (!m.containsKey(arr[i][size - 1])) {
					m.put(arr[i][size - 1], 0);
				}
				System.out.println(i + " " + size);
				m.put(arr[i][size - 1], m.get(arr[i][size - 1]) + 1);
				i--;
			}
			getGridVar(arr, m, size - 1);
		}
		return m;
	}
	public static void main(String[] args) {
		char arr[][] = {{'0', '0', ' '}, {'n', '0', ' '}, {' ', 'n', 'n'}};
		HashMap<Character, Integer> m = getGridVar(arr, new HashMap<Character, Integer>(), 3);
		System.out.println(m); 
		/*for (Map.Entry e : m.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue()); 
		}*/
	}
}
