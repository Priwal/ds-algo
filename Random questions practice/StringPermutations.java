//program to print all string permutations
//Backtracking

import java.util.*;
import java.lang.*;

public class StringPermutations {

    public static String swap(String str, int x, int y) {
        char[] arr = str.toCharArray();
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return String.valueOf(arr);
    }

    public static void permute(String str, int l, int r) {

        // Base condition for recursion
        if (l == r) {
            System.out.println(str);
        }

        else {

            for (int i = 0; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                // since we changed the original tsring due to swap operation , we need to
                // backtrack
                // as below
                str = swap(str, l, i);
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        // passing the string, left limit and right limit as parameters
        permute(str, 0, n - 1);
    }

}
