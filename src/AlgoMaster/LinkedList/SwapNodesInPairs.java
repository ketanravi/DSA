package AlgoMaster.LinkedList;
/*
        Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)



        Example 1:

        Input: head = [1,2,3,4]

        Output: [2,1,4,3]

        Explanation:



        Example 2:

        Input: head = []

        Output: []

        Example 3:

        Input: head = [1]

        Output: [1]

        Example 4:

        Input: head = [1,2,3]

        Output: [2,1,3]



        Constraints:

        The number of nodes in the list is in the range [0, 100].
        0 <= Node.val <= 100
 */
public class SwapNodesInPairs {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        ListNode head = linkedList.getHead();
        ListNode newHead = swapNodesInPair(head);

        while(newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public static ListNode swapNodesInPair(ListNode head){
        // Initial dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse and swap pairs while there are at least two nodes remaining
        while (current.next != null && current.next.next != null) {
            // Nodes to be swapped
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

            // Adjusting pointers for swap
            firstNode.next = secondNode.next;
            current.next = secondNode;
            secondNode.next = firstNode;

            // Move the pointer by two nodes for next pair
            current = firstNode;
        }

        // Return new head at dummy's next
        return dummy.next;
    }
}
