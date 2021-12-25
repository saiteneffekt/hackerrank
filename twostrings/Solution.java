package de.saiteneffekt.twostrings;

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
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings2(String s1, String s2) {
        Stream<Character> s1Chars = s1.chars().mapToObj(i -> (char)i);
        boolean commonSubstring =
                s1Chars
                        .parallel()
                        .anyMatch(c -> s2.indexOf(c) != -1);
        if (commonSubstring) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String twoStrings3(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == (s2.charAt(j))) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> s1set = s1.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        Set<Character> s2set = s2.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        boolean commonSubstring = s1set.parallelStream().anyMatch(s2set::contains);

        if (commonSubstring) {
            return "YES";
        } else {
            return "NO";
        }
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
                String s1 = bufferedReader.readLine();
                String s2 = bufferedReader.readLine();
                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
