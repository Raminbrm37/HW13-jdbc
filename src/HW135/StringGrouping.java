package HW135;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringGrouping {
    public static void main(String[] args) {
        System.out.println(Stream.of("ali","amir","mehdi","reza","karim")
                .collect(Collectors.groupingBy(String::length)));
        List<String> nameList = Arrays.asList(
               "Amir",
               "Hatef",
                "Mehran",
               "Mojtaba",
                "Mohammad",
                "Ali",
               "Davood",
                "Reza",
               "Mohsen"
        );

        List<Person> persons = Arrays.asList(
                new Person("Ali", 2500, Person.Gender.MALE),
                new Person("Reza", 3000, Person.Gender.MALE),
                new Person("Naznain", 2400, Person.Gender.FEMALE),
                new Person("Sara", 2100, Person.Gender.FEMALE),
                new Person("Mahshad", 2600, Person.Gender.FEMALE),
                new Person("Ramin", 2800, Person.Gender.MALE),
                new Person("Mahdi", 2900, Person.Gender.MALE)
        );
        Map<Person.Gender, Double> personsMap = persons
                .stream().collect(Collectors
                        .groupingBy(Person::getGender,Collectors.summingDouble(Person::getSalary)));

        System.out.println(personsMap);
Map<Integer,List<String>> listMap=nameList.stream()
        .collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(listMap);

    }

}