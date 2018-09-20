class BinarySearch {
	private int arr[];
	private int size;
	private int nEle;

	BinarySearch(int size) {
		this.size = size;
		arr = new int[size];
		nEle = 0;
	}
	
	public BinarySearch insert(int ele){
		if (nEle == 0){
			arr[nEle] = ele;
			nEle++;
		} else{
			int i = nEle;
			while (i >= 1){
				if (arr[i - 1] < ele){
					break;
				}
				i--;
			}
			for (int k = nEle; k > i; k--){
				arr[k] = arr[k - 1];
			}
			arr[i] = ele;
			nEle++;
		}
		return this;
	}
	
	boolean isEmpty() {
		return nEle == 0;
	}
	
	int find(int x) {
		return recFind(x, 0, nEle);
	}
	
	private int recFind(int x, int l, int h) {
		int mid = (l + h) / 2;
		if (isEmpty()) {
			return -1;
		} else {
			if (arr[mid] == x) {
				return mid;
			} else if (l > h) {
				return -1;
			} else {
				if (arr[mid] > x) {
					return recFind(x, l, mid - 1);
				} else {
					return recFind(x, mid + 1, h);
				}
			}
		}
	}
	
	void display() {
		for (int i = 0; i < nEle; i++) {
			System.out.println(arr[i]);
		}
	}
}

public class BinarySearchApp {
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch(10);
		binarySearch.insert(10).insert(20).insert(30).insert(40).insert(5);
		binarySearch.display();
		System.out.println(binarySearch.find(10));
	}
}
