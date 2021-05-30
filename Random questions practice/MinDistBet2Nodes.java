
// Find minimum distance between 2 nodes of a given binary tree

class GfG {
    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return root;

        if (root.data == n1 || root.data == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null)
            return root;

        if (left == null && right == null)
            return null;

        if (left != null)
            return LCA(root.left, n1, n2);

        else
            return LCA(root.right, n1, n2);

    }

    int findLevel(Node lca, int n1, int level) {

        if (lca == null)
            return -1;

        if (lca.data == n1)
            return level;

        int dist = findLevel(lca.left, n1, level + 1);

        if (dist == -1)
            return findLevel(lca.right, n1, level + 1);
        else
            return dist;

    }

    int findDist(Node root, int a, int b) {
        // Your code here

        Node lca = LCA(root, a, b);

        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }
}