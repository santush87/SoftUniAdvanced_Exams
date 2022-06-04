package cafe;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                return employees.remove(employee);
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee employee = new Employee();
        int age = -1;
        for (Employee employee1 : this.employees){
            if (employee1.getAge() > age){
                age = employee1.getAge();
                employee = employee1;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees){
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
        builder.append(String.format("Employees working at Cafe %s:%n",name));
        for (int i = 0; i < this.employees.size(); i++) {
            builder.append(employees.get(i));
            if (i < this.employees.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
