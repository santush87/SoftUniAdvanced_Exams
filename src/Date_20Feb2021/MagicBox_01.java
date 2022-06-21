package Date_20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputFirst = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputSec = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        for (int num : inputFirst) {
            firstMagicBox.add(num);
        }

        for (int num : inputSec) {
            secondMagicBox.push(num);
        }

        int sum = 0;

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int theFirstNum = firstMagicBox.peek();
            int theSecondNum = secondMagicBox.peek();
            int currSum = theFirstNum + theSecondNum;

            if (currSum % 2 == 0) {
                sum += currSum;
                firstMagicBox.pop();
                secondMagicBox.poll();
            } else {
                secondMagicBox.poll();
                firstMagicBox.add(theFirstNum);
            }
        }

        if (firstMagicBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", sum);
        }else {
            System.out.printf("Poor prey... Value: %d", sum);
        }
    }
}
