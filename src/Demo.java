import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Demo {
    public static void main(String[] args) {
        Person mikolaj = new Person("Mikołaj", "Smith", LocalDate.now().minusYears(20), Person.sex.MALE, 10_000, new Address("Oświęcim"));
        Person test = new Person("Adrian", "Puchacki", LocalDate.of(1980, 1, 1), Person.sex.MALE, 0, new Address("Warszawa"));
        Person woman = new Person("Królowa", "Dzielni", LocalDate.of(1995, 1, 1), Person.sex.FEMALE, 3000, new Address("Kraków"));
        Person testAgain = new Person("Wojciech", "Puczyk", LocalDate.of(2005, 1, 1), Person.sex.MALE, 3000, new Address("Kraków"));

        List<Person> list = new ArrayList<>();
        list.add(test);
        list.add(mikolaj);
        list.add(woman);
        list.add(testAgain);
        /****************/
        List<Person> filteredList0 = list.stream().filter(p -> p.getBirthday().isAfter(LocalDate.now().minusYears(65))).filter(p -> p.getGender()== Person.sex.MALE).collect(Collectors.toList());
        System.out.println(Arrays.toString(filteredList0.toArray()));
        List<Person> filteredList1 = list.stream().filter(p -> p.getSalary() < 5000).filter(p -> p.getGender()== Person.sex.FEMALE).collect(Collectors.toList());
        System.out.println(Arrays.toString(filteredList1.toArray()));
        List<Person> filteredList2 = list.stream().filter(p -> p.getBirthday().isAfter(LocalDate.now().minusYears(18))).filter((p->p.getAddress().getCity().contains("Kraków"))).collect(Collectors.toList());
        System.out.println(Arrays.toString(filteredList2.toArray()));
        List<Person> filteredList3 = list.stream().filter(not(person -> person.getAddress().getCity().contains("Kraków"))).collect(Collectors.toList());
        System.out.println(Arrays.toString(filteredList3.toArray()));

        /******************/
        System.out.println(list.stream().mapToInt(Person::getSalary).average());
        System.out.println(list.stream().filter(p -> p.getGender()==Person.sex.FEMALE).count());
        System.out.println(list.stream().filter(p -> p.getGender()==Person.sex.MALE).filter(p -> p.getBirthday().isBefore(LocalDate.now().minusYears(65))).count());
        System.out.println(list.stream().min(Comparator.comparing(Person::getBirthday)));
        System.out.println(list.stream().filter(p->p.getAddress().getCity().contains("Kraków")).max(Comparator.comparing(Person::getBirthday)));
        System.out.println(list.stream().mapToInt(Person::getSalary).sum());
        /********************/
        Predicate<Person> any   = p -> p.getFirstName().startsWith("A");
        Predicate<Person> all   = p -> p.getLastName().contains("a");
        /********************/
        System.out.println(filteredList0.stream().anyMatch(any));
        System.out.println(filteredList0.stream().allMatch(all));
        System.out.println(filteredList1.stream().anyMatch(any));
        System.out.println(filteredList1.stream().allMatch(all));
        System.out.println(filteredList2.stream().anyMatch(any));
        System.out.println(filteredList2.stream().allMatch(all));
        System.out.println(filteredList3.stream().anyMatch(any));
        System.out.println(filteredList3.stream().allMatch(all));

    }
}
