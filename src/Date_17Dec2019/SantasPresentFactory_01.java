package Date_17Dec2019;

import java.util.*;

public class SantasPresentFactory_01 {
    static final int DOLL = 150;
    static final int WOODEN_TRAIN = 250;
    static final int TEDDY_BEAR = 300;
    static final int BICYCLE = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sec = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        ArrayDeque<Integer> magicValues = new ArrayDeque<>();

        for (int num : first) {
            materials.push(num);
        }
        for (int num : sec) {
            magicValues.offer(num);
        }

        int doll = 0;
        int train = 0;
        int teddy = 0;
        int bike = 0;

        while (!materials.isEmpty() && !magicValues.isEmpty()) {
            int theMat = materials.pop();
            if (theMat == 0){
                continue;
            }
            int thaVal = magicValues.poll();
            if (thaVal == 0){
                materials.push(theMat);
                continue;
            }
            int sum = theMat * thaVal;

            switch (sum) {
                case DOLL:
                    doll++;
                    break;
                case WOODEN_TRAIN:
                    train++;
                    break;
                case TEDDY_BEAR:
                    teddy++;
                    break;
                case BICYCLE:
                    bike++;
                    break;
                default:
                    if (sum < 0) {
                        materials.push(theMat + thaVal);
                    } else if (sum > 0) {
                        materials.push(theMat + 15);
                    }
            }
        }

        if ((doll > 0 && train > 0) || (teddy > 0 && bike > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            int num = materials.size();
            for (int i = 0; i < num; i++) {
                System.out.print(materials.pop());
                if (i < num - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (!magicValues.isEmpty()) {
            System.out.print("Magic left: ");
            int num = magicValues.size();
            for (int i = 0; i < num; i++) {
                System.out.print(magicValues.poll());
                if (i < num - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (bike > 0) {
            System.out.println("Bicycle: " + bike);
        }
        if (doll > 0) {
            System.out.println("Doll: " + doll);
        }
        if (teddy > 0) {
            System.out.println("Teddy bear: " + teddy);
        }
        if (train > 0) {
            System.out.println("Wooden train: " + bike);
        }

        System.out.println();
    }
}
