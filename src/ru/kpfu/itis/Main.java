package ru.kpfu.itis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TestGenerator generator = new TestGenerator();
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest1", 500);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest2", 500);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest3", 500);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest4", 500);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest5", 500);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest6", 1000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest7", 1000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest8", 1000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest9", 1000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest10", 1000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest11", 5000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest12", 5000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest13", 5000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest14", 5000);
//        generator.generateUniformlyDistributedTest("C:\\Users\\Elizaveta\\OneDrive\\Рабочий стол\\Прога\\Java 2 сем\\semester-project-bucket-sort1\\test\\UniformlyDistributedTest15", 5000);
        List<Integer> unsorted = Arrays.asList(80, 50, 60, 434333333, 30, 20, 10, 70, 0, 40, 500, 600, 602, 200, 15);
        int[] array = {80, 50, 60, 434333333, 30, 20, 10, 70, 0, 40, 500, 600, 602, 200, 15};
        BucketSort bs = new BucketSort();
        QuickSort qs = new QuickSort();
        unsorted = bs.bucketSort(unsorted);
        array = qs.quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array after quick sort- " + Arrays.toString(array));
        System.out.println("Sorted array after bucket sort- " + Arrays.toString(unsorted.toArray()));


        String path = "/Users/olga/IdeaProjects/semester-project-bucket-sort/test/UniformlyDistributedTest1";
//        TestGenerator generator = new TestGenerator();
//        generator.generateTest(path, 10000);
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


