import java.util.Arrays;

class DeQueue {
    private char[] arr;
    private int left;
    private int right;
    private int maxSize;
    private int nItems;

    DeQueue(int s) {
        maxSize = s;
        arr = new char[maxSize];
        Arrays.fill(arr, ' ');
        nItems = 0;
        left = 0;
        right = 0;
    }

    boolean isFull() {
        return (nItems == maxSize);
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
        char c = arr[left];
        arr[left] = ' ';
        left++;
        return c;
    }

    void insertRight(char c) {
        if (isFull()) {
            System.out.println("\nQueue is full.\n");
        } else {
            if (right > maxSize)
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
        right--;
        char c = arr[right];
        arr[right] = ' ';
        return arr[right];
    }

    char peekRight() {
        return arr[right - 1];
    }

    char peekLeft() {
        return arr[left];
    }

    void display() {
        for (int i = 0; i < maxSize; i++) {
            if (arr[i] != ' ')
            	System.out.println(arr[i]);
        }
    }
}

public class DeQueueApp {
    public static void main(String[] args) {
        DeQueue d = new DeQueue(10);
        d.insertRight('1');
        d.insertRight('2');
        d.insertLeft('6');
        d.removeRight();
        d.removeRight();
        d.display();
    }
}
