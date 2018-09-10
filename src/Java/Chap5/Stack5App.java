class Stack5
{
    public final static String INT = "int";
    public final static String DOUBLE = "double";
    private CircularCurrent link;
    private boolean isInt;

    Stack5() {
        this(INT);
    }

    Stack5(String type) {
        isInt = type.equals(INT);
        link = new CircularCurrent();
    }

    void push(int iData) {
        if (isInt)
            push(iData, 0);
        else
            push(0, iData);
    }

    void push(double dData) {
        if (isInt)
            push((int)dData, 0);
        else
            push(0, dData);
    }

    private void push(int iData, double dData) {
        link.insertRight(iData, dData);
    }

    CircularLink pop() {
        return link.delete();
    }

    boolean isEmpty() {
        return link.isEmpty();
    }

    void display() {
        if (isEmpty())
            System.out.println("Stack is empty");
        if (isInt)
            link.displayInts();
        else
            link.displayDoubles();
    }
}

public class Stack5App
{
    public static void main(String[] args) {
        Stack5 stack5 = new Stack5(Stack5.INT);
        stack5.push(1);
        stack5.push(2);
        stack5.push(3);
        stack5.push(4);
        stack5.push(5);
        stack5.display();
    }
}
