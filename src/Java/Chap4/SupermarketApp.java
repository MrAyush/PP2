import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Supermarket {
    private Queue queue[];
    private int nQueue;

    Supermarket(int nQueue, int size) {
        queue = new Queue[nQueue];
        this.nQueue = nQueue;
        for (int i = 0; i < nQueue; i++) {
            queue[i] = new Queue(size);
        }
    }

    void enqueue(int items) {
        int queueItems = Integer.MAX_VALUE;
        int fastQueue = -1;
        for (int i = 0; i < nQueue; i++) {
            if (isQueueEmpty(i)) {
                queue[i].insert(items);
                System.out.println("Adding to queue " + (i + 1));
                return;
            } else {
                if (isQueueFull(i)) {
                    System.out.println("Queue " + i + 1 + " is full!!");
                } else {
                    if (queueItems > queue[i].getItemSum()) {
                        queueItems = queue[i].getItemSum();
                        fastQueue = i;
                    }
                }
            }
        }
        if (fastQueue != -1) {
            queue[fastQueue].insert(items);
            System.out.println("Adding to queue " + (fastQueue + 1));
        }
    }

    void dequeue(int position) {
        System.out.println("Processing queue " + (position + 1));
        try {
            if (position >= 0 && position < nQueue && !isQueueEmpty(position)) {
                TimeUnit.MILLISECONDS.sleep(2000L + queue[position].peekFront() * 100);
                queue[position].remove();
                System.out.println("Customer successfully removed from " + (position + 1));
            } else {
                if (isQueueEmpty(position)) {
                    System.out.println("Nobody is in the queue.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void display(int position) {
        if (!queue[position].isEmpty()) {
            queue[position].display();
        }
    }

    private boolean isQueueEmpty(int position) {
        return queue[position].isEmpty();
    }

    private boolean isQueueFull(int position) {
        return queue[position].isFull();
    }
}

public class SupermarketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket supermarket = new Supermarket(3, 5);
        while (true) {
            int i;
            System.out.println("Choose any one of the options: ");
            System.out.println("1. To enqueue a customer.");
            System.out.println("2. To dequeue a customer.");
            System.out.println("3. To display a queue.");
            System.out.println("4. To exit..");
            i = scanner.nextInt();
            if (i == 1) {
                System.out.println("Enter the items bought buy the customer: ");
                int items = scanner.nextInt();
                supermarket.enqueue(items);
            } else if (i == 2) {
                System.out.println("Enter the queue number: ");
                int position = scanner.nextInt();
                supermarket.dequeue(position - 1);
            } else if (i == 3) {
                System.out.println("Enter the queue number: ");
                int position = scanner.nextInt();
                supermarket.display(position - 1);
            } else if (i == 4) {
                System.exit(0);
            } else {
                System.out.println("Wrong key pressed");
            }
        }
    }
}
