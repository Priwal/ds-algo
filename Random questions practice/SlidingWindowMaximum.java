
/*Given an array of integers A. There is a sliding window of size B which
is moving from the very left of the array to the very right.
You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        if (A == null || A.isEmpty())
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        int len = A.size();
        Deque<Integer> window = new LinkedList<>();

        // Create first window of B elements

        for (int i = 0; i < B; i++) {
            while (!window.isEmpty() && A.get(i) >= A.get(window.peekLast())) {
                window.removeLast();
            }

            window.addLast(i);
        }

        result.add(A.get(window.peek()));

        for (int i = B; i < len; i++) { // Remove first so size of window remains B

            if (window.peekFirst() + B <= i)
                window.removeFirst();

            int curr = A.get(i);
            // Remove all elements from end which are smaller than current
            while (!window.isEmpty() && curr >= A.get(window.peekLast())) {
                window.removeLast();
            }

            window.add(i);
            result.add(A.get(window.peek()));
        }
        return result;
    }
}
