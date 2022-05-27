package Date_15Dec2021;

import java.util.*;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringMales = scanner.nextLine().split("\\s+");
        String[] stringFemales = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(stringMales).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(stringFemales).map(Integer::parseInt).forEach(females::offer);

        int match = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int currMale = males.peek();
            int currFemale = females.peek();
            if (currMale <= 0) {
                males.pop();
                continue;
            }
            if (currFemale <= 0) {
                females.poll();
                continue;
            }
            if (currMale % 25 == 0){
                males.pop();
                males.pop();
                continue;
            }
            if (currFemale % 25 == 0){
                females.poll();
                females.poll();
                continue;
            }

            if (currMale == currFemale) {
                match++;
                males.pop();
                females.poll();
            } else {
                currMale -= 2;
                if (currMale <= 0) {
                    males.pop();
                } else {
                    males.pop();
                    males.push(currMale);
                }
                females.poll();
            }
        }
        List<String> malesStr = new ArrayList<>();
        List<String> femalesStr = new ArrayList<>();

        System.out.println("Matches: " + match);
        System.out.print("Males left: ");
        if (males.size() == 0) {
            System.out.print("none");
        } else {
            males.stream()
                    .forEach(e->malesStr.add(String.valueOf(e)));
            System.out.print(String.join(", ", malesStr));
        }
        System.out.println();

        System.out.print("Females left: ");
        if (females.size() == 0) {
            System.out.print("none");
        } else {
            females.stream()
                    .forEach(e-> femalesStr.add(String.valueOf(e)));
            System.out.print(String.join(", ", femalesStr));

        }
    }
}
