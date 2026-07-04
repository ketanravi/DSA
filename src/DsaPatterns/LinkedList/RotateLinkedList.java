package src.DsaPatterns.LinkedList;
/*
Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addElements(head,2);
        head.addElements(head,3);
        head.addElements(head,4);
        head.addElements(head,5);

        ListNode rotated = rotateRight(head,2);

        while(rotated!=null){
            System.out.println(rotated.data);
            rotated = rotated.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = head;
        int size= 0;

        while(temp!=null){
            size++;
            temp=temp.next;
        }

        k = k%size;
        if(k==0)
            return head;
        k=size-k;
        int pos = 0;
        temp=head;

        while(pos<k-1 && temp!=null){
            temp=temp.next;
            pos++;
        }

        ListNode newHead=temp.next;
        ListNode temp2 = newHead;
        temp.next=null;

        while(temp2.next!=null){
            temp2=temp2.next;
        }

        temp2.next = head;

        return newHead;
    }
}
