import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static javafx.scene.input.KeyCode.R;
import static javafx.scene.input.KeyCode.T;

public class ExerciseLambdaJava8 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Miral", "Patel", 33),
                new Person("Jiten", "Patel", 35),
                new Person("Sahaj", "Patel", 4),
                new Person("Shreya", "Amin", 33),
                new Person("Hemali", "Patel", 34)
        );

        // print all
        people.forEach(System.out::println);

        // sort by last name
        System.out.println("SORTING BY LASTNAME --------------");
        Collections.sort(people, ((o1, o2) -> o1.getLastName().compareTo(o2.getLastName())));
        people.forEach(System.out::println);

        // sort by last name
        System.out.println("SORTING BY FIRSTNAME --------------");
        Collections.sort(people, (Comparator.comparing(Person::getFirstName)));
        people.forEach(System.out::println);

        System.out.println("START WITH  --------------");
        printLambda(people, p -> p.getFirstName().startsWith("S"));
    }

    private static void printLambda(List<Person> people, Predicate<Person> p) {
        people.forEach(person -> {
            if (p.test(person)) {
                System.out.println(person);
            }
        });
        /*for (Person person : people) {
            if (p.test(person)) {
                System.out.println(person);
            }
        }*/
    }
}
