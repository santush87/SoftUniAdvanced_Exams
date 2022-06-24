package Date_22Feb2020;

import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int countCom = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[num][num];
        int myPosRow = -1;
        int myPosCol = -1;

        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("f")) {
                    myPosRow = row;
                    myPosCol = col;
                }
            }
        }

        boolean isEnd = false;
        for (int i = 0; i < countCom; i++) {
            String command = scanner.nextLine();

            matrix[myPosRow][myPosCol] = "-";
            switch (command) {
                case "up":
                    myPosRow--;
                    if (myPosRow < 0) {
                        myPosRow = num - 1;
                    }
                    if (matrix[myPosRow][myPosCol].equals("B")){
                        myPosRow--;
                        if (myPosRow < 0) {
                            myPosRow = num - 1;
                        }
                    }

                    switch (matrix[myPosRow][myPosCol]) {
                        case "T":
                            myPosRow++;
                            break;
                        case "F":
                            matrix[myPosRow][myPosCol] = "f";
                            isEnd = true;
                            break;
                        default:
                            matrix[myPosRow][myPosCol] = "f";
                            break;
                    }
                    break;
                case "down":
                    myPosRow++;
                    if (myPosRow >= num) {
                        myPosRow = 0;
                    }
                    if (matrix[myPosRow][myPosCol].equals("B")){
                        myPosRow++;
                        if (myPosRow >= num) {
                            myPosRow = 0;
                        }
                    }
                    switch (matrix[myPosRow][myPosCol]) {
                        case "T":
                            myPosRow--;
                            break;
                        case "F":
                            matrix[myPosRow][myPosCol] = "f";
                            isEnd = true;
                            break;
                        default:
                            matrix[myPosRow][myPosCol] = "f";
                            break;
                    }
                    break;
                case "left":
                    myPosCol--;
                    if (myPosCol < 0) {
                        myPosCol = num - 1;
                    }
                    if (matrix[myPosRow][myPosCol].equals("B")){
                        myPosCol--;
                        if (myPosCol < 0) {
                            myPosCol = num - 1;
                        }
                    }
                    switch (matrix[myPosRow][myPosCol]) {
                        case "T":
                            myPosCol++;
                            break;
                        case "F":
                            matrix[myPosRow][myPosCol] = "f";
                            isEnd = true;
                            break;
                        default:
                            matrix[myPosRow][myPosCol] = "f";
                            break;
                    }
                    break;
                case "right":
                    myPosCol++;
                    if (myPosCol >= num) {
                        myPosCol = 0;
                    }
                    if (matrix[myPosRow][myPosCol].equals("B")){
                        myPosCol++;
                        if (myPosCol >= num) {
                            myPosCol = 0;
                        }
                    }
                    switch (matrix[myPosRow][myPosCol]) {
                        case "T":
                            myPosCol--;
                            break;
                        case "F":
                            matrix[myPosRow][myPosCol] = "f";
                            isEnd = true;
                            break;
                        default:
                            matrix[myPosRow][myPosCol] = "f";
                            break;
                    }
                    break;
            }

            if (isEnd) {
                break;
            }
        }

        if (isEnd){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
