package Date_25Jun2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ItsChocolateTime_01 {
    static final double MILK_CHOCOLATE = 30;
    static final double DARK_CHOCOLATE = 50;
    static final double BAKING_CHOCOLATE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] first = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] sec = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();

        for (double num : first) {
            milk.offer(num);
        }
        for (double num : sec) {
            cacaoPowder.push(num);
        }
        int milkChoko = 0;
        int darkChoko = 0;
        int bakingChoko = 0;

        while (!milk.isEmpty() && !cacaoPowder.isEmpty()) {
            double one = milk.poll();
            double two = cacaoPowder.pop();
            double res = Math.round(two / (one + two) * 100);

            if (res == MILK_CHOCOLATE) {
                milkChoko++;
            } else if (res == DARK_CHOCOLATE) {
                darkChoko++;
            } else if (res == BAKING_CHOCOLATE) {
                bakingChoko++;
            } else {
                milk.offer(one + 10);
            }
        }

        if (milkChoko > 0 && darkChoko > 0 && bakingChoko > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (bakingChoko > 0) {
            System.out.printf(" # Baking Chocolate --> %d\n", bakingChoko);
        }
        if (darkChoko > 0) {
            System.out.printf(" # Dark Chocolate --> %d\n", darkChoko);
        }
        if (milkChoko > 0) {
            System.out.printf(" # Milk Chocolate --> %d", milkChoko);
        }
    }
}
