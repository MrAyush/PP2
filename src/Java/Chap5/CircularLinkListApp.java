class CircularLink {
    private LinkBeans beans;
    CircularLink next;
    CircularLink previous;

    CircularLink() {
        beans = new LinkBeans();
        next = previous = null;
    }

    CircularLink(int iData, double dData) {
        beans = new LinkBeans(iData, dData);
        next = previous = null;
    }

    boolean isEmpty() {
        return next == null;
    }

    void display() {
        System.out.println("(Int - '" + beans.getIData() + "', Double - '" + beans.getDData() + "')");
    }

    void displayInt() {
        System.out.println(" " + beans.getIData() + " ");
    }

    void displayDouble() {
        System.out.println(" " + beans.getDData() + " ");
    }

    void setIData(int iData) {
        beans.setIData(iData);
    }

    void setDData(double dData) {
        beans.setDData(dData);
    }

    int getIData() {
        return beans.getIData();
    }

    double getDData() {
        return beans.getDData();
    }

    boolean checkByInt(int iData) {
        return iData == beans.getIData();
    }

    boolean checkByDouble(double dData) {
        return dData == beans.getDData();
    }
}

class CircularLinkList {
    final static String REVERSE = "reverse";
    final static String DEFAULT = "default";
    private CircularLink first;
    private CircularLink last;

    CircularLinkList() {
        first = null;
        last = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insertFirst(int iData, double dData) {
        CircularLink list = new CircularLink(iData, dData);
        if (isEmpty())
            last = list;
        else
            first.previous = list;
        list.next = first;
        first = list;
    }

    CircularLink deleteFirst() {
        CircularLink temp = first;
        first = first.next;
        first.previous = null;
        if (isEmpty()) {
            last = null;
        }
        return temp;
    }

    void insertLast(int iData, double dData) {
        CircularLink list = new CircularLink(iData, dData);
        if (isEmpty())
            insertFirst(iData, dData);
        else {
            list.previous = last;
            last.next = list;
            last = list;
        }
    }

    CircularLink deleteLast() {
        CircularLink temp = last;
        if (isEmpty())
            return null;
        last = last.previous;
        last.next = null;
        return temp;
    }

    void insertAt(int pos, int iData, double dData) {
        int i = 1;
        if (pos == 1) {
            insertFirst(iData, dData);
            return;
        }
        if (isEmpty()) {
            System.out.println("List is empty");
            insertLast(iData, dData);
        } else {
            CircularLink list = new CircularLink(iData, dData);
            CircularLink temp = first;
            CircularLink pTemp = first;
            while (i < pos) {
                if (temp.isEmpty()) {
                    System.out.println("Link is not that big, Adding the value to the last of list.");
                    insertLast(iData, dData);
                    return;
                }
                pTemp = temp;
                temp = temp.next;
                i++;
            }
            list.next = temp;
            temp.previous = list;
            list.previous = pTemp;
            pTemp.next = list;
        }
    }

    CircularLink findByInt(int iData) {
        CircularLink temp = first;

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

    CircularLink findByDouble(double dData) {
        CircularLink temp = first;

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
        CircularLink temp = findByInt(iData);
        CircularLink pTemp = first;
        if (temp != null) {
            System.out.println("Deleted...");
            if (temp == first) {
                deleteFirst();
                return true;
            }
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            if (pTemp.next == last) {
                last = pTemp;
                last.next = null;
            } else {
                pTemp.next = temp.next;
                temp.next.previous = pTemp;
                temp.next = null;
                temp.previous = null;
            }
        } else {
            System.out.println("Deletion failed...");
            return false;
        }
        return true;
    }

    boolean deleteByDouble(double dData) {
        System.out.println("Finding...");
        CircularLink temp = findByDouble(dData);
        CircularLink pTemp = first;
        if (temp != null) {
            System.out.println("Deleted...");
            if (temp == first) {
                deleteFirst();
                return true;
            }
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            if (pTemp.next == last) {
                last = pTemp;
                last.next = null;
            } else {
                pTemp.next = temp.next;
                temp.next.previous = pTemp;
                temp.next = null;
                temp.previous = null;
            }
        } else {
            System.out.println("Deletion failed...");
            return false;
        }
        return true;
    }

    void display() {
        display(DEFAULT);
    }

    void display(String Type) {
        CircularLink temp = (Type.equals(DEFAULT)) ? first : last;
        while (temp != null) {
            temp.display();
            temp = (Type.equals(DEFAULT)) ? temp.next : temp.previous;
        }
    }
}

class CircularLinkListApp {

    public static void main(String[] args) {
        CircularLinkList list = new CircularLinkList();
        list.insertFirst(1, 1.1);
        list.insertFirst(2, 2.2);
        list.insertFirst(3, 3.3);
        list.insertFirst(4, 4.4);
        list.insertFirst(5, 5.5);
//        list.deleteFirst().display();
        list.insertLast(6, 6.6);
        list.insertLast(7, 7.7);
//        list.deleteLast().display();
        list.insertAt(7, 8, 8.8);
//        list.display(CircularLinkList.REVERSE);
//        list.display(CircularLinkList.DEFAULT);
        list.display();
        list.findByInt(5);
        list.findByDouble(2.2);
        list.deleteByInt(5);
        list.deleteByDouble(6.6);
        list.display();
    }
}
