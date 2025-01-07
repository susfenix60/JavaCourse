package pl.susfenix.course.backend.game.tictactoe.model;

public class Person {

    private static final String FAVORITE_COLOR = "RED";

    private String firstName;
    private String lastName;
    private int age;
    private Address mainAddress;
    private Address contactAddress;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, Address mainAddress, Address contactAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mainAddress = mainAddress;
        this.contactAddress = contactAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public Address getContactAddress() {
        return contactAddress;
    }

    public static Person create(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mainAddress=" + mainAddress +
                ", contactAddress=" + contactAddress +
                '}';
    }

    public boolean isAdult() {
        return this.age >= 18;
    }

    public Person createWhenAdult() {
        if (isAdult()) {
            return Person.create(this.firstName, this.lastName, this.age + 1);
        }

        return this;
    }
}
