
// Given an integer array A of size N.

// You can pick B elements from either left or right end of the array A to get maximum sum.

// Find and return this maximum possible sum.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int[] prefix_sum = new int[A.size()];
        int[] suffix_sum = new int[A.size()];

        prefix_sum[0] = A.get(0);
        suffix_sum[A.size() - 1] = A.get(A.size() - 1);
        for (int i = 1; i < A.size(); i++) {
            prefix_sum[i] = prefix_sum[i - 1] + A.get(i);
        }

        for (int i = A.size() - 2; i >= 0; i--) {
            suffix_sum[i] = A.get(i) + suffix_sum[i + 1];
        }

        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i <= B; i++) {
            int currSum = 0;

            if (B - i > 0) {
                currSum += suffix_sum[len - (B - i)];
            }

            if (i > 0) {

                currSum += prefix_sum[i - 1];
            }
            max_sum = Math.max(max_sum, currSum);
        }
        return max_sum;
    }
}
