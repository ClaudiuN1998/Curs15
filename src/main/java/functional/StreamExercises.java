package functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamExercises {
    public static void main(String[] args) {


        List<Person> persons = List.of(
                new Person("Andrei", "Ungureanu", 30, "Brasov"),
                new Person("Marius", "Muresan", 22, "Bistrita"),
                new Person("Ioan", "Ionescu", 55, "Bucuresti"),
                new Person("Mara", "Stolniceanu", 62, "Botosani"),
                new Person("Ana", "Popa", 67, "Cluj"),
                new Person("Ilona", "Gherasim", 18, "Oradea"),
                new Person("Carmen", "Titulescu", 17, "Timisoara"),
                new Person("Attila", "Tamas", 44, "Oradea"),
                new Person("Anca", "Ibanescu", 27, "Iasi"),
                new Person("Natalia", "Zizin", 31, "Sibiu"),
                new Person("Claudiu", "Cioiu", 50, "Cluj"),
                new Person("Alexandru", "Roseti", 40, "Ploiesti"),
                new Person("Zenobia", "Xenopol", 87, "Constanta")
        );

        List<String> firstExercise = persons.stream().map(person -> person.firstName() + " " + person.lastName()).toList();
        List<Person> secondExercise = persons.stream().filter(person -> person.age() > 18).toList();

       List<Person> thirdExercise = persons.stream().filter(person -> person.city.("Oradea")).toList();



       List<Person> exerciseNo5 = persons.stream().map(firstName -> firstName.toUpperCase()).toList();
       List<String> exerciseNo6 = persons.stream().map(person -> person.firstName())
               .map(lastName -> lastName.charAt(0))
               .toList();

        List<Person> exerciseNo10 = persons.stream().sorted(Comparator.comparing((Person::firstName))).toList();
        List<Person> exerciseNo11 = persons.stream().sorted(Comparator.comparing((Person::lastName))).toList();

        List<Person> exerciseNo12 = persons.stream()
                .sorted(Comparator.comparing(Person::firstName).thenComparing(Person::lastName).thenComparingInt(Person::age))
                .toList();


    }
}

record Person(String firstName, String lastName, int age, String city){

}


