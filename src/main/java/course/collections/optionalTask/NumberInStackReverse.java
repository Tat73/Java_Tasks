/*
2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

 */
package course.collections.optionalTask;


import java.util.Scanner;
import java.util.Stack;

public class NumberInStackReverse {

    public static void main(String[] args) {
        Stack<Integer> number = new Stack<>();
        System.out.println("Entry number: ");
        Scanner scanner = new Scanner(System.in);
        int numberFromConsole = scanner.nextInt();

        number.push(numberFromConsole);

        System.out.println("Reversed number: ");
        reverseNumberFromStack(number.peek());
    }

    public static void reverseNumberFromStack(int number) {
        if (number < 10) {
            System.out.println(number);
        } else {
            System.out.print(number % 10);
            reverseNumberFromStack(number / 10);
        }
    }
}

