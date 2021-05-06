// to check if a given binary tree is BST or not
public class Solution {
    // Function to check whether a Binary Tree is BST or not.

    boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));

    }

    boolean isBST(Node root)
    {
        // code here.
       return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
       
    }