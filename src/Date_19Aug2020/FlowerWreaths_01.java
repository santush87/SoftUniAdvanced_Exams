package Date_19Aug2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sec = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int wreath = 0;
        int remainingSum = 0;

        for (int num : first) {
            lilies.push(num);
        }
        for (int num : sec) {
            roses.offer(num);
        }

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int li = lilies.poll();
            int ro = roses.peek();
            int sum = li + ro;

            if (sum == 15) {
                wreath++;
                roses.pop();
            } else if (sum < 15) {
                remainingSum += sum;
                roses.pop();
            } else {
                lilies.push(li - 2);
            }
        }

        wreath += (remainingSum / 15);
        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreath);
        }
    }
}
