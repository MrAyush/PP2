class LinkBeans {
    // Members variable
    int iData;
    double dData;

    // Constructor
    LinkBeans() {
        iData = 0;
        dData = 0.0;
    }

    LinkBeans(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    // Setters
    void setIData(int iData) {
        this.iData = iData;
    }

    void setDData(double dData) {
        this.dData = dData;
    }

    // Getters
    int getIData() {
        return iData;
    }

    double getDData() {
        return dData;
    }
}

class Link {
    private LinkBeans beans;
    Link next;

    Link() {
        beans = new LinkBeans();
        next = null;
    }

    Link(int iData, double dData) {
        beans = new LinkBeans(iData, dData);
        next = null;
    }

    boolean isEmpty() {
        return next == null;
    }

    void display() {
        System.out.println("(Int - '" + beans.getIData() + "', Double - '" + beans.getDData() + "')");
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

class LinkList {
    private Link first;

    LinkList() {
        first = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    void insertFirst(int iData, double dData) {
        Link newNode = new Link(iData, dData);
        newNode.next = first;
        first = newNode;
    }

    void deleteFirst() {
        first = first.next;
    }

    void insertLast(int iData, double dData) {
        Link temp = new Link(iData, dData);
        if (isEmpty()) {
            first = temp;
        } else {
            Link t = first;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else if (first.next == null) {
            deleteFirst();
        } else {
            Link temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    Link findByInt(int iData) {
        Link temp = first;

        while (!temp.checkByInt(iData)) {
            if (temp.next == null) {
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
            if (temp.next == null) {
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
        Link temp = findByInt(iData);
        Link pTemp = first;
        if (temp != null) {
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            pTemp.next = temp.next;
            return true;
        } else {
            System.out.println("Element not found!! (~_~)");
            return false;
        }
    }

    boolean deleteByDouble(double dData) {
        Link temp = findByDouble(dData);
        Link pTemp = first;
        if (temp != null) {
            while (pTemp.next != temp) {
                pTemp = pTemp.next;
            }
            pTemp.next = temp.next;
            return true;
        } else {
            System.out.println("Element not found!! (~_~)");
            return false;
        }
    }

    void display() {
        Link temp = first;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }
}

public class LinkListApp {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(1, 1.1);
        list.insertFirst(2, 2.2);
        list.insertFirst(3, 3.3);
        list.insertFirst(4, 4.4);
        list.insertLast(5, 5.5);
        list.insertLast(6, 6.6);

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
