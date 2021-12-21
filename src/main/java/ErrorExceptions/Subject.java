package ErrorExceptions;

public class Subject {
    private String name;
    private int grade;

    public Subject(String name, int grade) {
        this.name = name;
        this.grade = grade;



        if (grade > 10 || grade < 0 ) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Check the grades! Students grade must be from 0 to 10!");
            }
        }
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
