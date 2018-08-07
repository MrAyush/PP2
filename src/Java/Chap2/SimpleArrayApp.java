public class SimpleArrayApp{
	public static void main (String[] args){
		SimpleArray a = new SimpleArray(10);
		SimpleArray b = new SimpleArray(10);
		a.setElement(10);
		a.setElement(20);
		a.setElement(30);
		a.setElement(40);
		
		/*a.printAllElement();
		System.out.println(a.search(10));
		a.deleteElement(20);
		a.printAllElement();
		System.out.println("\nDelete Duplicates\n");
		a.deleteDuplicateElement();
		a.printAllElement();
		System.out.println("\nMax\n" + a.getMax());
		a.printAllElement();
		System.out.println("\nMaxRemoved\n" + a.deleteElement(10));
		a.printAllElement();*/
		int length = a.getLength();
		for (int i = 0;i < length; i++){
			int ele = a.removeMax();
			if (ele == -1){
				break;
			}
			b.setElement(ele);
		}
		b.printAllElement();
		//a.printAllElement();
	}
}

class SimpleArray{
	private int array[];
	private int length;

	//Constucter
	SimpleArray(int Size){
		array = new int[Size];
		length = 0;
	}

	//Setters
	public void setElement(int e){
		array[length++] = e;
	}

	//Getter
	public int getLength(){ return length; }
	public int getElement(int pos){ return array[pos]; }

	//Operations
	public boolean search(int ele){
		for(int i = 0; i < length; i++){
			if (array[i] == ele)
				return true;
		}
		return false;
	}
	public void printAllElement(){
		for (int i =0; i < length; i++){
			System.out.println("\n" + array[i]);
		}
	}
	public boolean deleteElement(int ele){
		if (!search(ele)){
			return false;	
		}else{
			for (int i = 0; i < length;){
				if (array[i] ==	ele){
					array[i] = 0;
					int k = i;
					for (int j = i + 1; j < length; j++){
						array[k] = array[j];
						k = j;
					}
				length--;
				}else{
					i++;
				}
			}
		return true;
		}
	}
	public boolean deleteDuplicateElement(){
		for (int l = 0; l < length; l++){
			for (int i = l + 1; i < length;){
				if (array[l] ==	array[i]){
					array[i] = 0;
					int k = i;
					for (int j = i + 1; j < length; j++){
						array[k] = array[j];
						k = j;
					}
					length--;
				}else{
					i++;
				}
			}
		}
		return true;
	}
	public int getMax(){
		if (length == 0) {
			return -1;
		} else {
			int max = array[0];
			int maxIndex = 0;
			int i = 1;
			for (i = 1; i < length; i++) {
				if (max < array[i]) {
					max = array[i];
					maxIndex = i;
				}
			}
			return maxIndex;
		}
	}
	public int removeMax(){
		int max = getMax();
		if (max != -1){
			int maxEle = array[max];
			this.deleteElement(maxEle);
			return maxEle;
		} else {
			return -1;
		}
	}
}
