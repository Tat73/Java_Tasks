package course.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) {
        int[] arr = numbers();

        System.out.println("numbers with the longest & the shortest length: ");
        numberLength(arr);
        System.out.println();

        System.out.println("length sort: ");
        bubbleSort(arr);
        reverseSort(arr);
        System.out.println();

        System.out.println("length more or less than average: ");
        numberAverageLength(arr);
        System.out.println();

    }

    public static int[] numbers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entry an array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Entry an array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        return array;
    }

    /*
    1.   Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
     */
    public static void numberLength(int[] array) {
        int shortNum = array[0];
        int longNum = array[0];


        for (int i = 1; i < array.length; i++) {
            if (String.valueOf(shortNum).length() > String.valueOf(array[i]).length()) {
                shortNum = array[i];
            } else if (String.valueOf(longNum).length() < String.valueOf(array[i]).length()) {
                longNum = array[i];
            }
        }
        System.out.println("the shortest number: " + shortNum + " " + "the length of this number: " +
                String.valueOf(shortNum).length());
        System.out.println("the longest number: " + longNum + " " + "the length of this number: " +
                String.valueOf(longNum).length());
    }

    /*
    2.     Вывести числа в порядке возрастания (убывания) значений их длины.
    */

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));

    }

    public static void reverseSort(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
     */

    public static void numberAverageLength(int[] array) {
        double sum = 0;
        double average = 0;


        for (int i = 0; i < array.length; i++) {
            sum += String.valueOf(array[i]).length();
            average = sum / array.length;
        }
        System.out.println("Average length: " + average);

        for (int i = 0; i < array.length; i++) {
            if ((double) String.valueOf(array[i]).length() < average) {
                System.out.println("has less length than average: " + array[i] + " " + "\n" + "length: " + (double) String.valueOf(array[i]).length());
            } else {
                System.out.println("has length more than average: " + array[i] + " " + "\n" + "length: " + (double) String.valueOf(array[i]).length());
            }
        }
    }

}





