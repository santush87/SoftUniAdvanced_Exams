package Date_14Apr2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededBouquets = 5;
        int myBouquets = 0;
        int remainingFlowers = 0;

        int[] first = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        for (int num : first) {
            tulips.push(num);
        }
        for (int num : second) {
            daffodils.add(num);
        }

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int lastTulip = tulips.poll();
            int firstDaff = daffodils.peek();
            int sumFlowers = lastTulip + firstDaff;

            if (sumFlowers == 15) {
                myBouquets++;
                daffodils.pop();
            } else if (sumFlowers > 15) {
                tulips.push(lastTulip - 2);
            } else {
                remainingFlowers += sumFlowers;
                daffodils.pop();
            }
        }

        int lastBouquets = remainingFlowers / 15;
        myBouquets += lastBouquets;

        if (myBouquets >= neededBouquets){
            System.out.printf("You made it! You go to the competition with %d bouquets!", myBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", neededBouquets - myBouquets);
        }
    }
}
