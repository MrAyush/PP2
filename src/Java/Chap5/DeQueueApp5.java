class DeQueue5
{
	public final static String INT = "int";
	public final static String DOUBLE = "double";
	private DoubleLinkList list;
	private boolean isInt;
	
	DeQueue5() {
		this(INT);
	}
	
	DeQueue5(String type) {
		isInt = type.equals(INT);
		list = new DoubleLinkList();
	}
	
	void insertFirst(int iData) {
		if (isInt) {
			insertFirst(iData, 0);
		} else {
			insertFirst(0, (double) iData);
		}
	}
	
	void insertFirst(double dData) {
		if (isInt) {
			insertFirst((int)dData, 0);
		} else {
			insertFirst(0, dData);
		}
	}
	
	private void insertFirst(int iData, double dData) {
		if (isInt) {
			list.insertFirst(iData, 0.0);
		} else {
			list.insertFirst(0, dData);
		}
	}
	
	void insertLast(int iData) {
		if (isInt) {
			insertLast(iData, 0);
		} else {
			insertLast(0, (double) iData);
		}
	}
	
	void insertLast(double dData) {
		if (isInt) {
			insertLast((int)dData, 0);
		} else {
			insertLast(0, dData);
		}
	}
	
	private void insertLast(int iData, double dData) {
		if (isInt) {
			list.insertLast(iData, 0.0);
		} else {
			list.insertLast(0, dData);
		}
	}
	
	Link deleteFirst() {
		return list.deleteFirst();
	}
	
	Link deleteLast() {
		return list.deleteLast();
	}
	
	void display() {
		if (isInt) {
			list.displayInts();
		} else {
			list.displayDoubles();
		}
	}
	
}

class DeQueueApp5
{
	public static void main(String[] args) {
		DeQueue5 d = new DeQueue5();
		d.insertFirst(2);
		d.insertFirst(3);
		d.insertFirst(4);
		d.insertFirst(5);
		d.deleteLast();
		d.display();
	}
}
