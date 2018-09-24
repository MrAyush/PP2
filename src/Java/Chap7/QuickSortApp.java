class QuickSort {
    private int[] arr;
    private int nEle;

    QuickSort(int size) {
        arr = new int[size];
        nEle = 0;
    }

    QuickSort insert(int n) {
        arr[nEle++] = n;
        return this;
    }

    private int swap(int a, int b) {
        return a;
    }

    void display() {
        for (int i = 0; i < nEle; i++) {
            System.out.println(arr[i]);
        }
    }

    QuickSort quickSort() {
        quickSort(0, nEle - 1);
        return this;
    }

    private int partition(int initial, int _final) {
        int partElement = arr[_final];
        int i = initial - 1, j;
        for (j = initial; j < _final; j++) {
            if (arr[j] <= partElement) {
                i++;
                arr[j] = swap(arr[i], arr[i] = arr[j]);
            }
        }
        arr[_final] = swap(arr[i + 1], arr[i + 1] = arr[_final]);
        return i + 1;
    }

    private void quickSort(int initial, int _final) {
        int part;
        if (initial < _final) {
            part = partition(initial, _final);
            quickSort(initial, part - 1);
            quickSort(part + 1, _final);
        }
    }
}

public class QuickSortApp {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort(10);
        sort.insert(70).insert(50).insert(20).insert(40).insert(10).insert(30).insert(60).insert(90).insert(80).insert(100)
                .quickSort().display();

    }
}
