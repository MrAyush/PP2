public class OrderedArrayApp{
	public static void main(String Args[]){
		OrderedArray o = new OrderedArray(10);
		OrderedArray p = new OrderedArray(10);
		o.insert(5);
		o.insert(10);
		o.insert(2);
		o.insert(7);
		o.insert(6);
		
		p.insert(4);
		p.insert(11);
		p.insert(3);
		p.insert(12);
		p.insert(13);
		
		//o.getAllElement();
		/*int index = o.find(11);
		if (index != -1)
			System.out.println("\nIndex:\n" + index);
		else
			System.out.println("\nElement not found\n");
		if (o.deleteElement(2))
			System.out.println("\nDelete\n");
		else
			System.out.println("\nNot found\n");*/
		OrderedArray f = o.merge(p);
		f.getAllElement();

	}
}
class OrderedArray{
	
	private int array[];
	private int nEle;
	
	public OrderedArray(int max){
		array = new int[max];
		nEle = 0;
	}
	public void insert(int ele){
		if (nEle == 0){
			array[nEle] = ele;
			nEle++;
		} else{
			int i = nEle;
			while (i >= 1){
				if (array[i - 1] < ele){
					break;
				}
				i--;
			}
			for (int k = nEle; k > i; k--){
				array[k] = array[k - 1];
			}
			array[i] = ele;
			nEle++;
		}
	}
	public int getElement(int index){ return array[index]; }
	public void getAllElement(){
		for (int i = 0; i < nEle; i++){
			System.out.println("\n" + array[i]);
		}
	}
	public int find(int ele){
		int low = 0, high = nEle - 1, mid;
		int index = -1;
		if (nEle == 0){
			return index;
		} else if (nEle == 1){
			return index + 1;
		} else {
			while (low <= high){
				mid = (low + high) / 2;
				if (array[mid] == ele){
					index = mid;
					return index;
				} else if (ele < array[mid]){
					high = mid - 1;
				} else if (ele > array[mid]){
					low = mid + 1;
				} else {
					break;
				}
			}
			return index;
		}
	}
	public boolean deleteElement(int ele){
		int i = find(ele);
		if (i == -1){
			return false;	
		}else{
			array[i] = 0;
			int k = i;
			for (int j = i + 1; j < nEle; j++){
				array[k] = array[j];
				k = j;
			}
		nEle--;
		return true;
		}
	}
	public OrderedArray merge(OrderedArray o){
		int i = 0, j = 0;
		OrderedArray f = new OrderedArray(this.nEle + o.nEle);
		while (i < this.nEle && j < o.nEle){
			int l = this.getElement(i);
			int m = o.getElement(j);
			if (l < m){
				f.insert(l);
				i++;
			} else {
				f.insert(m);
				j++;
			}
		}
		if (j >= o.nEle){
			for (; i < this.nEle; i++){
				f.insert(this.getElement(i));
			}
		} else {
			for (; j < o.nEle; j++){
				f.insert(o.getElement(j));
			}
		}
		return f;
	}
}
