package ru.kpfu.itis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.uncommons.maths.random.*;

public class TestGenerator {
    public void generateUniformlyDistributedTest(String path, int numberOfElements) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(numberOfElements + "\n");
            for (int i = 0; i < numberOfElements; i++) {
                int elem =(int) Math.random()*Integer.MAX_VALUE;
                file.write(elem + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateGaussianTest(String path, int numberOfElements) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(numberOfElements + "\n");
            Random random = new Random();
            for (int i = 0; i < numberOfElements; i++) {
                int elem =Math.abs ((int) (random.nextGaussian()*Integer.MAX_VALUE));
                file.write(elem + "\n");
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
