package cafe;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", this.name, this.age, this.country);
    }


    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (employee1.getAge() > employee2.getAge()) {
            return -1;
        } else if (employee1.getAge() == employee2.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }
}
