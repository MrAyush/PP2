class CircularCurrent {
    private CircularLink current;

    CircularCurrent() {
        current = null;
    }

    boolean isEmpty() {
        return current == null;
    }

    CircularLink getCurrent() {
        return current;
    }

    void insertLeft(int iData, double dData) {
        if (isEmpty()) {
            current = new CircularLink(iData, dData);
        } else {
            CircularLink temp = new CircularLink(iData, dData);
            if (current.previous == null) {
                current.previous = temp;
                temp.next = current;
            } else {
                CircularLink t = current.previous;
                current.previous = temp;
                temp.previous = t;
                temp.next = current;
                t.next = temp;
            }
            current = current.previous;
        }
    }

    void insertRight(int iData, double dData) {
        if (isEmpty()) {
            current = new CircularLink(iData, dData);
        } else {
            CircularLink temp = new CircularLink(iData, dData);
            if (current.next == null) {
                current.next = temp;
                temp.previous = current;
            } else {
                CircularLink t = current.next;
                current.next = temp;
                temp.next = t;
                temp.previous = current;
                t.previous = temp;
            }
            current = current.next;
        }
    }

    CircularLink delete() {
        if (isEmpty())
            return null;
        else {
            CircularLink temp = current;
            if (current.previous == null) {
                current = current.next;
                current.previous = null;
            } else if (current.next == null){
                current = current.previous;
                current.next = null;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current = current.next;
            }
            return temp;
        }
    }

    void reset() {
        while (current.previous != null) {
            current = current.previous;
        }
    }

    void display() {
        CircularLink temp = current;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    void displayInts() {
        CircularLink temp = current;
        while (temp != null) {
            temp.displayInt();
            temp = temp.previous;
        }
    }

    void displayDoubles() {
        CircularLink temp = current;
        while (temp != null) {
            temp.displayDouble();
            temp = temp.previous;
        }
    }

    CircularLink search(int iData) {
        if (isEmpty())
            return null;
        else {
            CircularLink temp = current;
            while(!temp.checkByInt(iData)) {
                temp = temp.next;
                if (temp == null)
                    break;
            }
            if (temp == null) {
                temp = current;
                while(!temp.checkByInt(iData)) {
                    temp = temp.previous;
                    if (temp == null)
                        break;
                }
            }
            return temp;
        }
    }

    CircularLink search(double dData) {
        if (isEmpty())
            return null;
        else {
            CircularLink temp = current;
            while(!temp.checkByDouble(dData)) {
                temp = temp.next;
                if (temp == null)
                    break;
            }
            if (temp == null) {
                temp = current;
                while(!temp.checkByDouble(dData)) {
                    temp = temp.previous;
                    if (temp == null)
                        break;
                }
            }
            return temp;
        }
    }
}

class CircularCurrentApp {
    public static void main(String[] args) {
        CircularCurrent link = new CircularCurrent();
        link.insertRight(1, 1.1);
        link.insertRight(6, 6.6);
        link.insertRight(2, 2.2);
        link.insertRight(3, 3.3);
        link.insertRight(4, 4.4);
        link.insertRight(5, 5.5);
        link.reset();
        link.display();
    }
}
