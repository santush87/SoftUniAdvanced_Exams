package cafe;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee martin = new Employee("Martin", 35, "Bulgaria");
        Employee ceco = new Employee("Ceco", 36, "Bulgaria");
        Employee botev = new Employee("Plamen", 34, "Bulgaria");

        Cafe prima = new Cafe("Prima", 3);
        prima.addEmployee(martin);
        prima.addEmployee(ceco);
        prima.addEmployee(botev);

        System.out.println(prima.getEmployee("Martin"));
        System.out.println(prima.getOldestEmployee());
        System.out.println(prima.getCount());

        System.out.println(prima.report());
    }
}
