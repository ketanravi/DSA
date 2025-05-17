package AlgoMaster.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        ListNode head = linkedList.getHead();
        ListNode newHead = reverse(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;

        }
        head = prev;
        return head;

    }
}
