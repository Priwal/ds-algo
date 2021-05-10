class LinkedList {
    // Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node newList = null;
        Node newListHead = newList;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (newList != null) {
                    newList.next = head1;
                    head1 = head1.next;
                    newList = newList.next;
                } else if (newList == null) {
                    newList = head1;
                    newListHead = newList;
                    head1 = head1.next;
                }
            } else if (head2.data <= head1.data) {
                if (newList != null) {
                    newList.next = head2;
                    head2 = head2.next;
                    newList = newList.next;

                } else if (newList == null) {
                    newList = head2;
                    newListHead = newList;

                    head2 = head2.next;
                }

            }

        }

        while (head1 != null) {
            newList.next = head1;
            head1 = head1.next;
            newList = newList.next;

        }

        while (head2 != null) {
            newList.next = head2;
            head2 = head2.next;
            newList = newList.next;

        }

        return newListHead;
    }
}