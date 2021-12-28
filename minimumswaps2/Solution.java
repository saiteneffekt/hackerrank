package de.saiteneffekt.minimumswaps2;

import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
import java.util.*;
// import java.util.concurrent.*;
// import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int numberOfSwaps = 0;

        int[] revArray = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            revArray[arr[i]-1] = i;
        }

        printArray(arr);
        for ( int i = 0; i < arr.length; i++ ) {
            if (arr[i] - 1 != i) {
                System.out.println(i);
                revArray[arr[i]-1] = revArray[i];
                arr[revArray[i]] = arr[i];
                arr[i] = i+1;
                revArray[i] = i;
                numberOfSwaps++;
            }
        }
        printArray(arr);
        return numberOfSwaps;
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // int n = 5;
        int[] arr = new int[]{2,3,4,1,5};

        // String[] arrItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        // for (int i = 0; i < n; i++) {
        //     int arrItem = Integer.parseInt(arrItems[i]);
        //     arr[i] = arrItem;
        // }

        int res = minimumSwaps(arr);
        System.out.println(res);
        // bufferedWriter.write(String.valueOf(res));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        // scanner.close();
    }
}
