class DoubleLinkList {
    private Link first;
    private Link last;

    DoubleLinkList() {
        first = null;
        last = null;
    }

    boolean isEmpty() {
        return first == null;
    }
    
    Link getLast() {
    	return last;
    }

    void insertFirst(int iData, double dData) {
        Link newNode = new Link(iData, dData);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    Link deleteFirst() {
        Link temp = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return temp;
    }

    void insertLast(int iData, double dData) {
        Link temp = new Link(iData, dData);
        if (isEmpty()) {
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else if (first.isEmpty()) {
            deleteFirst();
        } else {
            Link temp = first;
            while (!temp.next.isEmpty()) {
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
        }
    }

    void insertAt(int pos, int iData, double dData) {
        int i = 1;
        if (isEmpty()) {
            System.out.println("List is empty");
            insertFirst(iData, dData);
        } else {
            Link node = new Link(iData, dData);
            Link temp = first;
            Link pTemp = first;
            while (i < pos) {
                if (temp.isEmpty()) {
                    System.out.println("Link is not that big, Adding the value to the last of list.");
                    pTemp = temp;
                    temp = null;
                    break;
                }
                pTemp = temp;
                temp = temp.next;
                i++;
            }
            node.next = temp;
            pTemp.next = node;
            if (pTemp == last) {
                last = node;
            }
        }
    }

    Link findByInt(int iData) {
        Link temp = first;

        while (!temp.checkByInt(iData)) {
            if (temp.isEmpty()) {
                System.out.println("Element not found!! (~_~)");
                return null;
            } else {
                temp = temp.next;
            }
        }
        System.out.println("Element found: ");
        temp.display();
        return temp;
    }

    Link findByDouble(double dData) {
        Link temp = first;

        while (!temp.checkByDouble(dData)) {
            if (temp.isEmpty()) {
                System.out.println("Element not found!! (~_~)");
                return null;
            } else {
                temp = temp.next;
            }
        }
        System.out.println("Element found: ");
        temp.display();
        return temp;
    }

    boolean deleteByInt(int iData) {
        System.out.println("Finding...");
        Link temp = findByInt(iData);
        Link pTemp = first;
        if (temp != null) {
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            if (pTemp.next == last) {
                last = pTemp;
                last.next = null;
            } else {
                pTemp.next = temp.next;
            }
            System.out.println("Deleted");
            return true;
        } else {
            System.out.println("Element not found!! (~_~)");
            return false;
        }
    }

    boolean deleteByDouble(double dData) {
        System.out.println("Finding...");
        Link temp = findByDouble(dData);
        Link pTemp = first;
        if (temp != null) {
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            if (pTemp.next == last) {
                last = pTemp;
                last.next = null;
            } else {
                pTemp.next = temp.next;
            }
            System.out.println("Deleted");
            return true;
        } else {
            System.out.println("Element not found!! (~_~)");
            return false;
        }
    }

    void display() {
        Link temp = first;
        while (temp != last.next) {
            temp.display();
            temp = temp.next;
        }
    }
    
    void displayInts() {
    	Link temp = first;
    	while (temp != last.next) {
    	    temp.displayInt();
    	    temp = temp.next;
    	}
    }
    
    void displayDoubles() {
    	Link temp = first;
    	while (temp != last.next) {
    	    temp.displayDouble();
    	    temp = temp.next;
    	}
    }
}

public class DoubleEndedListApp {
    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();
        list.insertFirst(1, 1.1);
        list.insertFirst(2, 2.2);
        list.insertFirst(3, 3.3);
        list.insertFirst(4, 4.4);
        list.insertLast(5, 5.5);
        list.insertLast(6, 6.6);
        list.insertAt(5, 7, 7.7);
        list.deleteLast();

        list.display();
        list.findByInt(1);
        list.findByDouble(2.2);
        list.findByDouble(2.3);
        list.findByInt(9);

        System.out.println("Deleting two elements");

        list.deleteByInt(1);
        list.deleteByDouble(2.2);
        list.deleteLast();
        list.display();
    }
}
