import java.util.ArrayList;

class Knapsack {
    private int[] weight;
    private ArrayList<Integer> list;

    Knapsack(int[] wt) {
        weight = wt;
        list = new ArrayList<>(weight.length);
    }

    boolean knapsack(int capacity) {
        if (knapsack(weight.length - 1, capacity)) {
            return true;
        } else {
            System.out.println("No solution exists");
            return false;
        }
    }

    private boolean knapsack(int i, int w) {
        boolean isComplete;

        if (i < 0)
            return false;
        if (weight[i] == w) {
            list.add(w);
            return true;
        }
        isComplete = knapsack(i - 1, w);
        if (isComplete)
            return true;
        if (w > weight[i]) {
            isComplete = knapsack(i - 1, w - weight[i]);
            if (isComplete) {
                list.add(weight[i]);
                return true;
            }
            return false;
        }
        return false;
    }

    ArrayList<Integer> getList() {
        return list;
    }
}

public class KnapsackApp {
    public static void main(String[] args) {
        int capacity = 37;
        int[] weight = new int[]{11, 8, 7, 6, 5};
        Knapsack knapsack = new Knapsack(weight);
        System.out.println(knapsack.knapsack(capacity));
        System.out.println(knapsack.getList());
    }
}
