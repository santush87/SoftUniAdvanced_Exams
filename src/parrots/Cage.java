package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < getCapacity()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.remove(findParrot(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = findParrot(name);
        if (parrot != null){
            for (Parrot parrot1: this.data){
                if (parrot.equals(parrot1)){
                    parrot1.setAvailable(false);
                    return parrot;
                }
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> parrotList = new ArrayList<>();
        for (Parrot parrot : this.data ){
            if (parrot.getSpecies().equals(species)){
                parrotList.add(parrot);
                parrot.setAvailable(false);
            }
        }
        return parrotList;
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:%n",this.name));
        this.data.stream()
                .filter(s->s.isAvailable()==true)
                .forEach(s->builder.append(s+"\n"));
        return builder.toString();
    }

    private Parrot findParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                return parrot;
            }
        }
        return null;
    }
}
