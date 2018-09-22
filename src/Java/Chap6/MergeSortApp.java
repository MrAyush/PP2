class MergeSort {
    private int[] arr;
    private int nEle;
    private int size;

    MergeSort(int size) {
        this.size = size;
        arr = new int[size];
        nEle = 0;
    }

    MergeSort insert(int ele) {
        if (nEle < size)
            arr[nEle++] = ele;
        return this;
    }

    void display() {
        System.out.println("Array: ");
        for (int i = 0; i < nEle; i++) {
            System.out.println(" " + arr[i] + " ");
        }
    }

    MergeSort mergeSort() {
        int[] arrB = new int[nEle];
        mergeSort(arrB, 0, nEle - 1);
        return this;
    }

    private void mergeSort(int[] arrB, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(arrB, low, mid);
            mergeSort(arrB, mid + 1, high);
            merge(arrB, low, mid, high);
        }
    }

    private void merge(int[] arrB, int low, int mid, int high) {
        int k = low;
        int i = low, j = mid + 1, l;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                arrB[k] = arr[i];
                i++;
            } else {
                arrB[k] = arr[j];
                j++;
            }
            k++;
        }

        if (j > high) {
            for (l = i; l <= mid; l++) {
                arrB[k] = arr[l];
                k++;
            }
        } else {
            for (l = j; l <= high; l++) {
                arrB[k] = arr[l];
                k++;
            }
        }

        for (k = low; k <= high; k++) {
            arr[k] = arrB[k];
        }
    }
}

public class MergeSortApp {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort(10);
        sort.insert(70).insert(50).insert(20).insert(40).insert(10).insert(30).insert(60).insert(90).insert(80).insert(100)
            .mergeSort().display();
    }
}
