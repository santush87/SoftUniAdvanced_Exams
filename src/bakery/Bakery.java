package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private final String name;
    private final int capacity;
    private final List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee employee = new Employee();
        for (Employee empl : this.employees) {
            if (empl.getAge() > employee.getAge()) {
                employee = empl;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:", this.name)).append(System.lineSeparator());
        for (int i = 0; i < this.employees.size(); i++) {
            builder.append(this.employees.get(i));
            if (i < this.employees.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
