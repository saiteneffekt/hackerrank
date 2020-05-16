package repeatedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long amountOfAsInOneS = 0;
        long amountOfAsTotal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                amountOfAsInOneS++;
            }
        }
        long amountOfRepetitionsOfS = n / s.length();
        amountOfAsTotal = amountOfRepetitionsOfS * amountOfAsInOneS;

        long danglingChars = n % s.length();
        if (danglingChars != 0) {
            for (int i = 0; i<danglingChars; i++) {
                if (s.charAt(i) == 'a') {
                    amountOfAsTotal++;
                }
            }
        }

        return amountOfAsTotal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
