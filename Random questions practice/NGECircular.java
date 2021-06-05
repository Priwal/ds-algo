public class NGECircular {

}

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int len = nums.length;
        int res[] = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * len; i++) {
            while (!st.isEmpty() && nums[i % len] > nums[st.peek()]) {
                res[st.peek()] = nums[i % len];
                st.pop();
            }

            if (i < len) {
                st.push(i);
            }
        }

        while (!st.isEmpty()) {
            res[st.peek()] = -1;
            st.pop();
        }

        return res;
    }
}