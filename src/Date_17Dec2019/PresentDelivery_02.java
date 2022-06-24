package Date_17Dec2019;

import java.util.Scanner;

public class PresentDelivery_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presCount = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[num][num];
        int myPosRow = -1;
        int myPosCol = -1;

        int goodKidsCount = 0;
        int totalGoodKids = 0;


        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("S")) {
                    myPosRow = row;
                    myPosCol = col;
                }
                if (matrix[row][col].equals("V")) {
                    goodKidsCount++;
                    totalGoodKids++;
                }
            }
        }


        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            matrix[myPosRow][myPosCol] = "-";

            switch (command) {
                case "up":
                    myPosRow--;
                    break;
                case "down":
                    myPosRow++;
                    break;
                case "left":
                    myPosCol--;
                    break;
                case "right":
                    myPosCol++;
                    break;
            }

            if (matrix[myPosRow][myPosCol].equals("V")) {
                presCount--;
                goodKidsCount--;
            }
            if (matrix[myPosRow][myPosCol].equals("C")) {
                if (matrix[myPosRow - 1][myPosCol].equals("V") || matrix[myPosRow - 1][myPosCol].equals("X")) {
                    matrix[myPosRow - 1][myPosCol] = "-";
                    presCount--;
                    if (matrix[myPosRow - 1][myPosCol].equals("V")) {
                        goodKidsCount--;
                    }
                }
                if (matrix[myPosRow + 1][myPosCol].equals("V") || matrix[myPosRow - 1][myPosCol].equals("X")) {
                    matrix[myPosRow + 1][myPosCol] = "-";
                    presCount--;
                    if (matrix[myPosRow + 1][myPosCol].equals("V")) {
                        goodKidsCount--;
                    }
                }
                if (matrix[myPosRow][myPosCol - 1].equals("V") || matrix[myPosRow - 1][myPosCol].equals("X")) {
                    matrix[myPosRow][myPosCol - 1] = "-";
                    presCount--;
                    if (matrix[myPosRow][myPosCol - 1].equals("V")) {
                        goodKidsCount--;
                    }
                }
                if (matrix[myPosRow][myPosCol + 1].equals("V") || matrix[myPosRow - 1][myPosCol].equals("X")) {
                    matrix[myPosRow][myPosCol + 1] = "-";
                    presCount--;
                    if (matrix[myPosRow][myPosCol + 1].equals("V")) {
                        goodKidsCount--;

                    }
                }
            }

            matrix[myPosRow][myPosCol] = "S";

            if (presCount == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            command = scanner.nextLine();
        }

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }

        if (goodKidsCount == 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.", totalGoodKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", goodKidsCount);
        }
    }
}
