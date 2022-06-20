package Date_26Jun2021;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSide = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(",\\s+");
        ArrayDeque<String> commandsArr = new ArrayDeque<>(List.of(input));

        int pythonLength = 1;
        int pythonRow = -1;
        int pythonCol = -1;

        int food = 0;

        String[][] matrix = new String[screenSide][screenSide];
        for (int row = 0; row < screenSide; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < screenSide; col++) {
                if (matrix[row][col].equals("s")){
                    pythonRow = row;
                    pythonCol = col;
                }
                if (matrix[row][col].equals("f")){
                    food++;
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd){
            String command = commandsArr.pop();

            switch (command){
                case "up":
                    pythonRow--;
                    if (pythonRow < 0){
                        pythonRow = screenSide-1;
                    }
                    break;
                case "down":
                    pythonRow++;
                    if (pythonRow >= screenSide){
                        pythonRow = 0;
                    }
                    break;
                case "left":
                    pythonCol--;
                    if (pythonCol < 0){
                        pythonCol = screenSide-1;
                    }
                    break;
                case "right":
                    pythonCol++;
                    if (pythonCol >= screenSide){
                        pythonCol = 0;
                    }
                    break;
            }

            if (matrix[pythonRow][pythonCol].equals("f")){
                food--;
                pythonLength++;
                if (food == 0){
                    System.out.printf("You win! Final python length is %s", pythonLength);
                    break;
                }
            }
            if (matrix[pythonRow][pythonCol].equals("e")){
                System.out.println("You lose! Killed by an enemy!");
                break;
            }
            if (commandsArr.isEmpty()){
                isEnd = true;
                System.out.printf("You lose! There is still %d food to be eaten.", food);
            }
        }
    }
}
