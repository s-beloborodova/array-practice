package ua.step.practice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * Задание: Заполнить массив размерности n случайными строчны-
 * ми (маленькими) латинскими буквами. Подсчитать, сколько раз встреча-
 * ется каждая буква. Вывести буквы, которые встречаются
 * больше 3 раз. n – задается с клавиатуры.
 * <p>
 * Пример вывода:
 * g - 4 раза
 * l - 4 раза
 * s - 5 раз
 * v - 5 раз
 * x - 5 раз
 */
public class Task08 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest08
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        Character[] arr;
        // TODO: Пишите код здесь
        arr = new Character[len];
        int symbol;
        for (int i = 0; i < arr.length; i++) {
            symbol = rnd.nextInt(26) + 97;
            arr[i] = (char)symbol;
        }

        Character [] arrValue = new Character [len];
        int [] arrCount = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arrValue[i] = 150;
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
                if( arrValue[j] > arrValue[j+1] ){
                    char tmp = arrValue[j];
                    arrValue[j] = arrValue[j+1];
                    arrValue[j+1] = tmp;
                    int tmp2 = arrCount[j];
                    arrCount[j] = arrCount[j+1];
                    arrCount[j+1] = tmp2;
                }
            }
        }
        for(int i = 0; i < curIndex; i++) {
            if(arrCount[i] > 3) {
                if(arrCount[i]==4) {
                    System.out.println(arrValue[i] + " - " + arrCount[i] + " раза");
                } else {
                    System.out.println(arrValue[i] + " - " + arrCount[i] + " раз");
                }
            }
        }
    }
}
