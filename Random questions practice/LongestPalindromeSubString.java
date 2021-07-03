class Solution {
    // complete this function

    String longestPalindrome(String S) {

        int maxLength = 1;
        int start = 0;
        int end = S.length();
        int low, high;

        for (int i = 0; i < S.length(); i++) {
            // for even length palindromes

            low = i - 1;
            high = i;

            while (low >= 0 && high < end && S.charAt(low) == S.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }

                low--;
                high++;
            }

            // for odd length palindromes

            low = i - 1;
            high = i + 1;

            while (low >= 0 && high < end && S.charAt(low) == S.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }

                low--;
                high++;
            }
        }
        return S.substring(start, start + maxLength);
    }
}
