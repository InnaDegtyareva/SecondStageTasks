package JavaStreams.OptionalTasks;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию

public class FirstTask {
    public static void main(String[] args) {

        File theDir = new File("data1");
        if (!theDir.exists()) {
            theDir.mkdir();
        } else {
            System.out.println("The directory has already been created");
        }

        try (FileWriter writer = new FileWriter("data1/randomDigit.txt", true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Введите количество чисел:");
            int quantityOfNumbers = scanner.nextInt();
            int[] numbersArray = new int[quantityOfNumbers];
            for (int i = 0; i < numbersArray.length; i++) {
                numbersArray[i] = (int) (Math.random() * 100);
            }
            writer.write(Arrays.toString(numbersArray));
            writer.write("\n");

            Arrays.sort(numbersArray);
            writer.write(Arrays.toString(numbersArray));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








