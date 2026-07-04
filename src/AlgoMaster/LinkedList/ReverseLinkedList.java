package src.AlgoMaster.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        AlgoMaster.LinkedList.LinkedList linkedList = new AlgoMaster.LinkedList.LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        AlgoMaster.LinkedList.ListNode head = linkedList.getHead();
        AlgoMaster.LinkedList.ListNode newHead = reverse(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public static AlgoMaster.LinkedList.ListNode reverse(AlgoMaster.LinkedList.ListNode head){
        AlgoMaster.LinkedList.ListNode prev = null;
        AlgoMaster.LinkedList.ListNode curr = head;
        AlgoMaster.LinkedList.ListNode next = null;

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
