package src.DsaPatterns.LinkedList;
/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        int groupSize=k;
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
}
