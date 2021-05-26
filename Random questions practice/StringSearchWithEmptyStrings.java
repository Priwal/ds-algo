
//asked in walmart interview: search the index of a string in a sorted string array which also contains empty strings

class StringSearchWithEmptyStrings {

    // Compare two string equals are not
    static int compareStrings(String str1, String str2) {
        int i = 0;
        while (i < str1.length() - 1 && str1.charAt(i) == str2.charAt(i))
            i++;

        if (str1.charAt(i) > str2.charAt(i))
            return -1;

        if (str1.charAt(i) < str2.charAt(i))
            return 1;
        else
            return 0;
    }

    static int searchStr(String[] arr, String str, int l, int h) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;

        // If mid is empty,
        // find closet non-empty string
        if (arr[mid].isEmpty()) {

            // If mid is empty, search in both sides of mid
            // and find the closest non-empty string, and
            // set mid accordingly.
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < right && right > h)
                    return -1;
                if (right <= h && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                if (left >= right && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        // If str is found at mid
        if (compareStrings(str, arr[mid]) == 0)
            return mid;

        // If str is greater than mid
        if (compareStrings(str, arr[mid]) < 0)
            return searchStr(arr, str, mid + 1, h);

        // If str is smaller than mid
        return searchStr(arr, str, l, mid - 1);
    }

    // Driver Code
    public static void main(String[] args) {

        // Input arr of Strings.
        String[] arr = { "for", "", "", "", "geeks", "ide", "", "practice", "", "", "quiz", "", "" };

        // input Search String
        String str = "quiz";
        int n = arr.length;

        System.out.println(searchStr(arr, str, 0, n - 1));
    }
}