package aquarium;

public class Main {
    public static void main(String[] args) {

        Fish fish = new Fish("Martin", "Red", 2);
        Fish fish2 = new Fish("Anatol", "Blue", 5);
        Fish fish3 = new Fish("Ceco", "Orange", 3);

        Aquarium aquarium = new Aquarium("Aqua", 4,5);
        aquarium.add(fish);
        aquarium.add(fish2);
        aquarium.add(fish3);

        aquarium.remove("Ceco");

        System.out.println(aquarium.getFishInPool());

    }
}
