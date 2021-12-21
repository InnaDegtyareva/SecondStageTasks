package ErrorExceptions;

import java.util.ArrayList;
import java.util.List;


public class University {
    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
        if (faculties.size() == 0) {
            try {
                throw new FacultyException();
            } catch (FacultyException e) {
                System.out.println("Check list! There must be a faculty in the university!");
            }
        }
    }

    public Student getStudentBySurnameAndName(String surname, String name) {
        Student searchStudent = null;
        for (Faculty faculty : faculties) {
            searchStudent = faculty.getStudentBySurnameAndName(surname, name);
            if (searchStudent != null) {
                break;
            }
        }
        return searchStudent;
    }

    public double getStudentAverageGrade(String surname, String name) {
        System.out.println("Student, whose name is " + surname + " " + name + " average grade is: ");
        return getStudentBySurnameAndName(surname, name).getStudentAverageGrade();
    }

    public List<Subject> getSubjects(String name) {
        List<Subject> subjects = new ArrayList<>();
        for (Faculty faculty : faculties) {
            subjects.addAll(faculty.getSubjects(name));
        }
        return subjects;
    }

    public double getSubjectAverageGrade(String name) {
        List<Subject> subjects;
        subjects = getSubjects(name);
        double averageGrade = 0;
        for (Subject subject : subjects) {
            averageGrade += subject.getGrade();
        }

        System.out.println("Average grade in the subject " + name + " across the university is:");
        return averageGrade / subjects.size();
    }

    public List<Subject> getSubjectsFromTheSameFacultyAndGroup(String name, String facultyName, int groupNumber) {
        List<Subject> subjects = new ArrayList<>();
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                subjects = faculty.getSubjectsFromTheSameFacultyAndGroup(name, groupNumber);
                break;
            }
        }
        return subjects;
    }

    public double getGradeFromTheSameFacultyAndGroup(String name, String faculty, int group) {
        List<Subject> subjects;
        subjects = getSubjectsFromTheSameFacultyAndGroup(name, faculty, group);
        double averageGrade = 0;
        for (Subject subject : subjects) {
            averageGrade += subject.getGrade();
        }
        System.out.println("In group number " + group + " of the " + faculty
                + " faculty average grade in the subject " + name + " is:");
        return averageGrade / subjects.size();
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }
}
