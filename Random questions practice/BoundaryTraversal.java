
//on submiting this , getting TLE on gfg

class Solution {

    void printLeaves(Node node, ArrayList<Integer> res) {

        if (node == null)
            return;

        printLeaves(node.left, res);
        if (node.left == null && node.right == null)
            res.add(node.data);
        printLeaves(node.right, res);

    }

    void printLeftBoundary(Node node, ArrayList<Integer> res) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            res.add(node.data);
            printLeftBoundary(node.left, res);
        }

        else if (node.right != null) {
            res.add(node.data);
            printLeftBoundary(node.right, res);
        }

    }

    void printRightBoundary(Node node, ArrayList<Integer> res) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            return;
        }

        printRightBoundary(node.right, res);

        if (node.right != null) {
            res.add(node.data);
            printRightBoundary(node.right, res);
        }

        else if (node.left != null) {
            res.add(node.data);
            printRightBoundary(node.left, res);
        }

    }

    ArrayList<Integer> printBoundary(Node node) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (node == null)
            return null;

        res.add(node.data);
        printLeftBoundary(node.left, res);
        printLeaves(node.left, res);
        printLeaves(node.right, res);
        printRightBoundary(node.right, res);

        return res;
    }
}
