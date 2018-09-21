import java.util.ArrayList;

class Selection {
    private int count;
    private int teamSize;
    private int groupSize;
    private boolean[] isSelected;
    private ArrayList<String> list;

    Selection(int teamSize, int groupSize) {
        this.groupSize = groupSize;
        this.teamSize = teamSize;
        isSelected = new boolean[teamSize];
        list = new ArrayList<>();
        count = 0;
    }

    ArrayList<String> getSelection() {
        getSelection(-1, 0);
        return list;
    }

    private void getSelection(int len, int k) {
        if (len < teamSize) {
            if (groupSize == k) {
                display();
            }
            len++;
            if (len < teamSize) isSelected[len] = true;
            getSelection(len, k + 1);
            if (len < teamSize) isSelected[len] = false;
            getSelection(len, k);
        }
    }

    void display() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < teamSize; i++) {
            if (isSelected[i])
                s.append(i).append(" ");
        }
        if (!list.contains(s.toString())) {
            list.add(s.toString());
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SelectionApp {
    public static void main(String[] args) {
        Selection selection = new Selection(15, 7);
        ArrayList<String> list = selection.getSelection();
        System.out.println("Total possible selections : " + selection.getCount());
        for (String s : list) {
            System.out.println(s);
        }

    }
}
