package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private final List<Egg> data;
    private final String material;
    private final int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        boolean toAdd = true;
        if (this.data.size() < capacity) {
            for (Egg egg1 : this.data) {
                if (egg1.getStrength() == egg.getStrength() ||
                        egg1.getColor().equals(egg.getColor())) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd){
                this.data.add(egg);
            }
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return this.data.remove(egg);
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {

        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
//        if (this.data.size()>0){
//            this.data.stream().sorted(Comparator.reverseOrder());
//            return this.data.get(0);
//        }
//        return null;
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(e->e.getColor().equals(color)).findFirst().orElse(null);
//        for (Egg egg : this.data) {
//            if (egg.getColor().equals(color)) {
//                return egg;
//            }
//        }
//        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s basket contains:%n", this.material));
        for (int i = 0; i < this.data.size(); i++) {
            Egg egg = this.data.get(i);
            builder.append(egg);
            if (i< this.data.size()-1){
                builder.append(System.lineSeparator());
            }

        }
        return builder.toString();
    }
}
