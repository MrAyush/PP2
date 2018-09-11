class CircleSuicide {
    private CircularCurrent alivePeoples;
    private CircularCurrent deadPeoples;
    private int totalPeople;
    private int increase;

    CircleSuicide(int total, int increase) {
        totalPeople = total;
        this.increase = increase;
        alivePeoples = new CircularCurrent();
        deadPeoples = new CircularCurrent();
    }

    public void setAlivePeoples(CircularCurrent alivePeoples) {
        this.alivePeoples = alivePeoples;
    }

    public void setDeadPeoples(CircularCurrent deadPeoples) {
        this.deadPeoples = deadPeoples;
    }

    public CircularCurrent getAlivePeoples() {
        return alivePeoples;
    }

    public CircularCurrent getDeadPeoples() {
        return deadPeoples;
    }

    CircleSuicide setSuicideCircle() {
        int i = 1;
        while(i <= totalPeople) {
            alivePeoples.insertRight(i, 0);
            i++;
        }
        alivePeoples.reset();
        return this;
    }

    CircleSuicide eliminatePeople() {
        int i = 1;
        int j;
        while(i < totalPeople) {
            j = 1;
            while(j <= increase) {   //1 2 3 4 5 6 7
                if (!alivePeoples.moveRight()) {
                    alivePeoples.reset();
                }
                j++;
            }
            deadPeoples.insertRight(alivePeoples.delete().getIData(), 0);
            i++;
        }
        deadPeoples.reset();
        setAlivePeoples(alivePeoples);
        setDeadPeoples(deadPeoples);
        return this;
    }
}

public class CircleSuicideApp {
    public static void main(String[] args) {
        CircleSuicide suicide = new CircleSuicide(20, 4);
        suicide.setSuicideCircle().eliminatePeople().getAlivePeoples().displayInts();
    }
}
