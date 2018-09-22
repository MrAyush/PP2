import java.util.Arrays;

public class BinaryTreeApp {
    private static String[] tree;

    public static void main(String[] args) {
        int n = 6;
        tree = new String[n];
        Arrays.fill(tree, "");
        makeBranches(0, (int) Math.pow(2, n) - 1, 0);
        display();
    }

    private static void makeBranches(int left, int right, int row) {
        if (left - right == 0) return;
        int mid = (left + right) / 2;
        for (int i = left; i < right; i++) {
            if (i == mid) tree[row] += " X";
            else tree[row] += "-";
        }
        makeBranches(left, mid, row + 1);
        makeBranches(mid + 1, right, row + 1);
    }

    static void display() {
        for (String aTree : tree) {
            System.out.println(aTree);
        }
    }

}
