package ErrorExceptions;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students;
    private int numberOfGroup;

    public Group(List<Student> students, int numberOfGroup) {
        this.students = students;
        this.numberOfGroup = numberOfGroup;
        if (students.size() == 0) {
            try {
                throw new StudentException();
            } catch (StudentException e) {
                System.out.println("Add student in group number " + numberOfGroup + "!");
            }
        }
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public Student getStudentBySurnameAndName(String surname, String name) {
        Student searchStudent = null;
        for (Student student : students) {
            if (student.getSurname().equals(surname) && student.getName().equals(name)) {
                searchStudent = student;
                break;
            }
        }
        return searchStudent;
    }

    public List<Subject> getSubjects(String name) {
        List<Subject> subjects = new ArrayList<>();
        for (Student student : students) {
            subjects.add(student.getSubject(name));
        }
        return subjects;
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + students +
                ", numberOfGroup=" + numberOfGroup +
                '}';
    }
}
