// print true if tree is foldable else print false
//below are 2 examples of foldable binary trees

/* 1                 1
  / \               /  \         
  2  3             2    3
  \ /             /      \
   4             4        5         */

class Tree {

    boolean isFoldableUtil(Node n1, Node n2) {

        if (n1 == null && n2 == null)
            return true;

        if (n1 == null || n2 == null)
            return false;

        return isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left);
    }

    // Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) {
        // your code

        if (node == null)
            return true;

        return isFoldableUtil(node.left, node.right);
    }
}