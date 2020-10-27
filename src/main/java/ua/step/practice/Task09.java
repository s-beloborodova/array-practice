package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Задание: Заполнить массив размерности n случайными цифрами
 * от –2 до n. Если в массиве есть хотя бы одно отрицательное
 * значение меньше -1, заменить все отрицательные значение
 * в массиве на квадрат (в степени 2) этих значений. Вывести
 * исходный и результирующий массив на консоль.
 * <p>
 * Пример вывода:
 *      Исходный массив [9, 10, -2, 4, 0, 5, 1, 8, -1, 3]
 *      Результат [9, 10, 4, 4, 0, 5, 1, 8, 1, 3]
 */
public class Task09 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest09
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        int[] arr;
        // TODO: Пишите код здесь
        arr = new int[len];
        System.out.print("Исходный массив ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(len + 3) - 2;
        }
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < -1) {
                tmp = 1;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Результат ");
        if(tmp == 1) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] <= -1) {
                    arr[i] = arr[i] * arr[i];
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}
