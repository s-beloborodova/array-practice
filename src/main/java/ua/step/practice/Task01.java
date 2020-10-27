package ua.step.practice;

/**
 * Заполнить массив на 15 элементов числами Фибоначчи.
 * Вывести на консоль только четные элементы массива.
 * <p>
 * Пример вывода:
 * 1 2 5 13 34 89 233 610
 */
public class Task01 {
    public static void main(String[] args) {
        // TODO: Пишите код здесь
        int [] arr = new int[15];
        arr[0] = arr[1] = 1;
        for(int i = 2; i < arr.length;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        for(int i = 0; i < arr.length;i += 2) {
            System.out.print(arr[i] + " ");
        }
    }
}