package Date_26Jun2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OS_Planing_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sec = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int taskToKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> task = new ArrayDeque<>();
        ArrayDeque<Integer> thread = new ArrayDeque<>();

        for (int i = 0; i < first.length; i++) {
            task.push(first[i]);
        }

        for (int i = 0; i < sec.length; i++) {
            thread.add(sec[i]);
        }

        boolean theEnd = false;

        while (!theEnd) {
            int currThread = thread.peek();
            int currTask = task.peek();

            if (currTask == taskToKill) {
                theEnd = true;
                System.out.printf("Thread with value %d killed task %d%n", currThread, taskToKill);
                int num = thread.size();
                for (int i = 0; i < num; i++) {
                    System.out.print(thread.poll() + " ");
                }
            } else {
                if (currThread >= currTask) {
                    task.pop();
                    thread.poll();
                } else {
                    thread.poll();
                }
            }


            if (task.isEmpty() || thread.isEmpty()) {
                theEnd = true;
            }
        }
        System.out.println();
    }
}
