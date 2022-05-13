package ru.kpfu.itis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.uncommons.maths.random.*;

public class TestGenerator {

    public void generateTest(String path, int numberOfElements) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(numberOfElements + "\n");
            Set<Integer> set = new HashSet<>(numberOfElements);
            for (int i = 1; i <= numberOfElements; i++) {
                set.add(i);
            }

            int randomIndex = 1 + (int)(Math.random()*numberOfElements);
            while (!set.isEmpty()) {
                if (set.contains(randomIndex)) {
                    file.write(randomIndex + "\n");
                    set.remove(randomIndex);
                }
                randomIndex = 1 + (int)(Math.random()*numberOfElements);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateExponentialTest(String path, int numberOfElements) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(numberOfElements + "\n");
            Random random = new Random();
            for (int i = 0; i < numberOfElements; i++) {
                int elem = (int) ((new ExponentialGenerator(10, random)).nextValue() * 100);
                file.write(elem + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
