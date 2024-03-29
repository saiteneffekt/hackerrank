package sockmerchant;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int sellableSocks = 0;
        Map<Integer, Integer> socksMap = new HashMap<>();
        for (int i=0; i < n; i++) {
            int currentSock = ar[i];
            if(socksMap.containsKey(currentSock)) {
                socksMap.put(currentSock, socksMap.get(currentSock) + 1);
            } else {
                socksMap.put(currentSock, 1);
            }
        }

        for (int sockSize : socksMap.keySet()) {
            sellableSocks += socksMap.get(sockSize) / 2;
        }
        return sellableSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
