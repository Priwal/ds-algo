
// connect nodes at same level 

/*class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
} */
class Solution {
    public void connect(Node root) {
        // code here

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(new Node(-1));

        while (q.size() > 1) {

            while (q.peek() != null && q.peek().data != -1) {
                Node curr = q.poll();
                // System.out.println("curr element"+ curr.data);

                if (curr.left != null) {
                    q.add(curr.left);

                }
                if (curr.right != null) {
                    q.add(curr.right);

                }

                if (q.peek() != null && q.peek().data == -1)
                    curr.nextRight = null;
                else if (q.peek() != null && q.peek().data != -1) {
                    curr.nextRight = q.peek();
                }
            }

            q.poll();
            q.add(new Node(-1));
        }

    }
}