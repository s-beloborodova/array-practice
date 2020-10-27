package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Задание: Заполнить массив размерности n случайными цифрами
 * от 3 до 13. Подсчитать, сколько раз встречается каждая циф-
 * ра. Вывести результат на экран. n – задается с клавиатуры
 *
 * Пример вывода:
 *      3 - 2 раза
 *      5 - 3 раза
 *      8 - 1 раза
 *      9 - 3 раза
 *      11 - 1 раза
 */
public class Task07 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest07
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        Integer[] arr;
        // TODO: Пишите код здесь
        arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(11) +3;
        }

        Integer [] arrValue = new Integer [len];
        int [] arrCount = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arrValue[i] = 15;
            arrCount[i] = 0;
        }
        int curIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int index = Arrays.asList(arrValue).indexOf(arr[i]);
            if(index != -1) {
                arrCount[index] += 1;
            }
            else {
                arrValue[curIndex] = arr[i];
                arrCount[curIndex] += 1;
                curIndex++;
            }
        }
        for(int i = curIndex - 1 ; i > 0 ; i--) {
            for(int j = 0 ; j < i ; j++) {
                if( arrValue[j] > arrValue[j+1] ) {
                    int tmp = arrValue[j];
                    arrValue[j] = arrValue[j+1];
                    arrValue[j+1] = tmp;
                    tmp = arrCount[j];
                    arrCount[j] = arrCount[j+1];
                    arrCount[j+1] = tmp;
                }
            }
        }
        for(int i = 0; i < curIndex; i++) {
            if(arrCount[i] > 0) {
                System.out.println(arrValue[i] + " - " + arrCount[i] + " раза");
            }
        }
    }
}
