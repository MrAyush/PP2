class CircularLink
{
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

class CircularLinkList
{
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
	
	void display() {
		CircularLink temp = first;
		while (temp != null) {
			temp.display();
			temp = temp.next;
		}	
	}
}

class CircularLinkListApp
{
	
	public static void main(String[] args) {
		CircularLinkList list = new CircularLinkList();
		list.insertFirst(1, 1.1);
		list.insertFirst(2, 2.2);
		list.insertFirst(3, 3.3);
		list.insertFirst(4, 4.4);
		list.insertFirst(5, 5.5);
		list.deleteFirst();
		list.display();
	}
}
