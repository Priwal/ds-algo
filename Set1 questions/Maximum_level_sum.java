// https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
class Solution {
    public int maxLevelSum(Node root) {
        // add code here.
        if (root == null)
            return 0;
        Queue<Node> treeNodeQueue = new LinkedList<>();
        int max_sum = root.data;
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            int width = treeNodeQueue.size();
            int sum = 0;
            while (width-- > 0)

            {
                Node curr_node = treeNodeQueue.poll();
                sum += curr_node.data;
                if (curr_node.left != null)
                    treeNodeQueue.add(curr_node.left);

                if (curr_node.right != null)
                    treeNodeQueue.add(curr_node.right);

            }
            max_sum = Math.max(sum, max_sum);
        }
        return max_sum;
    }
}
