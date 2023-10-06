import java.util.*;

public class SortingProject {
    // Global Vars
    static Scanner scanner = new Scanner(System.in);
    static int temp;

    // Method to Take input in an array
    static int[] InputElements() {
        System.out.print("Enter size of an array: ");
        int size = scanner.nextInt();
        int numArray[] = new int[size];

        System.out.println("Enter elements: ");

        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }
        return numArray;
    }

    // Method of Printing Elements in an Array
    static void PrintArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // For printing list of operation
    static void operationList() {
        System.out.println("\n x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");
        System.out.println("Press 1: For Bubble Sort");
        System.out.println("Press 2: For Insertion Sort");
        System.out.println("Press 3: For Selection Sort");
        System.out.println("Press 4: For Merge Sort");
        System.out.println("Press 5: For Quick Sort");
        System.out.println("Press 6: For Shell Sort");
        System.out.println("Press 7: For Heap Sort");
        System.out.println("Press 8: For Counting Sort");
        System.out.println("Press 9: For Radix Sort");
        System.out.println("Press 10: For Bucket Sort");
        System.out.println("\nPress 0: To Exit");
    }

    // Method of Bubble Sorting
    static void BubbleSort(int[] numArray) {
        int n = numArray.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numArray[j] > numArray[j + 1]) {
                    temp = numArray[j];
                    numArray[j] = numArray[j + 1];
                    numArray[j + 1] = temp;
                }
            }
        }
    }

    // Method of Insertion Sort
    static void InsertionSort(int[] numArray) {
        int n = numArray.length;

        for (int i = 0; i < n; i++) {
            temp = numArray[i];
            int j = i - 1;
            while (j >= 0 && numArray[j] > temp) {
                numArray[j + 1] = numArray[j];
                j--;
            }
            numArray[j + 1] = temp;
        }
    }

    // Method of Selection Sort
    static void SelectionSort(int[] numArray) {
        int n = numArray.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numArray[j] < numArray[minIndex]) {
                    minIndex = j;
                }
            }
            temp = numArray[i];
            numArray[i] = numArray[minIndex];
            numArray[minIndex] = temp;
        }
    }

    // Method of Merge Sort
    static void merge(int[] numArray, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = numArray[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = numArray[q + j + 1];
        }

        int i, j, k;
        i = 0; // To Mantain Curent Index of sub-arrays
        j = 0;
        k = p; // To Mantain Curent Index of main array

        /*
         * Pick larger element among L & M, & place in
         * correct position until end of array is reached
         */
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                numArray[k] = L[i];
                i++;
            } else {
                numArray[k] = R[j];
                j++;
            }
            k++;
        }

        /*
         * Pick up remaining elements from main array & place
         * in sub-array, if we run out of in L or R
         */
        while (i < n1) {
            numArray[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            numArray[k] = R[j];
            j++;
            k++;
        }
    }

    static void MergeSort(int[] numArray, int l, int r) {
        // Divide an array into 2 parts 'l' & 'r'
        if (l < r) {
            // 'm' is the midpoint of dividing array into 2 parts.
            int m = (l + r) / 2;
            // 1st sub-array
            MergeSort(numArray, l, m);
            // 2nd sub-array
            MergeSort(numArray, m + 1, r);
            // Merge both sub-arrays
            merge(numArray, l, m, r);
        }
    }

    // Method of Quick Sort
    // Swapping method (used in various places)
    static void swap(int[] numArray, int i, int j) {
        temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    static int partition(int[] numArray, int low, int high) {
        int pivot = numArray[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (numArray[j] <= pivot) {
                i++;
                swap(numArray, i, j);
            }
        }
        swap(numArray, i + 1, high);
        return (i + 1);
    }

    static void QuickSort(int[] numArray, int low, int high) {
        if (low < high) {
            int partIndex = partition(numArray, low, high);
            QuickSort(numArray, low, partIndex - 1);
            QuickSort(numArray, partIndex + 1, high);
        }
    }

    // Method of Shell Sort
    static void ShellSort(int[] numArray) {
        int n = numArray.length;

        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i += 1) {
                temp = numArray[i];
                int j;
                for (j = i; j >= interval && numArray[j - interval] > temp; j -= interval) {
                    numArray[j] = numArray[j - interval];
                }
                numArray[j] = temp;
            }
        }
    }

    // Method of Heap Sort
    static void HeapSort(int[] numArray) {
        int n = numArray.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(numArray, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(numArray, 0, i);
            heapify(numArray, i, 0);
        }
    }

    static void heapify(int[] numArray, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && numArray[left] > numArray[largest]) {
            largest = left;
        }
        if (right < n && numArray[right] > numArray[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(numArray, i, largest);
            heapify(numArray, n, largest);
        }
    }

    // Method of Counting Sort
    static void CountingSort(int[] numArray, int size) {
        int outputArray[] = new int[size + 1];

        // Find largest number in array
        int max = outputArray[0];
        for (int i = 1; i < size; i++) {
            if (numArray[i] > max) {
                max = numArray[i];
            }
        }

        int count[] = new int[max + 1];

        // Put zeros in count array
        Arrays.fill(count, 0);

        // Store count of each element
        for (int i = 0; i < size; i++) {
            count[numArray[i]]++;
        }

        // Store commulative count of array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Place elements from count & original array into output array
        for (int i = size - 1; i >= 0; i--) {
            outputArray[count[numArray[i]] - 1] = numArray[i];
            count[numArray[i]]--;
        }

        // Copy sorted elements into output array
        for (int i = 0; i < size; i++) {
            numArray[i] = outputArray[i];
        }
    }

    // Method of Radix Sort
    static void countingSortForRadix(int[] numArray, int size, int place) {
        int outputArray[] = new int[size];

        // Find largest number in array
        int max = maxElement(numArray, size);

        int count[] = new int[max + 1];

        // Put zeros in count array
        Arrays.fill(count, 0);

        // Calculate count of elements
        for (int i = 0; i < size; i++) {
            count[(numArray[i] / place) % 10]++;
        }

        // Calculate commulative count of array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Place elements from count & original array into output array
        for (int i = size - 1; i >= 0; i--) {
            // outputArray[count[(numArray[i] / place) % 10] - 1] = numArray[i];
            // count[(numArray[i] / place) % 10]--;
            int digit = (numArray[i] / place) % 10;
            outputArray[count[digit] - 1] = numArray[i];
            count[digit]--;
        }

        // Copy sorted elements into output array
        for (int i = 0; i < size; i++) {
            numArray[i] = outputArray[i];
        }
    }

    static int maxElement(int[] numArray, int n) {
        int max = numArray[0];
        for (int i = 1; i < n; i++) {
            if (numArray[i] > max) {
                max = numArray[i];
            }
        }
        return max;
    }

    static void RadixSort(int[] numArray, int size) {
        int max = maxElement(numArray, size);
        for (int place = 1; max / place > 0; place *= 10) {
            countingSortForRadix(numArray, size, place);
        }
    }

    // Method of Bucket Sort
    static void BucketSort(int[] numArray, int n) {
        if (n <= 0) {
            return;
        }

        // Find Max & Min values in array
        int maxValue = numArray[0];
        int minValue = numArray[0];

        for (int i = 1; i < n; i++) {
            if (numArray[i] > maxValue) {
                maxValue = numArray[i];
            }
            if (numArray[i] < minValue) {
                minValue = numArray[i];
            }
        }

        // For finding range of values in Array
        int range = maxValue - minValue + 1;

        // Creating empty buckets
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[range];
        for (int i = 0; i < range; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // Put elements in bucket
        for (int i = 0; i < n; i++) {
            int bucketIndex = numArray[i] - minValue;
            buckets[bucketIndex].add(numArray[i]);
        }

        // Sort the elements of each bucket
        for (int i = 0; i < range; i++) {
            Collections.sort((buckets[i]));
        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                numArray[index++] = buckets[i].get(j);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        boolean isRunning;
        int[] numArray;
        int size;

        while (isRunning = true) {
            operationList();

            System.out.print("\nChoose operation to perform: ");
            int userValue = scanner.nextInt();

            switch (userValue) {
                case 1:
                    System.out.println("\nYou Selected 'BUBBLE SORT'\n");
                    numArray = InputElements();
                    BubbleSort(numArray);
                    System.out.println("Sorted Array using Bubble Sort");
                    PrintArray(numArray);
                    break;
                case 2:
                    System.out.println("\nYou Selected 'INSERTION SORT'\n");
                    numArray = InputElements();
                    InsertionSort(numArray);
                    System.out.println("Sorted Array using Insertion Sort");
                    PrintArray(numArray);
                    break;
                case 3:
                    System.out.println("\nYou Selected 'SELECTION SORT'\n");
                    numArray = InputElements();
                    SelectionSort(numArray);
                    System.out.println("Sorted Array using Selection Sort");
                    PrintArray(numArray);
                    break;
                case 4:
                    System.out.println("\nYou Selected 'MERGE SORT'\n");
                    numArray = InputElements();
                    size = numArray.length - 1;
                    MergeSort(numArray, 0, size);
                    System.out.println("Sorted Array using Selection Sort");
                    PrintArray(numArray);
                    break;
                case 5:
                    System.out.println("\nYou Selected 'QUICK SORT'\n");
                    numArray = InputElements();
                    size = numArray.length - 1;
                    QuickSort(numArray, 0, size);
                    System.out.println("Sorted Array using Quick Sort");
                    PrintArray(numArray);
                    break;
                case 6:
                    System.out.println("\nYou Selected 'SHELL SORT'\n");
                    numArray = InputElements();
                    ShellSort(numArray);
                    System.out.println("Sorted Array using Shell Sort");
                    PrintArray(numArray);
                    break;
                case 7:
                    System.out.println("\nYou Selected 'HEAP SORT'\n");
                    numArray = InputElements();
                    HeapSort(numArray);
                    System.out.println("Sorted Array using Heap Sort");
                    PrintArray(numArray);
                    break;
                case 8:
                    System.out.println("\nYou Selected 'COUNTING SORT'\n");
                    numArray = InputElements();
                    size = numArray.length;
                    CountingSort(numArray, size);
                    System.out.println("Sorted array using Counting Sort");
                    PrintArray(numArray);
                    break;
                case 9:
                    System.out.println("\nYou Selected 'RADIX SORT'\n");
                    numArray = InputElements();
                    size = numArray.length;
                    RadixSort(numArray, size);
                    System.out.println("Sorted array using Radix Sort");
                    PrintArray(numArray);
                    break;
                case 10:
                    System.out.println("\nYou Selected 'BUCKET SORT'\n");
                    numArray = InputElements();
                    size = numArray.length;
                    BucketSort(numArray, size);
                    System.out.println("Sorted Array using Bucket Sort");
                    PrintArray(numArray);
                    break;
                case 0:
                    System.out.println("You quit the program");
                    scanner.close();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please enter number according to list ");
                    break;
            }
            if (isRunning == false) {
                break;
            }
        }
    }
}