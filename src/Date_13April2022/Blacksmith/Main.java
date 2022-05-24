package Date_13April2022.Blacksmith;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> swords = new LinkedHashMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        int gladius = 70;
        int shashmir = 80;
        int katana = 90;
        int sabre = 110;

        List<String> stringSteel = List.of(scanner.nextLine().split("\\s+"));
        List<String> stringCarbon = List.of(scanner.nextLine().split("\\s+"));

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        for (int i = 0; i < stringSteel.size(); i++) {
            steel.offer(Integer.parseInt(stringSteel.get(i)));
        }
        for (int i = 0; i < stringCarbon.size(); i++) {
            carbon.push(Integer.parseInt(stringCarbon.get(i)));
        }
        int swordCount = 0;

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int st = steel.pop();
            int cb = carbon.poll();
            int sum = st + cb;

            if (sum == gladius) {
                swords.put("Gladius", swords.get("Gladius") + 1);
                swordCount++;
            } else if (sum == shashmir) {
                swords.put("Shamshir", swords.get("Shamshir") + 1);
                swordCount++;
            } else if (sum == katana) {
                swords.put("Katana", swords.get("Katana") + 1);
                swordCount++;
            } else if (sum == sabre) {
                swords.put("Sabre", swords.get("Sabre") + 1);
                swordCount++;
            } else {
                cb += 5;
                carbon.push(cb);
            }
        }

        if (swordCount == 0) {
            System.out.println("You did not have enough resources to forge a sword.");

            if (steel.isEmpty()){
                System.out.println("Steel left: none");
            } else {
                System.out.print("Steel left: ");
                while (!steel.isEmpty()) {
                    System.out.print(steel.pop());
                    if (steel.size() >= 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

            if (carbon.isEmpty()){
                System.out.print("Carbon left: none");
            } else {
                System.out.print("Carbon left: ");
                while (!carbon.isEmpty()) {
                    System.out.print(carbon.poll());
                    if (carbon.size() >= 1) {
                        System.out.print(", ");
                    }
                }
            }
        } else {
            System.out.printf("You have forged %d swords.%n", swordCount);
            if (steel.isEmpty()){
                System.out.println("Steel left: none");
            } else {
                while (!steel.isEmpty()) {
                    System.out.print(steel.pop());
                    if (steel.size() >= 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

            System.out.print("Carbon left: ");
            while (!carbon.isEmpty()) {
                System.out.print(carbon.poll());
                if (carbon.size() >= 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            swords.entrySet()
                    .stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .filter(s -> s.getValue() > 0)
                    .forEach(s -> System.out.println(s.getKey() + ": " + s.getValue()));
        }
    }
}
