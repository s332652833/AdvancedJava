//this file will use sorting and recursion to order numbers in Ascending and Descending order
package advanced.java;

import java.util.Scanner;

/**
 *
 * @author Arup
 */
public class SortRecursion {
    
    public static void quickSortAscend(int[] num, int low, int high) {

        int i = low;
        int j = high;
        int temp;
        int pivot = num[(low + high) / 2];

        while (i < j) {
            while (num[i] < pivot) {
                i++;
            }
            while (num[j] > pivot) {
                j--;
            }
            if (j >= i) {
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                i++;
                j--;
            }
        }
        //calls the quickSortDescend() method recursively
        if (low < j) {
            quickSortAscend(num, low, j);
        }
        if (i < high) {
            quickSortAscend(num, i, high);
        }
    }
    
    public static void quickSortDescend(int[] num, int low, int high) {

        int i = low;
        int j = high;
        int temp;
        int pivot = num[(low + high) / 2];

        while (i < j) {
            while (num[i] > pivot) {
                i++;
            }
            while (num[j] < pivot) {
                j--;
            }
            if (j >= i) {
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                i++;
                j--;
            }
        }
        //calls the quickSortDescend() method recursively
        if (low < j) {
            quickSortDescend(num, low, j);
        }
        if (i < high) {
            quickSortDescend(num, i, high);
        }
    }
    
    public static void print(int[] x){
        for (int i : x) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers would you like to generate and sort?");
        int count = 0;
        int option = input.nextInt();
        int list[] = new int[option];

        while (count < list.length) {

            System.out.println("Insert number");
            String num = input.nextLine();
            try {
                list[count] = (input.nextInt());
                count++;
            } catch (Exception e) {
                System.out.println("Not a proper response, try again");
            }
        }
        System.out.print("\nOriginal order of numbers: ");
        print(list);

        System.out.print("\nNumbers in Ascending Order: ");
        quickSortAscend(list, 0, list.length - 1);
        print(list);

        System.out.print("\nNumbers in Descending Order: ");
        quickSortDescend(list, 0, list.length - 1);
        print(list);
    }
}
