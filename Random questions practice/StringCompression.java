
//input- aaaabbbcccc, then output- a4b3c4

class GfG {
    String encode(String str) {
        // Your code here
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            ans += str.charAt(i);
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                count++;

            }
            ans += count;

        }
        return ans;
    }

}