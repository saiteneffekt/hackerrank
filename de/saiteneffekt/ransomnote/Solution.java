// import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
import java.util.*;
// import java.util.concurrent.*;
// import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(final String[] magazine, final String[] note) {
        // System.out.println(Arrays.toString(magazine));
        // System.out.println(Arrays.toString(note));

        HashMap<String, Integer> magMap = new HashMap<>();
        Arrays.asList(magazine).forEach(mag -> {
            if (magMap.containsKey(mag)) {
                magMap.put(mag, magMap.get(mag) + 1);
            } else {
                magMap.put(mag, 1);
            }
        });

        for (String word : note) {
            if(magMap.containsKey(word)) {
                if (magMap.get(word) > 1) {
                    magMap.put(word, magMap.get(word) -1 );
                } else {
                    magMap.remove(word);
                }
            } else {
                System.out.println("No");
                return;
            }
        };
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        // String[] mn = scanner.nextLine().split(" ");

        // int m = Integer.parseInt(mn[0]);
        // int n = Integer.parseInt(mn[1]);
        // String[] magazine = new String[m];

        // String[] magazineItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int i = 0; i < m; i++) {
        //     String magazineItem = magazineItems[i];
        //     magazine[i] = magazineItem;
        // }

        // String[] note = new String[n];

        // String[] noteItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int i = 0; i < n; i++) {
        //     String noteItem = noteItems[i];
        //     note[i] = noteItem;
        // }
        final String[] magazine = "give me one grand today night".split(" ");
        final String[] note = "give one grand today".split(" ");

        checkMagazine(magazine, note);

        scanner.close();
    }
}
