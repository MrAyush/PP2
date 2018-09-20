public class MathApp {
    private static int mult(int x, int y) {
        if (y == 0)
            return 0;
        else
            return x + mult(x, y - 1);
    }

    private static int power(int x, int y) {
        if (y == 0 || y == 1)
            return x;
        else
            return mult(x, power(x, y - 1));
    }

    public static void main(String[] args) {
        System.out.println(power(8, 2));
    }
}
