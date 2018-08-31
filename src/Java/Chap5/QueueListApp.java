class QueueList
{
	final static String INT = "int";
	final static String DOUBLE = "double";
	private boolean isInt;
	private DoubleLinkList list;
	
	QueueList(String type) {
		isInt = type.equals(INT);
		list = new DoubleLinkList();
	}
	
	void insert(int iData) {
		if (isInt)
			list.insertLast(iData, 0.0);
	}
	
	void insert(double dData) {
		if (!isInt)
			list.insertLast(0, dData);
	}
	
	Link delete() {
		if (isEmpty())
			System.out.println("Queue is empty");
		return list.deleteFirst();
	}
	
	Link peek() {
		if (isEmpty())
			System.out.println("Queue is empty");
		return list.getLast();
	}
	
	boolean isEmpty() {
		return list.isEmpty();
	}
	
	void display() {
	        if (isEmpty())
        	    System.out.println("Queue is empty");
        	if (isInt)
        	    list.displayInts();
        	else
        	    list.displayDoubles();
    	}
}

class QueueListApp
{

	public static void main(String[] args) {
		QueueList list = new QueueList(QueueList.INT);
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.delete();
		list.display();
	}
}
