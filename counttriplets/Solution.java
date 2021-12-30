package de.saiteneffekt.counttriplets;

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

public class Solution {

    static long countTriplets(List<Long> arr, long r) {
        long count = 0L;
        Map<Long, Integer> largerMap = new HashMap<>();
        Map<Long, Integer> smallerMap = new HashMap<>();

        for (long a : arr) {
            largerMap.put(a, largerMap.getOrDefault(a, 0) + 1);
        }

        for (int i=0; i < arr.size() - 1; i++) {
            long currentValue = arr.get(i);
            if (currentValue % r != 0) {
                smallerMap.put(currentValue, smallerMap.getOrDefault(currentValue, 0) + 1);
                continue;
            }
            long smallValue = currentValue / r;
            long largeValue = currentValue * r;

            largerMap.put(currentValue, largerMap.get(currentValue) - 1);

            long amountOfSmallerValues = smallerMap.getOrDefault(smallValue, 0);
            long amountOfLargerValues = largerMap.getOrDefault(largeValue, 0);

            count += amountOfSmallerValues * amountOfLargerValues;
            smallerMap.put(currentValue, smallerMap.getOrDefault(currentValue, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
