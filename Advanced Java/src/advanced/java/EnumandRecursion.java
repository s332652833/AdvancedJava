//This will use enum and recursion to have various calculations to certain numbers
package advanced.java;
import java.util.Scanner;
/**
 *
 * @author Arup
 */
public class EnumandRecursion {

    public enum calc {
        add, subtract, factorial,
    }
    
    //Finds the sum of all natural numbers within the inserted number(eg comparing 5, sum = 5+4+3+2+1 = 15
    public static long sumNumbers(int n) {
        if (n != 0)
            return n + sumNumbers(n - 1);
        else
            return n;
    }
    //Finds the subtraction of all natural numbers within the inserted number(eg comparing 5, sum = 5-4-3-2-1 = -5
    public static long subtractNumbers(int n) {
        if (n != 0)
            return n - sumNumbers(n - 1);
        else
            return n;
    }
    //Finds the factorial which is the multiplication of all natural numbers within the inserted number(eg comparing 5, sum = 5*4*3*2*1 = 120
    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void calculation(int x) {
        for (calc a : calc.values()) {
            switch (a) {
                case add:
                    System.out.println("The sum of all the natural numbers equals to: ");
                    System.out.println(sumNumbers(x));
                    break;
                case subtract:
                    System.out.println("The subtraction of all the natural numbers equals to: ");
                    System.out.println(subtractNumbers(x));
                    break;
                case factorial:
                    System.out.println("The multiplication of all the natural numbers is: ");
                    System.out.println(factorial(x));
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int count = 0;


        Scanner input = new Scanner(System.in);

        while (count == 0) {

            try {
                System.out.println("this program will find the sum of the natural numbers, subtract all natural numbers, and find factorial");
                System.out.println("Insert the number");
                int num1 = input.nextInt();
                calculation(num1);
            } catch (Exception e) {
                System.out.println("Not a proper response, try again");
            }
        }

    }
}
