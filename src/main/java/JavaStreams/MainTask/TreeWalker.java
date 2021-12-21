package JavaStreams.MainTask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TreeWalker {

    public static void main(String[] args) throws IOException {

        Path file = Paths.get(args[0]);

        if (Files.isDirectory(file)) {
            Files.walkFileTree(file, new MyFileVisitor());
        } else {
            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8);
            List<String> listOfFiles = new ArrayList<>();
            int sumDirectories = -1;
            int sumFiles = 0;
            int sumFileNameLength = 0;
            for (String line : lines) {
                if (line.contains("\t")) {
                    sumFiles++;
                    int index = line.lastIndexOf('.');
                    if (index >= 0) {
                        listOfFiles.add(line.substring(0, index).replaceAll("\t", ""));
                    } else {
                        listOfFiles.add(line.replaceAll("\t", ""));
                    }
                } else {
                    sumDirectories++;
                }
            }
            for (String line : listOfFiles) {
                sumFileNameLength += (line.length() - 1);
            }
            System.out.println("Total number of directories: " + sumDirectories);
            System.out.println("Total number of files: " + sumFiles);
            System.out.println("Average number of files in the directories: ");
            System.out.printf("%.1f%n", +((double) sumFiles / sumDirectories));
            System.out.println("Average file name length: ");
            System.out.printf("%.1f%n", +((double) sumFileNameLength) / ((double) listOfFiles.size()));
        }
    }
}



