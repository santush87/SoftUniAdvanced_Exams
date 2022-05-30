package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Person person){
        if (roster.size()<getCapacity()){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person person : roster){
            if (person.getName().equals(name)){
                return roster.remove(person);
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        for (Person person : roster){
            if (person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The people in the hotel %s are:%n", getName()));
        for (int i = 0; i < roster.size(); i++) {
            builder.append(roster.get(i));
            if (i < roster.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
