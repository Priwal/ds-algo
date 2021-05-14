
class gfg {
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverse(Node head) {
        // add code here
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}