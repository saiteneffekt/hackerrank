package de.saiteneffekt.anagram;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {

        int amountOfAnagrams = 0;
        HashMap<Integer, HashMap<Integer, List<Character>>> currentRunMap = new HashMap<>();

        // 1. collect
        // start position
        for (int i = 0; i < s.length(); i++) {
            HashMap<Integer, List<Character>> characterMap = new HashMap<>();

            // anagram length
            for (int j = 1; j <= s.length() - i; j++) {
                List<Character> characters = s.substring(i, i + j).chars().mapToObj(c -> (char)c).sorted().collect(Collectors.toList());
                characterMap.put(j, characters);
            }
            currentRunMap.put(i, characterMap);
        }

        int counter = 0;

        // 2. compare
        // start position
        for (int i = 0; i < s.length() - 1; i++) {
            HashMap<Integer, List<Character>> characterMap = currentRunMap.get(i);

            // anagram length
            for (int j = 1; j <= s.length() - i; j++) {
                List<Character> anagramCharacters = characterMap.get(j);

                // other character lists of same length
                for (int k = i + 1; k < s.length(); k++) {
                    List<Character> toCompareCharacters = currentRunMap.get(k).get(j);
//                    System.out.println("Comparing: " + pos(i) +len(j) + " with " + pos(k) + len(j));
                    counter++;
                    if (anagramCharacters.equals(toCompareCharacters)) {
                        String tmp = anagramCharacters.toString();
                        System.out.println("anagram: " + toCompareCharacters);
                        amountOfAnagrams++;
                    }
                }
            }
        }
        System.out.println(counter);
        return amountOfAnagrams;
    }

    private static String pos(int pos) {
        return "[pos: " + pos + "]";
    }

    private static String len(int len) {
        return "[len: " + len + "]";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
