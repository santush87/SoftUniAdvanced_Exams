package Date_16Dec2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Cooking {

    static final int BREAD = 25;
    static final int CAKE = 50;
    static final int PASTRY = 75;
    static final int FRUIT_PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sec = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        for (int num : first) {
            liquids.add(num);
        }
        for (int num : sec) {
            ingredients.push(num);
        }

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int theLiq = liquids.pop();
            int theIng = ingredients.poll();
            int sum = theIng + theLiq;

            switch (sum) {
                case BREAD:
                    bread++;
                    break;
                case CAKE:
                    cake++;
                    break;
                case PASTRY:
                    pastry++;
                    break;
                case FRUIT_PIE:
                    fruitPie++;
                    break;
                default:
                    ingredients.push(theIng + 3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            int liqSize = liquids.size();
            for (int i = 0; i < liqSize; i++) {
                System.out.print(liquids.pop());
                if (i<liqSize-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            int ingSize = ingredients.size();
            for (int i = 0; i < ingSize; i++) {
                System.out.print(ingredients.poll());
                if (i<ingSize-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
