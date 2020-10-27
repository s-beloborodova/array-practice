package ua.step.practice;

import java.util.Scanner;

/**
 * Программа должна выводить слово Yes для симметричного массива и
 * слово No – для несимметричного. Симметричным считается массив,
 * в котором значения элементов с конца равно значению элементов с
 * начала. Массив заполняется пользователем вручную. Размер массива
 * (количество строк и колонок) задается при запуске программы.
 *
 * Примеры значений для симметричного массива:
 * <p>
 * 1, 2, 3, 2, 1
 * 2, 2, 3, 2, 2
 * 1, 3, 2, 3, 1
 * 5, 4, 3, 4, 5
 *
 *
 */
public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размернось массива (сколько строк и колонок): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] marr;
        // TODO: Пишите код здесь
        if(rows == 0 || cols == 0) {
            System.out.print("No");
            return;
        }
        marr = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                marr[i][j] = scanner.nextInt();
            }
        }
        int count = cols;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols/2; j++) {
                if(marr[i][j] != marr[i][count - 1]) {
                    System.out.print("No");
                    return;
                }
                count = count - 1;
            }
            count = cols;
        }
        System.out.print("Yes");
    }
}
