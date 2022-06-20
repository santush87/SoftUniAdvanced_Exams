package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private final int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                return this.data.remove(pet);
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:");
        builder.append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            builder.append(this.data.get(i));
            if (i < this.data.size() - 1) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

}
