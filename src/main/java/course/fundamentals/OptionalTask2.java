
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

        int[][] matrix = createMatrix();

        lineSort(matrix);
        columnSort(matrix);

    }


    public static int[][] createMatrix() {

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
        System.out.println("Random matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
            scan.close();
        }
        return a;
    }

    public static void lineSort(int[][] matrix) {
        int temp;

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < (matrix.length - 1); j++) {
                    if (matrix[k][j] > matrix[k][j + 1]) {
                        temp = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = temp;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("sort each row from less to high number: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void columnSort(int[][] matrix) {
        int temp;

        for (int k = 0; k < matrix.length; k++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int i = 0; i < (matrix.length - 1); i++) {
                    if (matrix[i][k] > matrix[i + 1][k]) {
                        temp = matrix[i][k];
                        matrix[i][k] = matrix[i + 1][k];
                        matrix[i + 1][k] = temp;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("sort each column from less to high number: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

}

