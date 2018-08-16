package jdk8.lambada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {


    public int getAge() {
        return LocalDate.now().compareTo(birthday);
    }

    public void printPerson() {
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    public static List<Person> createRoster() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", LocalDate.of(1990, 1, 2), Sex.MALE, "xxxxxx"));
        list.add(new Person("lisi", LocalDate.of(1980, 1, 2), Sex.MALE, "xxxxxx"));
        list.add(new Person("hexiaohua", LocalDate.of(1970, 1, 2), Sex.FEMALE, "xxxxxx"));
        list.add(new Person("guxiaolan", LocalDate.of(1977, 1, 2), Sex.FEMALE, "xxxxxx"));
        list.add(new Person("yangguo", LocalDate.of(1987, 1, 2), Sex.FEMALE, "xxxxxx"));
        list.add(new Person("wangwu", LocalDate.of(1967, 1, 2), Sex.MALE, "xxxxxx"));
        list.add(new Person("wangba", LocalDate.of(1997, 1, 2), Sex.MALE, "xxxxxx"));
        return list;
    }
}
