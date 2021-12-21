package ErrorExceptions;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<Group> groups;
    private String name;

    public Faculty(List<Group> groups, String name) {
        this.groups = groups;
        this.name = name;
        if (groups.size() == 0) {
            try {
                throw new GroupException();
            } catch (GroupException e) {
                System.out.println("Check list! There is no group on " + name + " faculty!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public Student getStudentBySurnameAndName(String surname, String name) {
        Student searchStudent = null;
        for (Group group : groups) {
            searchStudent = group.getStudentBySurnameAndName(surname, name);
            if (searchStudent != null) {
                break;
            }
        }
        return searchStudent;
    }

    public List<Subject> getSubjects(String name) {
        List<Subject> subjects = new ArrayList<>();
        for (Group group : groups) {
            subjects.addAll(group.getSubjects(name));
        }
        return subjects;
    }

    public List<Subject> getSubjectsFromTheSameFacultyAndGroup(String name, int groupNumber) {
        List<Subject> subjects = new ArrayList<>();
        for (Group group : groups) {
            if (group.getNumberOfGroup() == groupNumber) {
                subjects = group.getSubjects(name);
            }
        }
        return subjects;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "groups=" + groups +
                ", name='" + name + '\'' +
                '}';
    }
}
