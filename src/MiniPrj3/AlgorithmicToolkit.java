package MiniPrj3;

//Mini-Project 3 – Algorithmic Toolkit
//Objective To consolidate all DSA patterns into a single Java utility library.
//Description Students create a small “AlgorithmToolkit” package containing:
//● SortingUtil class implementing bubble, insertion, merge, and quick sort.
//● SearchUtil class implementing linear and binary search.
//● CollectionUtil class implementing stack/queue operations generically.
//● AnalysisUtil class providing a timer function to benchmark any algorithm.
//Each method must have documentation, a complexity note, and at least two test cases.

import java.util.*;

// --------------------------- Sorting Util ---------------------------
class SortingUtil {

    // Bubble Sort - O(n²)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    // Insertion Sort - O(n²)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort - O(n log n)
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1], right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    // Quick Sort - O(n log n)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }
}

// --------------------------- Search Util ---------------------------
class SearchUtil {

    // Linear Search - O(n)
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    // Binary Search - O(log n) (sorted array)
    public static int binarySearch(int[] arr, int key) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}

// --------------------------- Collection Util ---------------------------
class CollectionUtil<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Stack operations
    public void push(T item) { list.addFirst(item); }
    public T pop() { return list.isEmpty() ? null : list.removeFirst(); }
    public T peek() { return list.isEmpty() ? null : list.getFirst(); }

    // Queue operations
    public void enqueue(T item) { list.addLast(item); }
    public T dequeue() { return list.isEmpty() ? null : list.removeFirst(); }

    public boolean isEmpty() { return list.isEmpty(); }
}

// --------------------------- Analysis Util ---------------------------
class AnalysisUtil {

    // Measures algorithm execution time
    public static void measure(Runnable algorithm) {
        long start = System.currentTimeMillis();
        algorithm.run();
        long end = System.currentTimeMillis();
        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}

public class AlgorithmicToolkit {
    public static void main(String[] args) {

        int[] arr = {5, 2, 8, 3, 1};

        System.out.println("Before Sorting: " + Arrays.toString(arr));
        SortingUtil.bubbleSort(arr);
        System.out.println("After Bubble Sort: " + Arrays.toString(arr));

        int idx = SearchUtil.linearSearch(arr, 3);
        System.out.println("Linear Search (find 3): " + idx);

        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("Binary Search (find 4): " +
                SearchUtil.binarySearch(sortedArr, 4));

        CollectionUtil<Integer> util = new CollectionUtil<>();
        util.push(10);
        util.push(20);
        util.enqueue(30);

        System.out.println("Stack Pop: " + util.pop());
        System.out.println("Queue Dequeue: " + util.dequeue());

        System.out.println("Timing Quick Sort:");
        AnalysisUtil.measure(() ->
                SortingUtil.quickSort(arr, 0, arr.length - 1)
        );
    }
}
