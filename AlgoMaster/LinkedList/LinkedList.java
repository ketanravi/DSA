package AlgoMaster.LinkedList;

class LinkedList {
    ListNode head;

    public ListNode addNode(int data) {

        ListNode newNode = new ListNode(data);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            return head;
        } else {
            // Traverse to the end of the list and add the new node
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            return current.next;
        }
    }

    // Method to return the head of the linked list
    public ListNode getHead() {
        return head;
    }

    // Method to print the linked list (for demonstration)
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
