package src.DsaPatterns.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addElements(head,2);
        head.addElements(head,3);
        head.addElements(head,4);
        head.addElements(head,5);

        ListNode reversedList = reverseList(head);

        while(reversedList!=null){
            System.out.println(reversedList.data);
            reversedList = reversedList.next;
        }
    }
    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }
}
