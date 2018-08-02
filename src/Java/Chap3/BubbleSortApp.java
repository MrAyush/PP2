package Java;

class ArrayBub {
    private long[] a;
    // ref to array a
    private int nElems;

    // number of data items
    //--------------------------------------------------------------
    public ArrayBub(int max)
    // constructor
    {
        a = new long[max];
        // create the array
        nElems = 0;
        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)
    // put element into array
    {
        a[nElems] = value;
        // insert it
        nElems++;
        // increment size
    }

    //--------------------------------------------------------------
    public void display()
    // displays array contents
    {
        for (int j = 0; j < nElems; j++)
            // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println(" ");
    }

    //--------------------------------------------------------------
    public ArrayBub bubbleSort() {
        int out, in, outB;
        for (out = nElems - 1, outB = 0; out > 1; out--, outB++) {
            // outer loop (backward)
            in = 0;
            while (in < out) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
                in++;
            }
            while (in > outB) {
                if (a[in] < a[in - 1]) {
                    swap(in, in - 1);
                }
                in--;
            }
        }
        return this;
    } // end bubbleSort()

    public ArrayBub oddEvenSort() {
        int out, inOddEven;
        for (out = 0; out < nElems; out++) {
            if (out % 2 == 0) {
                inOddEven = 0;
            } else {
                inOddEven = 1;
            }
            while (inOddEven < nElems - 1) {
                if (a[inOddEven] > a[inOddEven + 1]) {
                    swap(inOddEven, inOddEven + 1);
                }
                inOddEven = inOddEven + 2;
            }

        }
        return this;
    }

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
    //--------------------------------------------------------------
} // end class ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        // array size
        ArrayBub arr;
        // reference to array
        arr = new ArrayBub(maxSize); // create the array
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33); // insert 10 items
        arr.display(); // display items
        arr.oddEvenSort().display(); // bubble sort them
    } // end main()
} // end class BubbleSortApp
////////////////////////////////////////////////////////////////
