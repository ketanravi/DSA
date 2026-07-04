package src.DsaPatterns.LinkedList;
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
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addElements(head,2);
        head.addElements(head,3);
        head.addElements(head,4);
        head.addElements(head,5);

        ListNode swappedPairs = swapPairs(head);

        while(swappedPairs!=null){
            System.out.println(swappedPairs.data);
            swappedPairs = swappedPairs.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        int groupSize=2;
        ListNode res = null, prevLeft=null;

        ListNode left = head;
        ListNode right;

        while(true){
            right=left;
            for(int i=0;i<groupSize-1;i++){
                if(right==null)
                    break;
                right=right.next;
            }
            if(right!=null){
                ListNode nextLeft = right.next;
                reverse(left,groupSize);
                if(prevLeft!=null) {
                    prevLeft.next = right;
                }
                prevLeft=left;
                if(res==null){
                    res=right;
                }
                left = nextLeft;

            }
            else{
                if(prevLeft!=null){
                    prevLeft.next=left;
                }
                if(res==null){
                    res=left;
                }
                break;
            }
        }
        return res;
    }
    public static void reverse(ListNode node,int times){
        ListNode curr= node;
        ListNode prev=null;
        for(int i=0;i<times;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return;
    }
    public ListNode swapPairsSimple(ListNode head) {
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
