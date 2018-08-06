class PriorityQ
{
	private long arr[];
	private int maxSize;
	private int nElem;
	
	PriorityQ (int s) {
		maxSize = s;
		arr = new long[maxSize];
		nElem = 0;
	}
	
	void insert (long l) {
		arr[nElem] = l;
		nElem++;
	}
	
	long remove () {
		int i = 0;
		if (!isEmpty()) {
			int min = 0;
			for (; i < nElem; i++) {
				if (arr[min] > arr[i])
					min = i;
			}
			long t = arr[nElem - 1];
			arr[nElem - 1] = arr[min];
			arr[min] = t;
			nElem--;
			return arr[min];
		}
		
		return -1;
		
	}
	
	boolean isEmpty() { return (nElem == 0); }
	boolean isFull() { return (nElem == maxSize); }
	
	long peekMin () {
		int i = 0;
		if (!isEmpty()) {
			int min = 0;
			for (; i < nElem; i++) {
				if (arr[min] > arr[i])
					min = i;
			}
			return arr[min];
		}
		return -1;
	}
	public void display() {
		int f = 0, n = nElem;
		while (n > 0) {
			long t = arr[f++];
			if (f == maxSize)
				f = 0;
			n--;
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.println(" ");
	}
}

public class PriorityQApp
{
	public static void main (String[] args) {
		PriorityQ p = new PriorityQ(5);
		p.insert(1);
		p.insert(2);
		p.insert(3);
		p.insert(4);
		p.remove();
		p.remove();
		p.insert(5);
		p.insert(6);
		p.insert(7);
		p.remove();
		p.remove();
		p.display();
	}
}
