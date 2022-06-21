package Date_19Aug2020;

import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[number][number];

        int beePosRow = -1;
        int beePosCol = -1;
        int pollinate = 0;

        for (int row = 0; row < number; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < number; col++) {
                if (matrix[row][col].equals("B")) {
                    beePosRow = row;
                    beePosCol = col;
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd) {
            String command = scanner.nextLine();
            if (command.equals("End")){
                isEnd = true;
            }else {
                matrix[beePosRow][beePosCol] = ".";
                switch (command) {
                    case "up":
                        beePosRow--;
                        if (beePosRow < 0) {
                            isEnd = true;
                            System.out.println("The bee got lost!");
                            continue;
                        } else if (matrix[beePosRow][beePosCol].equals("O")) {
                            matrix[beePosRow][beePosCol] = ".";
                            beePosRow--;
                        }
                        break;
                    case "down":
                        beePosRow++;
                        if (beePosRow >= number) {
                            isEnd = true;
                            System.out.println("The bee got lost!");
                            continue;
                        } else if (matrix[beePosRow][beePosCol].equals("O")) {
                            matrix[beePosRow][beePosCol] = ".";
                            beePosRow++;
                        }
                        break;
                    case "left":
                        beePosCol--;
                        if (beePosCol < 0) {
                            isEnd = true;
                            System.out.println("The bee got lost!");
                            continue;
                        } else if (matrix[beePosRow][beePosCol].equals("O")) {
                            matrix[beePosRow][beePosCol] = ".";
                            beePosCol--;
                        }
                        break;
                    case "right":
                        beePosCol++;
                        if (beePosCol >= number) {
                            isEnd = true;
                            System.out.println("The bee got lost!");
                            continue;
                        } else if (matrix[beePosRow][beePosCol].equals("O")) {
                            matrix[beePosRow][beePosCol] = ".";
                            beePosCol++;
                        }
                        break;
                }

                if (matrix[beePosRow][beePosCol].equals("f")) {
                    pollinate++;
                }
                matrix[beePosRow][beePosCol] = "B";
            }
        }

        if (pollinate >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %s flowers!\n", pollinate);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinate);
        }

        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
