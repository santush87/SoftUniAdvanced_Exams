package Date_22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] input2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstInputBox = new ArrayDeque<>();
        ArrayDeque<Integer> secInputBox = new ArrayDeque<>();

        for (int num : input1) {
            firstInputBox.offer(num);
        }
        for (int num : input2) {
            secInputBox.push(num);
        }

        int result = 0;

        while (!firstInputBox.isEmpty() && !secInputBox.isEmpty()) {
            int one = firstInputBox.peek();
            int two = secInputBox.pop();
            int sum = one + two;

            if (sum % 2 == 0) {
                result += sum;
                firstInputBox.poll();
            } else {
                firstInputBox.offer(two);
            }
        }

        if (firstInputBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secInputBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (result >= 100) {
            System.out.printf("Your loot was epic! Value: %d", result);
        } else {
            System.out.printf("Your loot was poor... Value: %d", result);
        }
    }
}
