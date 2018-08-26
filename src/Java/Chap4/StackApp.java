class StackApp {
    private DeQueue deQueue;

    StackApp(int s) // constructor
    {
        deQueue = new DeQueue(s);
    }

    void push(char j) // put item on top of stack
    {
        deQueue.insertLeft(j);
    }

    char pop() {
        return deQueue.removeLeft();
    }

    char peek() {
        return deQueue.peekLeft();
    }

    boolean isEmpty() {
        return deQueue.isEmpty();
    }
    void display(){
        deQueue.display();
    }

    boolean isFull() {
        return deQueue.isFull();
    }

    public static void main(String[] args) {
        StackApp s = new StackApp(10);
        System.out.println(s.isEmpty());
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        char c = s.pop();
        System.out.println(c);
        s.pop();
        System.out.println(s.peek());
        s.pop();
        s.pop();
        s.display();
        System.out.println(s.isFull());
    }
}
