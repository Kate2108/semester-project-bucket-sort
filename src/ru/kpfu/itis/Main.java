package ru.kpfu.itis;

import java.util.Arrays;
import java.util.List;

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
        System.out.println("Sorted array after bucket sort- " +  Arrays.toString(unsorted.toArray()));
    }
}
