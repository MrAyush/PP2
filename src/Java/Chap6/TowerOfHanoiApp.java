class TowerOfHanoi {
    private int nDisks;
    private char from;
    private char to;
    private char temp;

    TowerOfHanoi(int nDisks) {
        this(nDisks, 'A', 'B', 'C');
    }

    TowerOfHanoi(int nDisks, char from, char temp, char to) {
        this.nDisks = nDisks;
        this.from = from;
        this.to = to;
        this.temp = temp;
    }

    void doTowers() {
        doTowers(nDisks, from, temp, to);
    }

    private void doTowers(int nDisks, char from, char temp, char to) {
        if (nDisks == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(nDisks -1, from, to, temp);
            System.out.println("Disk " + nDisks + " from " + from + " to " + to);
            doTowers(nDisks -1, temp, from, to);
        }
    }

}

public class TowerOfHanoiApp {
    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi(3);
        tower.doTowers();
    }
}
