//This bonus program will be a grade tracker, It uses sorting, recursion, fileIO, and enum
package advanced.java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bonus {

    public enum Classes {
        English, Math, History, Chemistry, Biology, ComputerScience, Gym, Physics
    }

    //Sort method that also uses recursion
    static void bubbleSort(int arr[], int n) {
        if (n == 1) {
            return;
        }

        //Repeatedly checks adjacent values
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        //Recursion
        bubbleSort(arr, n - 1);
    }

    public static void print(int[] x) {
        for (int i : x) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    
    public static float average(int[] input) {
        float sum = 0f;
        for (int number : input) {
            sum = sum + number;
        }
        return sum / input.length;
    }

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File("Grades.txt");
        int count = 0;

        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter print = new PrintWriter(file);

        ArrayList<Integer> Gradelist;
        try (Scanner f = new Scanner(file)) {
            Gradelist = new ArrayList<>();
            while (f.hasNext()) {
                Gradelist.add(f.nextInt());
            }
        }

        System.out.println("This is a grade tracker:");
        while (true) {
            System.out.println("\nOptions: 'record' will display all grades and your average, 'new' to input new grade, "
                    + "'classes' to display all classes currently enrolled, 'range' to find highest/lowest marks, 'quit' to exit program");
            
            String option = input.nextLine();
            switch (option) {
                
                case "record":
                    if (count == 1){
                        
                    System.out.println("Here is your grade record in order\n");
                    int list[] = new int[Gradelist.size()];
                    for (int i = 0; i < Gradelist.size(); i++) {
                        list[i] = Gradelist.get(i);
                    }
                    bubbleSort(list, list.length);
                    print(list);
                    System.out.println("\nYour grade average is " + average(list) + "%" );
                    
                    } else {
                       System.out.println("There are no grades to display\n"); 
                    }
                    break;
                    
                case "new":
                    try {
                        System.out.println("Please enter a grade from 1-100%");
                        int add = input.nextInt();
                        if (add < 0 || add > 100){
                            throw new Exception();
                        }
                        Gradelist.add(add);
                        print.write(add);
                        System.out.println("Grade added");
                        count = 1;
                    } catch (Exception e) {
                        System.out.println("Not a valid response");
                    }
                    break;
                    
                case "classes":
                    System.out.println("You are currently enrolled in ");
                    for (Classes a : Classes.values()) {
                        System.out.println(a);
                    }
                    break;
                    
                case "exit":
                    System.out.println("Have a good day!");
                    System.exit(0);   
                default:
                    break;
            }
        }
    }
}
