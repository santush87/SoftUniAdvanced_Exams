package Date_28Jun2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs_01 {
    static final int DATURA_BOMBS = 40;
    static final int CHERRY_BOMBS = 60;
    static final int SMOKE_DECOY_BOMBS = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sec = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        for (int num : first) {
            bombEffect.offer(num);
        }
        for (int num : sec) {
            bombCasing.push(num);
        }

        int datura = 0;
        int cherry = 0;
        int smokeDecoy = 0;

        while (!bombEffect.isEmpty() && !bombCasing.isEmpty()) {
            int effect = bombEffect.peek();
            int casing = bombCasing.pop();
            int sum = effect + casing;

            switch (sum) {
                case DATURA_BOMBS:
                    datura++;
                    bombEffect.poll();
                    break;
                case CHERRY_BOMBS:
                    cherry++;
                    bombEffect.poll();
                    break;
                case SMOKE_DECOY_BOMBS:
                    smokeDecoy++;
                    bombEffect.poll();
                    break;
                default:
                    bombCasing.push(casing - 5);
            }
            if (datura >= 3 && cherry >= 3 && smokeDecoy >= 3) {
                break;
            }
        }

        if (datura >= 3 && cherry >= 3 && smokeDecoy >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            int size = bombEffect.size();
            for (int i = 0; i < size; i++) {
                System.out.print(bombEffect.poll());
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            int size = bombCasing.size();
            for (int i = 0; i < size; i++) {
                System.out.print(bombCasing.pop());
                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoy);
    }
}
