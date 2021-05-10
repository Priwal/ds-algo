class Solution {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        int incl_sum = arr[0];
        int excl_sum = 0;
        for (int i = 1; i < n; i++) {
            int temp = incl_sum;
            incl_sum = Math.max(excl_sum + arr[i], incl_sum);
            excl_sum = temp;

        }
        return Math.max(incl_sum, excl_sum);
    }

}