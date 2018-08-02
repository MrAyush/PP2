package Java.Chap4;

class DeQueue {
    private char[] arr;
    private int left;
    private int right;
    private int maxSize;
    private int nItems;

    DeQueue(int s) {
        maxSize = s;
        arr = new char[maxSize];
        nItems = 0;
        left = 0;
        right = 0;
    }

    boolean isFull() {
        return (nItems == maxSize - 1);
    }

    boolean isEmpty() {
        return (nItems == 0);
    }

    void insertLeft(char c) {
        if (isFull()) {
            System.out.println("\nQueue is full.\n");
        } else {
            left--;
            if (left < 0)
                left = maxSize - 1;
            arr[left] = c;
            nItems++;
        }
    }

    char removeLeft() {
        if (isEmpty()) {
            System.out.println("\nNothing to delete.\n");
        }
        nItems--;
        return arr[left++];
    }

    void insertRight(char c) {
        if (isFull()) {
            System.out.println("\nQueue is full.\n");
        } else {
            if (right > maxSize - 1)
                right = 0;
            arr[right++] = c;
            nItems++;
        }
    }

    char removeRight() {
        if (isEmpty()) {
            System.out.println("\nNothing to delete.\n");
        }
        nItems--;
        return arr[--right];
    }

    char peekRight() {
        return arr[right - 1];
    }

    char peekLeft() {
        return arr[left];
    }

    void display() {
        for (int i = 0; i < nItems; i++) {
            System.out.println(arr[i]);
        }
    }
}

public class DeQueueApp {
    public static void main(String[] args) {
        DeQueue d = new DeQueue(10);
        d.insertRight('1');
        d.insertRight('2');
        d.insertRight('3');
        d.insertRight('4');
        d.removeRight();
        d.removeRight();
        d.removeRight();
        d.insertRight('5');
        d.display();
    }
}
