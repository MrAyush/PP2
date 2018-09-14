public class StarRecursionApp {

	public static void star(int n) {
		if (n == -1) {
			System.out.println("");
		} else {
			System.out.print("*");
			star(n - 1);
		}
	}
	
	public static void colStar(int m) {
		if (m == -1)
			return;
		else
			colStar(m - 1);
		star(m - 1);
	}
	
	public static void main(String[] args) {
		colStar(2);
	}
}
