import java.util.*;
import java.lang.*;

public class kSmallestSumPairs {

    static class Pair {
        int sum;
        int x;
        int y;

        Pair(int sum, int x, int y) {
            this.sum = sum;
            this.x = x;
            this.y = y;

        }
    }

    static ArrayList<Pair> solve(int nums1[], int nums2[], int k) {
        ArrayList<Pair> al = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });

        boolean visited[][] = new boolean[nums1.length][nums2.length];

        pq.add(new Pair(nums1[0] + nums2[0], 0, 0));
        visited[0][0] = true;

        while (k > 0) {
            Pair currPair = pq.poll();
            int i = currPair.x;
            int j = currPair.y;
            al.add(currPair);
            k--;

            if (i + 1 < nums1.length && !visited[i + 1][j])
                ;

            {
                pq.add(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
                visited[i + 1][j] = true;
            }

            if (j + 1 < nums2.length && !visited[i][j + 1])
                ;

            {
                pq.add(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
                visited[i][j + 1] = true;
            }

        }

        return al;

    }

    public static void main(String[] args) {

        int nums1[] = { 1, 2, 11 };
        int nums2[] = { 2, 4, 6 };
        int k = 3;

        ArrayList<Pair> al = solve(nums1, nums2, k);

        for (int i = 0; i < al.size(); i++) {
            System.out.print(nums1[al.get(i).x] + " " + nums2[al.get(i).y]);

        }
    }
}