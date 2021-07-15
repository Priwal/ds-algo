class GFG {
    int intersectPoint(Node headA, Node headB) {
        // code here
        if (headA == null || headB == null)
            return -1;

        java.util.Map<Node, Integer> hasha = new java.util.HashMap<Node, Integer>();

        while (headA != null) {
            hasha.put(headA, headA.data);
            headA = headA.next;
        }

        while (headB != null) {
            if (hasha.get(headB) != null)
                return (int) hasha.get(headB);
            headB = headB.next;
        }

        return 1;
    }
}