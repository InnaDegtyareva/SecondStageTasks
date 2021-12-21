package ErrorExceptions;

import java.util.List;

public class Student {

    private String surname;
    private String name;
    private List<Subject> subjects;

    public Student(String surname, String name, List<Subject> subjects) {
        this.surname = surname;
        this.name = name;
        this.subjects = subjects;

        if (subjects.size() == 0) {
            try {
                throw new SubjectException();
            } catch (SubjectException e) {
                System.out.println("Add subjects student, whose name is " + surname + " " + name + "!");
            }
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public double getStudentAverageGrade() {
        double sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getGrade();
        }
        return sum / subjects.size();
    }

    public Subject getSubject(String name) {
        Subject searchSubject = null;
        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                searchSubject = subject;
                break;

            }
        }
        return searchSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
