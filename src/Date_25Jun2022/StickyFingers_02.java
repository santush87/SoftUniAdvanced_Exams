package Date_25Jun2022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(",");
        ArrayDeque<String> arrInput = new ArrayDeque<>();
        for (String s : input) {
            arrInput.offer(s);
        }

        String[][] matrix = new String[num][num];
        int myPosRow = -1;
        int myPosCol = -1;

        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("D")) {
                    myPosRow = row;
                    myPosCol = col;
                }
            }
        }

        int houseRobt = 0;

        boolean isCought = false;
        while (!arrInput.isEmpty()) {

            int prevPosRow = myPosRow;
            int prevPosCol = myPosCol;

            String command = arrInput.poll();
            switch (command) {
                case "up":
                    myPosRow--;
                    if (myPosRow < 0) {
                        myPosRow = 0;
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    myPosRow++;
                    if (myPosRow >= num) {
                        myPosRow = num - 1;
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    myPosCol--;
                    if (myPosCol < 0) {
                        myPosCol = 0;
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    myPosCol++;
                    if (myPosCol >= num) {
                        myPosCol = num - 1;
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            matrix[prevPosRow][prevPosCol] = "+";

            if (matrix[myPosRow][myPosCol].equals("$")) {
                int sum = myPosRow * myPosCol;
                houseRobt += sum;
                System.out.printf("You successfully stole %d$.\n", sum);
                matrix[myPosRow][myPosCol] = "D";
            } else if (matrix[myPosRow][myPosCol].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", houseRobt);
                matrix[myPosRow][myPosCol] = "#";
                isCought = true;
                break;
            }
            matrix[myPosRow][myPosCol] = "D";


        }

        if (!isCought) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", houseRobt);
        }

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
