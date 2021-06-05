class Solution {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        // Your code here

        int curr_petrol = 0, prev_petrol = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            curr_petrol += petrol[i] - distance[i];
            if (curr_petrol < 0) {
                start = i + 1;
                prev_petrol += curr_petrol;
                curr_petrol = 0;
            }
        }
        return ((prev_petrol + curr_petrol) >= 0) ? start : -1;

    }
}