
import java.util.*;

public class GameOfLife {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            ArrayList<Integer> al = new ArrayList<>();

            // queue containing indices for elements which are 1
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1')
                    q.add(i);
            }
            q.add(-1);
            while (m > 0) {

                while (q.peek() != -1) {
                    int curr_index = q.poll();
                    if (curr_index - 1 >= 0 && arr[curr_index - 1] == '0') {
                        if (curr_index - 1 == 0) {
                            // arr[curr_index - 1] = '1';
                            al.add(curr_index - 1);

                            q.add(curr_index - 1);
                        } else {
                            if (arr[curr_index - 2] != '1') {
                                // arr[curr_index - 1] = '1';
                                al.add(curr_index - 1);
                                q.add(curr_index - 1);
                            }
                        }
                    }

                    if (curr_index + 1 < n && arr[curr_index + 1] == '0') {
                        if (curr_index + 1 == n - 1) {
                            // arr[curr_index + 1] = '1';
                            al.add(curr_index + 1);
                            q.add(curr_index + 1);
                        } else {
                            if (arr[curr_index + 2] != '1') {
                                // arr[curr_index + 1] = '1';
                                al.add(curr_index + 1);
                                q.add(curr_index + 1);
                            }
                        }

                    }

                }
                q.poll();
                q.add(-1);

                m--;
            }

            for (int i = 0; i < al.size(); i++) {
                arr[al.get(i)] = '1';
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }

            System.out.println();
        }

    }
}