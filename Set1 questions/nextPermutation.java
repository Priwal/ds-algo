
// https://www.geeksforgeeks.org/find-next-greater-number-set-digits/#
// asked in amazon interview 

class Solution {
    static List<Integer> nextPermutation(int N, int arr[]) {
        // code here
        int i;
        for (i = N - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }

        if (i == 0)
            Arrays.sort(arr);

        else {
            int temp = arr[i - 1];
            int min = i;

            for (int j = i + 1; j < N; j++) {
                if (arr[j] > temp && arr[j] < arr[min])
                    min = j;
            }

            // swapping
            int t = arr[i - 1];
            arr[i - 1] = arr[min];
            arr[min] = t;

        }

        Arrays.sort(arr, i, N);
        ArrayList<Integer> al = new ArrayList<>();
        for (int k = 0; k < N; k++) {
            al.add(arr[k]);
        }
        return al;
    }
}