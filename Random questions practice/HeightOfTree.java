class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if (node == null)
            return 0;
        int l = 0;
        int r = 0;

        l = height(node.left) + 1;

        r = height(node.right) + 1;

        if (l >= r)
            return l;
        else
            return r;

    }
}