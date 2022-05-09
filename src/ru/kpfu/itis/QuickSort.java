package ru.kpfu.itis;


public class QuickSort {
    // быстрая сортировка для сравнения на хороших данных
    public int[] quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return array;

        if (low >= high)
            return array;

        int middle = low + (high - low) / 2;
        int supportElement = array[middle];

        int first = low;
        int second = high;
        while (first <= second) {
            while (array[first] < supportElement) {
                first++;
            }
            while (array[second] > supportElement) {
                second--;
            }

            if (first <= second) {
                int t = array[first];
                array[first] = array[second];
                array[second] = t;
                first++;
                second--;
            }
        }
        if (low < second) {
            quickSort(array, low, second);
        }

        if (high > first) {
            quickSort(array, first, high);
        }
        return array;
    }
}
