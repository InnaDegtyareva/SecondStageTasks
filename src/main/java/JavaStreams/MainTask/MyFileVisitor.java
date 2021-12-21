package JavaStreams.MainTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

class MyFileVisitor implements FileVisitor<Path>{

        String dirBranch = "|";
        String doubleDirBranch = "---";
        String fileBranch = "|";
        String doubleFileBranch = "\t";
        int visitDirCount = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("treeWalker.txt"));

        MyFileVisitor() throws IOException {
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            List<Path> listOfNames = new ArrayList<>();
            listOfNames.add(dir.getFileName());
            for (Path name : listOfNames) {
                bufferedWriter.write(dirBranch + name + "\n");
            }
            dirBranch = dirBranch + doubleDirBranch;
            fileBranch = fileBranch + doubleFileBranch;
            bufferedWriter.flush();
            visitDirCount++;
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            List<Path> listOfNames = new ArrayList<>();
            listOfNames.add(file.getFileName());
            for (Path name : listOfNames) {
                if (visitDirCount == 1) {
                    bufferedWriter.write("|\t" + name + "\n");
                } else {
                    bufferedWriter.write(fileBranch + name + "\n");
                }
            }
            bufferedWriter.flush();
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Errors while visiting file: " + file.getFileName());
            return FileVisitResult.SKIP_SUBTREE;
        }
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            dirBranch = dirBranch.substring(0, dirBranch.length() - doubleDirBranch.length());
            fileBranch = fileBranch.substring(0, fileBranch.length() - doubleFileBranch.length());
            visitDirCount--;
            return FileVisitResult.CONTINUE;
        }
    }

