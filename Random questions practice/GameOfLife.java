
import java.util.*;

public class GameOfLife {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            char[] ch = s.toCharArray();
            int left = 0;
            for (int i = 0; i < m; i++) {

                left = 0;

                for (int j = 0; j < n; j++) {
                    if (ch[j] == '1') {
                        left = 1;
                        continue;
                    }

                    int right = j == n - 1 || ch[j + 1] == '0' ? 0 : 1;

                    if (left != right) {
                        ch[j] = '1';
                        left = 0;
                    }
                }
            }

            System.out.print(ch);

            System.out.println();
        }

    }

}
