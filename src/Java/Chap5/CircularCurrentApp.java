class CircularCurrent
{
	private CircularLink current;
	
	CircularCurrent() {
		current = null;
	}
	
	boolean isEmpty() {
		return current == null;
	}
	
	void insertLeft(int iData, double dData) {
		if (isEmpty()) {
			current = new CircularLink(iData, dData);
		} else {
			current.previous = new CircularLink(iData, dData);
		}
	}
	
	void insertRight(int iData, double dData) {
		if (isEmpty()) {
			current = new CircularLink(iData, dData);
		} else {
			current.next = new CircularLink(iData, dData);
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
			} else {
				current.previous.next = current.next;
				current.next.previous = current.previous;
				current = current.next;
			}
			return temp;
		}
	}
}

class CircularCurrentApp
{
	public static void main(String[] args) {
	
	}
}
