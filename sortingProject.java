import java.util.Scanner;

public class sortingProject {
    // Global Vars
    static Scanner scanner = new Scanner(System.in);
    static int temp;

    // Method to Take input in an array (underworking)
    static int InputElements() {
        System.out.print("Enter size of an array: ");
        int size = scanner.nextInt();
        int numArray[] = new int[size];

        System.out.println("Enter elements: ");

        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }
        return size;
    }

    // Method of Printing Elements in an Array
    static void PrintArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    // For printing list of operation
    static void operationList() {
        System.out.println("\nPress 1: For Bubble Sort");
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
    static void BubbleSort() {
        System.out.print("Enter size of an array: ");
        int size = scanner.nextInt();
        // InputElements();
        int numArray[] = new int[size];
        int n = numArray.length;

        System.out.print("Enter elements: ");

        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numArray[j] > numArray[j + 1]) {
                    temp = numArray[j];
                    numArray[j] = numArray[j + 1];
                    numArray[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array using Bubble Sort");
        PrintArray(numArray);
    }

    // Method of Insertion Sort
    static void InsertionSort() {
        System.out.print("Enter size of an array: ");
        int size = scanner.nextInt();

        int numArray[] = new int[size];

        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }

        for (int i = 0; i < numArray.length; i++) {
            temp = numArray[i];
            int j = i - 1;
            while (j >= 0 && numArray[j] > temp) {
                numArray[j + 1] = numArray[j];
                j--;
            }
            numArray[j + 1] = temp;
        }

        System.out.println("Sorted Array using Insertion Sort");
        PrintArray(numArray);
    }

    // Method of Bubble Sorting
    static void SelectionSort() {
        System.out.print("Enter size of an array: ");
        int size = scanner.nextInt();

        int numArray[] = new int[size];

        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (numArray[j] < numArray[minIndex]) {
                    minIndex = j;
                }
            }
            temp = numArray[i];
            numArray[i] = numArray[minIndex];
            numArray[minIndex] = temp;
        }

        System.out.println("Sorted Array using Selection Sort");
        PrintArray(numArray);
    }

    // Main method
    public static void main(String[] args) {
        boolean isRunning;

        while (isRunning = true) {
            operationList();

            System.out.print("\nChoose operation to perform: ");
            int userValue = scanner.nextInt();

            switch (userValue) {
                case 1:
                    BubbleSort();
                    break;
                case 2:
                    InsertionSort();
                    break;
                case 3:
                    SelectionSort();
                    break;
                case 4:
                    System.out.println("You pressed 4");
                    break;
                case 5:
                    System.out.println("You pressed 5");
                    break;
                case 6:
                    System.out.println("You pressed 6");
                    break;
                case 7:
                    System.out.println("You pressed 7");
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