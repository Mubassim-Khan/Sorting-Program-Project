import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        System.out.print("Enter size of an array: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int temp;

        int numArray[] = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < numArray.length; i++) {
            temp = numArray[i];
            int j = i - 1;
            while (j >= 0 && numArray[j] > temp) {
                numArray[j + 1] = numArray[j];
                j--;
            }
            numArray[j + 1] = temp;
        }

        System.out.println("Sorted Array using ___ Search");
        for (int i : numArray) {
            System.out.print(i + " ");
        }
    }
}