package AlgoMaster.LinkedList;
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?
 */
public class DeleteNthNodeFromEnd {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
//        linkedList.addNode(3);
//        linkedList.addNode(4);
//        linkedList.addNode(5);
        ListNode head = linkedList.getHead();
        head = deleteNthFromEnd(head,1);
        linkedList.printList(head);
    }
    // Two pass solution
    public static ListNode deleteNthFromEnd(ListNode head, int n){
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int nodeToBeDeleted = count - n + 1;

        temp=head;
        ListNode prev = null;
        count=1;
        while(temp!=null){
            if(count==nodeToBeDeleted)
            {
                ListNode next = temp.next;
                if(prev==null){
                    head = temp.next;
                }
                else
                    prev.next = next;
                temp = null;
                next = null;
                break;
            }
            count++;
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    /*
    Intuition :
        The task is to remove the nth node from the end of a singly linked list in one pass. We can achieve this by maintaining a gap of n nodes between two pointers so that, when the first pointer reaches the end, the second pointer is right before the node we want to remove. This approach uses a dummy node to handle edge cases cleanly, such as when the head of the list needs to be removed.
        
    Approach :
        Dummy Node: Introduce a dummy node pointing to the head of the list. This allows us to handle cases where the node to be removed is the head, as the dummy node provides a consistent "previous" node.

        Two Pointers: Use two pointers, first and second, both initially pointing to the dummy node.

        Advance first Pointer: Move the first pointer n + 1 steps ahead of second. This will create a gap of n nodes between first and second.

        Move Both Pointers: Move both pointers one step at a time until first reaches the end of the list. At this point, second is right before the node to remove.

        Remove the Target Node: Adjust the next pointer of second to skip the target node.

        Return the New Head: Return dummy.next as the new head of the list.
     */
    public static ListNode deleteNthFromEndOnePass(ListNode head, int n){
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;

        for(int i=1;i<=n+1;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;

    }

}
