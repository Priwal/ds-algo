public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int sum = A.get(0);
        int maxsum = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            sum = Math.max(A.get(i), sum + A.get(i));
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
