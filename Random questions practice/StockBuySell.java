
import java.util.*;

class Solution {
    class Interval {
        int buy;
        int sell;
    }

    // Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<Interval> res = new ArrayList<Interval>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

        if (n == 1)
            return al;

        int i = 0;

        while (i < n - 1) {
            // find local minima
            while ((i < n - 1) && (A[i + 1] <= A[i]))
                i++;

            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;

            // find local maxima
            while ((i < n) && A[i] >= A[i - 1])
                i++;

            e.sell = i - 1;

            res.add(e);

        }

        for (int k = 0; k < res.size(); k++) {
            al.add(new ArrayList<Integer>());
            al.get(k).add(0, res.get(k).buy);
            al.get(k).add(1, res.get(k).sell);
        }
        return al;
    }
}
