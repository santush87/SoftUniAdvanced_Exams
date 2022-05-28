package Date_23Oct2021;

import java.util.*;

public class AutumnCocktails_01 {
    private static final int PEAR_SOUR = 150;
    private static final int THE_HARVEST = 250;
    private static final int APPLE_HINNY = 300;
    private static final int HIGH_FASHION = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ingridString = scanner.nextLine().split("\\s+");
        String[] freshString = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        for (String ingrid : ingridString) {
            ingredients.offer(Integer.parseInt(ingrid));
        }
        for (String fresh : freshString) {
            freshness.push(Integer.parseInt(fresh));
        }
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        boolean pear = false;
        boolean harvest = false;
        boolean hinny = false;
        boolean high = false;

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int ingrid = ingredients.poll();
            if (ingrid <= 0) {
                continue;
            }
            int fresh = freshness.pop();


            int sum = ingrid * fresh;
            switch (sum) {
                case PEAR_SOUR:
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    pear = true;
                    break;
                case THE_HARVEST:
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    harvest = true;
                    break;
                case APPLE_HINNY:
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    hinny = true;
                    break;
                case HIGH_FASHION:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    high = true;
                    break;
                default:
                    ingrid += 5;
                    ingredients.offer(ingrid);
                    break;
            }
        }

        if (pear && high && hinny && harvest) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (ingredients.size() > 0) {
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktails.entrySet()
                .stream()
                .filter(s -> s.getValue() > 0)
                .forEach(s -> System.out.println(" # " + s.getKey() + " --> " + s.getValue()));
    }
}
