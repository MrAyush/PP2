package Java;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
    private long[] a;    // ref to array a
    private int nElems;  // number of data items
    private int dups;        // number of dupicates
    private int compares;    //number of comparisons

    //--------------------------------------------------------------
    public ArrayIns(int max)        // constructor
    {
        a = new long[max];      // create the array
        nElems = 0;       // no items yet
        dups = 0;
        compares = 0;
    }

    //--------------------------------------------------------------
    public int getDups() {
        return dups;
    }

    public int getComps() {
        return compares;
    }

    //--------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    //--------------------------------------------------------------
    public void display()    // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public ArrayIns insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;  // insert marked item
        } // end for
        return this;
    } // end insertionSort()

    //--------------------------------------------------------------
    public ArrayIns insertionSortAndNoDups() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                if (temp == a[in - 1]) {
                    temp = -1;
                }
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;  // insert marked item
            if (in > 0 && a[in] == a[in + 1]) {
                a[in] = -1;
            }
        } // end for
        return this;
    } // end insertionSort()

    //--------------------------------------------------------------
    public ArrayIns insertionSortAndCount() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
                compares++;
                if (a[in] == a[in + 1]) {
                    dups++;
                }
            }
            a[in] = temp;  // insert marked item
        } // end for
        return this;
    } // end insertionSortAndCount()

    //--------------------------------------------------------------
    public long median() {
        return a[nElems / 2];
    }

    //--------------------------------------------------------------
        /*public boolean noDups(){
			for (int l = 0; l < nElems; l++){
				for (int i = l + 1; i < nElems;){
					if (a[l] == a[i]){
						a[i] = 0;
						int k = i;
						for (int j = i + 1; j < nElems; j++){
							a[k] = a[j];
							k = j;
						}
						nElems--;
					}else{
						i++;
					}
				}
			}
			return true;
		}*/
    //--------------------------------------------------------------
    public ArrayIns noDups() {
        int i = 0, j = 0;
        for (; i < nElems && j < nElems; j++) {
            if (a[j + 1] != a[j]) {
                swap(i, j);
                i++;
            }
        }
        nElems = i;
        return this;
    }

    //--------------------------------------------------------------
    public ArrayIns deleteElement(int ele) {
        for (int i = 0; i < nElems; ) {
            if (a[i] == ele) {
                a[i] = 0;
                int k = i;
                for (int j = i + 1; j < nElems; j++) {
                    a[k] = a[j];
                    k = j;
                }
                nElems--;
            } else {
                i++;
            }
        }
        return this;
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
} // end class ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArrayIns arr; // reference to array
        arr = new ArrayIns(maxSize); // create the array
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(44);
        arr.insert(88);
        arr.insert(11);
        arr.insert(44);
        arr.insert(0);
        arr.insert(0);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.insert(66);
        arr.insert(66); // insert items
        arr.display(); // display items
        //int dups = arr.insertionSortAndCount().getDups();
        //int compares = arr.insertionSortAndCount().getComps();
        //System.out.println("\ndups:"+ dups +" and comparisons: " + compares + "\n");
        arr.insertionSortAndNoDups().deleteElement(-1).display();  // display them again
        //System.out.println(arr.median());
        //arr.noDups();
        //arr.display();
    } // end main()
} // end class InsertSortApp
////////////////////////////////////////////////////////////////
