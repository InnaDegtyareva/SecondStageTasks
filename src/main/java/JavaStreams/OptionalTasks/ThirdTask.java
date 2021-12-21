package JavaStreams.OptionalTasks;

import java.io.*;

// Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки

public class ThirdTask {
    public static void main(String[] args) {

        File theDir = new File("data3");
        if (!theDir.exists()) {
           theDir.mkdir();
        } else {
            System.out.println("The directory has already been created");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "E:\\Automation\\src\\main\\java\\ErrorExceptions\\Subject.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data3/reverse.txt"))) {

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedReader.lines();
                StringBuilder sb = new StringBuilder(s);
                bufferedWriter.write(sb.reverse().toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
