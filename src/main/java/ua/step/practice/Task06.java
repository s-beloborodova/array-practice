package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество уникальных значений
 * (встречающихся в массиве один раз). Вывести на консоль
 * значения уникальных элементов и индексы, под которыми
 * они находятся в массиве.
 *
 *  Пример:
 *      -5 -> 0 индекс
 *      3 -> 1 индекс
 *      4 -> 2 индекс
 *      2 -> 3 индекс
 *      0 -> 4 индекс
 *      -2 -> 5 индекс
 *      -4 -> 6 индекс
 *      -1 -> 9 индекс
 */
public class Task06 {

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest06
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        // TODO: Пишите код здесь
        Integer [] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(11) - 5;
        }

        Integer [] arrValue = new Integer [10];
        int [] arrCount = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arrValue[i] = 11;
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
        for(int i = 0; i < curIndex; i++) {
            if(arrCount[i] == 1)
            {
                System.out.println(arrValue[i] + " -> " + Arrays.asList(arr).indexOf(arrValue[i]) + " индекс");
            }
        }
    }
}
