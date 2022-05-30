package Date_18Aug2021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PastryShop_01 {
    private static final int BISCUIT = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] likStr = scanner.nextLine().split("\\s+");
        String[] ingStr = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (String lik : likStr) {
            liquids.offer(Integer.parseInt(lik));
        }
        for (String ing : ingStr) {
            ingredients.push(Integer.parseInt(ing));
        }
        int bisk = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int lik = liquids.poll();
            int ing = ingredients.pop();
            int sum = lik + ing;

            switch (sum) {
                case BISCUIT:
                    bisk++;
                    break;
                case CAKE:
                    cake++;
                    break;
                case PASTRY:
                    pastry++;
                    break;
                case PIE:
                    pie++;
                    break;
                default:
                    ingredients.push(ing + 3);
                    break;
            }
        }

        if (bisk > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.print("none");
        } else {
            int size = liquids.size();
            for (int i = 0; i < size; i++) {
                System.out.print(liquids.poll());
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.print("none");
        } else {
            int size = ingredients.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ingredients.pop());
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();

        System.out.printf("Biscuit: %d%n", bisk);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Pie: %d%n", pie);
        System.out.printf("Pastry: %d", pastry);
    }
}
