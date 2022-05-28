package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish){
        boolean toAdd = true;
        if (this.fishInPool.size() < this.capacity){
            for (Fish fish1 : this.fishInPool){
                if (fish1.getName().equals(fish.getName())){
                    toAdd = false;
                }
            }
            if (toAdd){
                this.fishInPool.add(fish);
            }
        }
    }
    public boolean remove(String name){
        for (Fish fish : this.fishInPool){
            if (fish.getName().equals(name)){
                return this.fishInPool.remove(fish);
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish fish : this.fishInPool){
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }

    public String report(){
//        "Aquarium: {name} ^ Size: {size}
//          {Fish1}
//          {Fish2}
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Aquarium: %s ^ Size: %d%n", getName(), getSize()));
        for (int i = 0; i < this.fishInPool.size(); i++) {
            builder.append(fishInPool.get(i));
            if (i < fishInPool.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
