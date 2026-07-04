package src.DsaPatterns.LinkedList;



public class ListNode {
    public int data;
    public ListNode next;
    ListNode(int data) {
        this.data = data;
        this.next=null;
    }

    public ListNode addElements(ListNode head, int data){
        ListNode temp = head;
        while(temp.next!=null){
            temp= temp.next;
        }
        temp.next = new ListNode(data);
        return head;
    }
}
