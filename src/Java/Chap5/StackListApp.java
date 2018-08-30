class StackList {
    final static String INT = "int";
    final static String DOUBLE = "double";
    private boolean isInt;
    private LinkList list;

    StackList(String type) {
        isInt = type.equals(INT);
        list = new LinkList();
    }

    void push(int iData) {
        if (isInt)
            list.insertFirst(iData, 0.0);
    }

    void push(double dData) {
        if (!isInt)
            list.insertFirst(0, dData);
    }

    Link pop() {
        if (isEmpty())
            System.out.println("Stack is empty");
        return list.deleteFirst();
    }

    Link peek() {
        if (isEmpty())
            System.out.println("Stack is empty");
        return list.getFirst();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    void display() {
        if (isEmpty())
            System.out.println("Stack is empty");
        if (isInt)
            list.displayInts();
        else
            list.displayDoubles();
    }
}

public class StackListApp {

    public static void main(String[] args) {
        StackList list = new StackList(StackList.INT);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.pop().displayInt();
        list.peek().displayInt();
        list.display();
    }
}
