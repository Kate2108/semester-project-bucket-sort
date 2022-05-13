package ru.kpfu.itis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\semester-project-bucket-sort\\test\\ExponentialTest";
        for (int i = 1; i < 21; i++) {
          String link = path + i;
            getAverageTime(link);
        }
    }

    private static void getAverageTime(String linkToTestFile) {
        int[] elems;
        try (Scanner scanner = new Scanner(new FileReader(linkToTestFile))) {
            elems = new int[scanner.nextInt()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = scanner.nextInt();
            }
            double sumTimeTestQuickSort = 0;
            double sumTimeTestBucketSort = 0;
            double num = 100.0;

            for (int j = 0; j < num; j++) {
                sumTimeTestQuickSort += testQuickSort(elems);
                sumTimeTestBucketSort += testBucketSort(elems);
            }
            System.out.println(elems.length);
            System.out.printf("Average time for QuickSort: %.2f nanoseconds\n", (sumTimeTestQuickSort / num));
            System.out.printf("Average time for BucketSort: %.2f nanoseconds", (sumTimeTestBucketSort / num));
            System.out.println("\n");
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static long testQuickSort(int[] elems) {
        QuickSort qs = new QuickSort();
        long start = System.nanoTime();
        qs.quickSort(elems, 0, elems.length - 1);
        return System.nanoTime() - start;
    }

    private static long testBucketSort(int[] elems) {
        List<Integer> listOfElems = new ArrayList<>();
        for (int i = 0; i < elems.length; i++) {
            listOfElems.add(elems[i]);
        }
        BucketSort bs = new BucketSort();
        long start = System.nanoTime();
        bs.bucketSort(listOfElems);
        long timeWorkCode = System.nanoTime() - start;
        return timeWorkCode;
    }
}


