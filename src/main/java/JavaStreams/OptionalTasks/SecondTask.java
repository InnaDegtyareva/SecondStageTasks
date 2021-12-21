package JavaStreams.OptionalTasks;

import java.io.*;

// Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private

public class SecondTask {
    public static void main(String[] args) {

        File theDir = new File("data2");
        if (!theDir.exists()) {
           theDir.mkdir();
        } else {
            System.out.println("The directory has already been created");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "E:\\Automation\\src\\main\\java\\ErrorExceptions\\Faculty.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data2/replace.txt"))) {

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedReader.lines();

                String str = s.replaceAll("public", "private");
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

