package ru.kpfu.itis;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unsorted = Arrays.asList(80, 50, 60, 434333333, 30, 20, 10, 70, 0, 40, 500, 600, 602, 200, 15);
        int[] array = {80, 50, 60, 434333333, 30, 20, 10, 70, 0, 40, 500, 600, 602, 200, 15};
        BucketSort bs = new BucketSort();
        QuickSort qs = new QuickSort();
        unsorted = bs.bucketSort(unsorted);
        array = qs.quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array after quick sort- " + Arrays.toString(array));
        System.out.println("Sorted array after bucket sort- " +  Arrays.toString(unsorted.toArray()));
    }
}
