package ru.kpfu.itis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    private List<ArrayList<Integer>> buckets;
    private int numberOfBuckets;

    public  List<Integer> bucketSort(List<Integer> inputUnsortedList){

        // создаем корзины
        numberOfBuckets = (int) Math.sqrt(inputUnsortedList.size());
        buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // заполняем корзины
        int maxElement = findMax(inputUnsortedList);
        for (int i : inputUnsortedList) {
            buckets.get(hash(i, maxElement, numberOfBuckets)).add(i);
        }

        // сортируем элементы внутри корзин, List.sort в основе имеет merge sort
        Comparator comparator = Comparator.naturalOrder();
        for(List bucket  : buckets){
            bucket.sort(comparator);
        }

        // склеиваем корзины в один лист
        List<Integer> sortedBuckets = new LinkedList<>();
        for(List<Integer> bucket : buckets){
            sortedBuckets.addAll(bucket);
        }

        return sortedBuckets;
    }
    // вспомогательные функции
    private int hash(int i, int maximum, int numberOfBuckets) {
        return (int) ((double) i / maximum * (numberOfBuckets - 1));
    }

    private int findMax(List<Integer> initialList) {
        int m = Integer.MIN_VALUE;
        for (int i: initialList) {
            m = Math.max(i, m);
        }
        return m;
    }
}

