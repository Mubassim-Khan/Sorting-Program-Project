import java.util.Scanner;

public class sortingProject {
    // Global Vars
    static Scanner scanner = new Scanner(System.in);
    static int temp;

    // Method to Take input in an array (underworking)
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

    // Main method
    public static void main(String[] args) {
        boolean isRunning;
        int[] numArray;

        while (isRunning = true) {
            operationList();

            System.out.print("\nChoose operation to perform: ");
            int userValue = scanner.nextInt();

            switch (userValue) {
                case 1:
                    numArray = InputElements();
                    BubbleSort(numArray);
                    System.out.println("Sorted Array using Bubble Sort");
                    PrintArray(numArray);
                    break;
                case 2:
                    numArray = InputElements();
                    InsertionSort(numArray);
                    System.out.println("Sorted Array using Insertion Sort");
                    PrintArray(numArray);
                    break;
                case 3:
                    numArray = InputElements();
                    SelectionSort(numArray);
                    System.out.println("Sorted Array using Selection Sort");
                    PrintArray(numArray);
                    break;
                case 4:
                    System.out.println("You pressed 4");
                    break;
                case 5:
                    numArray = InputElements();
                    int size = numArray.length - 1;
                    QuickSort(numArray, 0, size);
                    System.out.println("Sorted Array using Quick Sort");
                    PrintArray(numArray);
                    break;
                case 6:
                    numArray = InputElements();
                    ShellSort(numArray);
                    System.out.println("Sorted Array using Shell Sort");
                    PrintArray(numArray);
                    break;
                case 7:
                    numArray = InputElements();
                    HeapSort(numArray);
                    System.out.println("Sorted Array using Heap Sort");
                    PrintArray(numArray);
                    break;
                case 8:
                    System.out.println("You pressed 8");
                    break;
                case 9:
                    System.out.println("You pressed 9");
                    break;
                case 10:
                    System.out.println("You pressed 10");
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