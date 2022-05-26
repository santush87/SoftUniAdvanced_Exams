package Date_19Feb2022;

import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowelString = scanner.nextLine().split("\\s+");
        String[] consonantString = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();
        for (String s : vowelString) {
            vowels.offer(s);
        }
        for (String s : consonantString) {
            consonants.push(s);
        }
        Set<String> pear = new HashSet<>();
        Set<String> flour = new HashSet<>();
        Set<String> pork = new HashSet<>();
        Set<String> olive = new HashSet<>();

        Map<String, Integer> words = new LinkedHashMap<>();
        words.put("pear", 0);
        words.put("flour", 0);
        words.put("pork", 0);
        words.put("olive", 0);

        int numberOfWords = 0;

        while (!consonants.isEmpty()) {
            String currentVowel = vowels.poll();
            vowels.offer(currentVowel);
            String currentConsonant = consonants.pop();

            switch (currentVowel) {
                case "a":
                    pear.add("a");
                    break;
                case "e":
                    pear.add("e");
                    olive.add("e");
                    break;
                case "o":
                    flour.add("o");
                    pork.add("o");
                    olive.add("o");
                    break;
                case "u":
                    flour.add("u");
                    break;
                case "i":
                    olive.add("i");
                    break;
            }

            switch (currentConsonant) {
                case "p":
                    pear.add("p");
                    pork.add("p");
                    break;
                case "r":
                    pear.add("r");
                    flour.add("r");
                    pork.add("r");
                    break;
                case "f":
                    flour.add("f");
                    break;
                case "l":
                    flour.add("l");
                    olive.add("l");
                    break;
                case "k":
                    pork.add("k");
                    break;
                case "v":
                    olive.add("v");
                    break;
            }

            if (pear.size() == 4) {
                words.put("pear", words.get("pear")+1);
                pear.clear();
                numberOfWords++;
            }
            if (flour.size() == 5) {
                words.put("flour", words.get("flour")+1);

                flour.clear();
                numberOfWords++;
            }
            if (pork.size() == 4) {
                words.put("pork", words.get("pork")+1);
                pork.clear();
                numberOfWords++;
            }
            if (olive.size() == 5) {
                words.put("olive", words.get("olive")+1);
                olive.clear();
                numberOfWords++;
            }
        }

        System.out.println("Words found: " + numberOfWords);
        words.entrySet()
                .stream()
                .filter(e->e.getValue()>0)
                .forEach(e-> System.out.println(e.getKey()));
    }
}
