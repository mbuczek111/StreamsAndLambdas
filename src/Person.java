import java.time.LocalDate;

public class Person {
    String firstName;
    String lastName;
    LocalDate birthday;
    private sex gender;
    int salary;
    Address address;

    public enum sex
    {
        FEMALE,
        MALE;
    }

    public Person(String firstName, String lastName, LocalDate birthday, Person.sex gender, int salary, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public sex getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }
}
