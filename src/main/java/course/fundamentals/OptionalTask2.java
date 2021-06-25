
/*
Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений
от -M до M с помощью генератора случайных чисел (класс Random).
1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 */

package course.fundamentals;

import java.util.Random;
import java.util.Scanner;

public class OptionalTask2 {
    public static void main(String[] args) {

        int temp;

        Scanner scan = new Scanner(System.in);
        System.out.println("Entry a matrix length: ");
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = rand.nextInt(50) - 25;
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
            scan.close();
        }

        for (int k = 0; k < n; k++) {   //line sort
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (n - 1); j++) {
                    if (a[k][j] > a[k][j + 1]){
                        temp = a[k][j];
                        a[k][j] = a[k][j + 1];
                        a[k][j + 1] = temp;
                    }
                }
            }
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        for (int k = 0; k < n; k++) {   //column sort
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < (n - 1); i++) {
                    if (a[i][k] > a[i + 1][k]){
                        temp = a[i][k];
                        a[i][k] = a[i + 1][k];
                        a[i + 1][k] = temp;
                    }
                }
            }
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }
}

