package array2d;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        List<Integer> hourglassSums = new ArrayList<>();

        for (int i=0; i<=3; i++) {
            for (int j=0; j<=3; j++) {
                int singleSum = calculateOneHourglassSum(i, j, arr);
                hourglassSums.add(singleSum);
            }
        }

        int highestSum = hourglassSums.stream().max(Integer::compareTo).orElse(0);
        return highestSum;
    }

    static int calculateOneHourglassSum(int startRow, int startColumn, int[][] arr) {
        int r = startRow;
        int c = startColumn;
        int sum = arr[r][c] +  arr[r][c+1] + arr[r][c+2];
        sum += arr[r+1][c+1];
        sum += arr[r+2][c] + arr[r+2][c+1] + arr[r+2][c+2];
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}