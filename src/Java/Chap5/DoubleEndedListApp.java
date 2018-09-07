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
    
    Link getFirst() {
    	return first;
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

    Link deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        } else if (first.isEmpty()) {
            return deleteFirst();
        } else {
            Link temp = first;
            while (!temp.next.isEmpty()) {
                temp = temp.next;
            }
            Link t = temp.next;
            temp.next = null;
            last = temp;
            return t;
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
    
    DoubleLinkList reverse() {
    	if (isEmpty()) {
    		System.out.println("List is empty!! (-_-)");
    		return null;
    	} else if (first.isEmpty()) {
    		System.out.println("List contains only one element");
    	} else {
    		Link t1 = first;
    		Link t2 = first.next;
    		Link t3 = first.next.next;
    		
    		while (t3 != null) {
    			t2.next = t1;
    			t1 = t2;
    			t2 = t3;
    			t3 = t3.next;
    		}
    		t2.next = t1;
    		first.next = null;
    		last = first;
    		first = t2;
    	}
    	return this;
    }
    
    DoubleLinkList sortByInt() {
    	if (isEmpty()) {
    		System.out.println("List is empty!! (-_-)");
    		return null;
    	} else if (first.isEmpty()) {
    		System.out.println("List contains only one element");
    	} else {
    		Link t1 = first;
    		while (t1 != null) {
    			Link t2 = t1.next;
    			while (t2 != null) {
    				if (t2.getIData() <= t1.getIData()) {
    					int t = t2.getIData();
    					double dT = t2.getDData();
    					t2.setIData(t1.getIData());
    					t2.setDData(t1.getDData());
    					t1.setIData(t);
    					t1.setDData(dT);
    				}
    				t2 = t2.next;
    			}
    			t1 = t1.next;
    		}
    	}
    	return this;
    }
    
    DoubleLinkList sortByDouble() {
    	if (isEmpty()) {
    		System.out.println("List is empty!! (-_-)");
    		return null;
    	} else if (first.isEmpty()) {
    		System.out.println("List contains only one element");
    	} else {
    		Link t1 = first;
    		while (t1 != null) {
    			Link t2 = t1.next;
    			while (t2 != null) {
    				if (t2.getDData() <= t1.getDData()) {
    					int t = t2.getIData();
    					double dT = t2.getDData();
    					t2.setIData(t1.getIData());
    					t2.setDData(t1.getDData());
    					t1.setIData(t);
    					t1.setDData(dT);
    				}
    				t2 = t2.next;
    			}
    			t1 = t1.next;
    		}
    	}
    	return this;
    }

    void display() {
	    if (!isEmpty()) {
    	    Link temp = first;
    	    while (temp != last.next) {
    	        temp.display();
    	        temp = temp.next;
    	    }
    	} else {
    		System.out.println("List is Empty");
    	}
    }
    
    void displayInts() {
    	if (!isEmpty()) {
    	    Link temp = first;
    	    while (temp != last.next) {
    	        temp.displayInt();
    	        temp = temp.next;
    	    }
    	} else {
    		System.out.println("List is Empty");
    	}
    }
    
    void displayDoubles() {
		if (!isEmpty()) {
	   	    Link temp = first;
    	    while (temp != last.next) {
    	        temp.displayDouble();
    	        temp = temp.next;
    	    }
    	} else {
    		System.out.println("List is Empty");
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
        list.reverse().display();
        //list.sortByDouble().display();
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
