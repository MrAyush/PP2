class PriorityQueue
{
	private DoubleLinkList list;
	final static String INT = "int";
	final static String DOUBLE = "double";
	private boolean isInt;
	
	PriorityQueue(String type) {
		if (type.equals(DOUBLE))
			isInt = false;
		else
			isInt = true;
		list = new DoubleLinkList();
	}
	
	boolean isEmpty() {
		return list.isEmpty();
	}
	
	void insert(int iData) {
		if (isInt)
			insert((int)iData, 0);
		else
			insert(0, (double) iData);
	}
	
	void insert(double dData) {
		if (isInt)
			insert((int)dData, 0);
		else
			insert(0, (double) dData);
	}
	
	private void insert(int iData, double dData) {
		list.insertLast(iData, dData);
	}
	
	Link delete() {
		if (isEmpty()) {
			return null;
		} else {
			if (isInt)
				return deleteByInt();
			else
				return deleteByDouble();
		}
	}
	
	private Link deleteByInt() {
		Link l = list.sortByInt().deleteFirst();
		l.displayInt();
		return l;
	}
	
	private Link deleteByDouble() {
		Link l = list.sortByDouble().deleteFirst();
		l.displayDouble();
		return l;
	}
	
	void display() {
		if (isEmpty()) {
			return;
		} else {
			if (isInt)
				displayByInts();
			else
				displayByDoubles();
		}
	}
	
	private void displayByInts() {
		list.sortByInt().displayInts();
	}
	
	private void displayByDoubles() {
		list.sortByDouble().displayDoubles();
	}
	
	Link peek() {
		if (isEmpty()) {
			System.out.println("Nothing is in the queue");
			return new Link();
		} else {
			if (isInt)
				return peekByInt();
			else
				return peekByDouble();
		}
	}
	
	private Link peekByInt() {
		return list.sortByInt().getFirst();
	}
	
	private Link peekByDouble() {
		return list.sortByDouble().getFirst();
	}
}

class PriorityQueueApp
{
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(PriorityQueue.INT);
			pq.insert(2);
			pq.insert(1);
			pq.insert(3);
			pq.insert(4);
			pq.insert(5);
			pq.display();
			pq.delete();
			pq.peek();
			pq.delete();
			pq.display();
	}
}
