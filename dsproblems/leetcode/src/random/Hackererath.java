package random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hackererath {

    public static int findMinComplexity(List<Integer> complexity, int days) {
        // Write your code here
        int len = complexity.size();
        if (days > len) {
            return -1;
        }
        int[][] minComp = new int[days][len];

        for (int i = 0; i < days; i++) {
            Arrays.fill(minComp[i], Integer.MAX_VALUE);
        }

        int maxComp = 0;

        for (int i = 0; i <= len - days; i++) {
            maxComp = Math.max(maxComp, complexity.get(i));
            minComp[0][i] = maxComp;
        }

        for (int day = 1; day < days; day++) {
            for (int to = day; to <= len - days + day; to++) {
                int currComp = complexity.get(to);
                int result = Integer.MAX_VALUE;

                for (int j = to - 1; j >= day - 1; j--) {

                    result = Math.min(result, minComp[day - 1][j] + currComp);
                    currComp = Math.max(currComp, complexity.get(j));

                }

                minComp[day][to] = result;
            }

        }

        return minComp[days - 1][len - 1];

    }

    public static void main(String args[]) throws Exception {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(6);
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        System.out.println(findMinComplexity(arr, 2));

    }
}
