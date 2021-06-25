package course.fundamentals;


import java.util.Random;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        nameAskingFromConsole();
        System.out.println();

        System.out.println("Arguments reverse: ");
        argumentsReverse(args);
        System.out.println();

        System.out.println("Random Numbers in line and every single line: ");
        randomNumbersLine();
        randomNumbersOneLine();
        System.out.println();

        System.out.println("Arguments summary and multiplication: ");
        argumentsSummary(5, 6, 7);
        argumentsMultiply(5, 6, 7);
        System.out.println();

        System.out.println("Month Number:");
        monthNumber();
    }

    /*
    1.     Приветствовать любого пользователя при вводе его имени через командную строку.
     */
    public static void nameAskingFromConsole() {
        System.out.println("What`s your name?: ");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        System.out.println("Hello" + ", " + a + "!");
    }

    /*
    2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
     */
    public static void argumentsReverse(String... args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }

    /*
    3.     Вывести заданное количество случайных чисел с переходом и без перехода на
    новую строку
     */
    public static void randomNumbersLine() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randNumber = rand.nextInt(15);
            System.out.println(randNumber);
        }
    }

    public static void randomNumbersOneLine() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randNumber = rand.nextInt(15);
            System.out.print(randNumber + " ");
        }
    }

    /*
    4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму
    (произведение) и вывести результат на консоль.
     */
    public static void argumentsSummary(int ... args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        System.out.println(sum);

    }
    public static void argumentsMultiply(int ... args) {
        int multiply = 1;

        for (int i = 0; i < args.length; i++) {
            multiply *= args[i];
        }
        System.out.println(multiply);

    }

    /*
    5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего
    данному числу. Осуществить проверку корректности ввода чисел.
     */

    public static void monthNumber(){
        System.out.println("Entry any number from 1 to 12: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        if ((number >= 1) && (!(number > 12))){
            switch (number){
                case 1:
                    System.out.println("It`s January");
                    break;
                case 2:
                    System.out.println("It`s February");
                    break;
                case 3:
                    System.out.println("It`s March");
                    break;
                case 4:
                    System.out.println("It`s April");
                    break;
                case 5:
                    System.out.println("It`s May");
                    break;
                case 6:
                    System.out.println("It`s June");
                    break;
                case 7:
                    System.out.println("It`s July");
                    break;
                case 8:
                    System.out.println("It`s August");
                    break;
                case 9:
                    System.out.println("It`s September");
                    break;
                case 10:
                    System.out.println("It`s October");
                    break;
                case 11:
                    System.out.println("It`s November");
                    break;
                case 12:
                    System.out.println("It`s December");
                    break;
                default:
                break;
            }
        } else {
            System.out.println("Incorrect number");
        }
    }
}



