package Date_13April2022.Armory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] square = new char[n][n];

        for (int row = 0; row < n; row++) {
            square[row] = scanner.nextLine().toCharArray();
        }
        //myPosition
        int myRowPos = -1;
        int myColumnPos = -1;
        //First Mirror
        int mirrorFirstRow = -1;
        int mirrorFirstCol = -1;
        //Second Mirror
        int mirrorSecondRow = -1;
        int mirrorSecondCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (square[row][col] == 'A') {
                    myRowPos = row;
                    myColumnPos = col;
                }
                if (square[row][col] == 'M') {
                    if (mirrorFirstRow < 0) {
                        mirrorFirstRow = row;
                        mirrorFirstCol = col;
                    } else {
                        mirrorSecondRow = row;
                        mirrorSecondCol = col;
                    }
                }
            }
        }

        int coins = 0;
        boolean isGoing = true;

        while (isGoing) {
            String command = scanner.nextLine();
            int oldRowPos = myRowPos;
            int oldColPos = myColumnPos;

            switch (command) {
                case "up":
                    myRowPos--;
                    break;

                case "down":
                    myRowPos++;
                    break;

                case "left":
                    myColumnPos--;
                    break;

                case "right":
                    myColumnPos++;
                    break;
            }
            if (myRowPos < 0 || myRowPos >= n ||
                    myColumnPos < 0 || myColumnPos >= n) {
                square[oldRowPos][oldColPos] = '-';
                isGoing = false;

                //Проверка дали там където отиваме е "-"
            } else if (square[myRowPos][myColumnPos] == '-') {
                square[myRowPos][myColumnPos] = 'A';
                square[oldRowPos][oldColPos] = '-';

                //Проверка дали там където отиваме е "Р"
            } else if (square[myRowPos][myColumnPos] == 'M') {
                //Ако попадна на първият портал, тогава се прехвърлям на втория
                if (square[myRowPos][myColumnPos] == square[mirrorFirstRow][mirrorFirstCol]) {
                    square[oldRowPos][oldColPos] = '-';
                    square[myRowPos][myColumnPos] = '-';
                    myRowPos = mirrorSecondRow;
                    myColumnPos = mirrorSecondCol;
                    square[mirrorSecondRow][mirrorSecondCol] = 'A';

                    //Ако попадна на вторият портал, тогава се прехвърлям на първия
                } else {
                    square[oldRowPos][oldColPos] = '-';
                    square[myRowPos][myColumnPos] = '-';
                    myRowPos = mirrorFirstRow;
                    myColumnPos = mirrorFirstCol;
                    square[mirrorFirstRow][mirrorFirstCol] = 'A';
                }

                //Остава там където отиваме да е число и ще го добавим към сумата
            } else {
                coins += Integer.parseInt(String.valueOf(square[myRowPos][myColumnPos]));
                square[oldRowPos][oldColPos] = '-';
                square[myRowPos][myColumnPos] = 'A';
                if (coins > 65) {
                    isGoing = false;
                }
            }
        }

        if (coins <= 65) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", coins);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(square[row][col]);
            }
            System.out.println();
        }
    }
}
