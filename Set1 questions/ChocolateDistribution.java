public class Solution {
    public int candy(ArrayList<Integer> A) {

        int count[] = new int[A.size()];

        for (int i = 0; i < A.size(); i++) {
            count[i] = 1;
        }
        // left to right
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                count[i] = count[i - 1] + 1;
            } else
                count[i] = 1;

        }
        // right to left
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                count[i] = Math.max(count[i + 1] + 1, count[i]);
            } else
                count[i] = Math.max(count[i], 1);
        }

        int total = 0;
        for (int i = 0; i < A.size(); i++) {
            total += count[i];
        }
        return total;
    }
}