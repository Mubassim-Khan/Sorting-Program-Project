// import java.util.Scanner;

public class testing {
    // public static void main(String[] args) {
    // System.out.print("Enter size of an array: ");
    // Scanner scanner = new Scanner(System.in);
    // int size = scanner.nextInt();
    // int temp;

    // int numArray[] = new int[size];
    // System.out.print("Enter elements: ");
    // for (int i = 0; i < size; i++) {
    // numArray[i] = scanner.nextInt();
    // }

    // scanner.close();

    // for (int i = 0; i < numArray.length; i++) {
    // temp = numArray[i];
    // int j = i - 1;
    // while (j >= 0 && numArray[j] > temp) {
    // numArray[j + 1] = numArray[j];
    // j--;
    // }
    // numArray[j + 1] = temp;
    // }

    // System.out.println("Sorted Array using ___ Search");
    // for (int i : numArray) {
    // System.out.print(i + " ");
    // }
    // }
    // }

    // Quick sort in Java

    static void swap(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    static int partition(int[] numArray, int low, int high) {
        int pivot = numArray[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) { // Corrected loop condition
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

    public static void main(String[] args) {
        int[] numArray = { 64, 34, 25, 12, 22, 11, 90 };
        QuickSort(numArray, 0, numArray.length - 1);

        System.out.println("Sorted Array using Quick Sort:");
        for (int value : numArray) {
            System.out.print(value + " ");
        }
    }
}