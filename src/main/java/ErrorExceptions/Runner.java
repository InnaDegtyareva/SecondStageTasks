package ErrorExceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Group G1 = new Group(Arrays.asList(
                new Student("Potter", "Harry", Arrays.asList(new Subject("History of Magic", 10),
                        new Subject("Muggle Studies", 10), new Subject("Transfiguration", 10))),
                new Student("Weasley", "Ronald", Arrays.asList(new Subject("History of Magic", 4),
                        new Subject("Muggle Studies", 3), new Subject("Transfiguration", 4)))),
                1);
        Group G2 = new Group(Arrays.asList(
                new Student("Granger", "Hermione", Arrays.asList(new Subject("History of Magic", 10),
                        new Subject("Muggle Studies", 10), new Subject("Transfiguration", 10))),
                new Student("Longbottom", "Neville", Arrays.asList(new Subject("History of Magic", 8),
                        new Subject("Muggle Studies", 7), new Subject("Transfiguration", 7)))),
                2);
        Group S1 = new Group(Arrays.asList(
                new Student("Malfoy", "Draco", Arrays.asList(new Subject("History of Magic", 5),
                        new Subject("Muggle Studies", 7), new Subject("Transfiguration", 6))),
                new Student("Crabbe", "Vincent", Arrays.asList(new Subject("History of Magic", 7),
                        new Subject("Muggle Studies", 5), new Subject("Transfiguration", 8)))),
                1);
        Group S2 = new Group(Arrays.asList(
                new Student("Parkinson", "Pansy", Arrays.asList(new Subject("History of Magic", 7),
                        new Subject("Muggle Studies", 8), new Subject("Transfiguration", 6))),
                new Student("Flint", "Marcus", Arrays.asList(new Subject("History of Magic", 6),
                        new Subject("Muggle Studies", 8), new Subject("Transfiguration", 5)))),
                2);
        Group R1 = new Group(Arrays.asList(
                new Student("Lovegood", "Luna", Arrays.asList(new Subject("History of Magic", 5),
                        new Subject("Muggle Studies", 6), new Subject("Transfiguration", 6))),
                new Student("Chang", "Cho", Arrays.asList(new Subject("History of Magic", 3),
                        new Subject("Muggle Studies", 4), new Subject("Transfiguration", 3)))),
                1);
        Group R2 = new Group(Arrays.asList(
                new Student("Davies", "Roger", Arrays.asList(new Subject("History of Magic", 7),
                        new Subject("Muggle Studies", 8), new Subject("Transfiguration", 6))),
                new Student("Edgecombe", "Marietta", Arrays.asList(new Subject("History of Magic", 3),
                        new Subject("Muggle Studies", 4), new Subject("Transfiguration", 3)))),
                2);
        Group H1 = new Group(Arrays.asList(
                new Student("Diggory", "Cedric", Arrays.asList(new Subject("History of Magic", 7),
                        new Subject("Muggle Studies", 7), new Subject("Transfiguration", 8))),
                new Student("Smith", "Zacharias", Arrays.asList(new Subject("History of Magic", 5),
                        new Subject("Muggle Studies", 7), new Subject("Transfiguration", 5)))),
                1);

        List<Group> gryffindorGroups = new ArrayList<>();
        gryffindorGroups.add(G1);
        gryffindorGroups.add(G2);

        List<Group> slytherinGroups = new ArrayList<>();
        slytherinGroups.add(S1);
        slytherinGroups.add(S2);

        List<Group> ravenclawGroups = new ArrayList<>();
        ravenclawGroups.add(R1);
        ravenclawGroups.add(R2);

        List<Group> hufflepuffGroups = new ArrayList<>();
        hufflepuffGroups.add(H1);

        Faculty gryffindor = new Faculty(gryffindorGroups, "Gryffindor");
        Faculty slytherin = new Faculty(slytherinGroups, "Slytherin");
        Faculty ravenclaw = new Faculty(ravenclawGroups, "Ravenclaw");
        Faculty hufflepuff = new Faculty(hufflepuffGroups, "Hufflepuff");

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(gryffindor);
        faculties.add(slytherin);
        faculties.add(ravenclaw);
        faculties.add(hufflepuff);

        University hogwarts = new University(faculties);

        System.out.printf("%.1f%n", hogwarts.getStudentAverageGrade("Diggory", "Cedric"));

        System.out.printf("%.1f%n", hogwarts.getSubjectAverageGrade("Transfiguration"));
        System.out.printf("%.1f", hogwarts.getGradeFromTheSameFacultyAndGroup("Muggle Studies", "Ravenclaw",
                2));
    }
}
