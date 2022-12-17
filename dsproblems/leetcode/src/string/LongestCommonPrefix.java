package string;

import java.util.Arrays;
import java.util.Collections;

class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = new String[] { "flower", "flow", "flight" };
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;

        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c)) {
                c++;
            } else {
                break;
            }
        }

        System.out.println(c == 0 ? "" : first.substring(0, c));
        // return c == 0 ? "" : first.substring(0, c);

    }
}