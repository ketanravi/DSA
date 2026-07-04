package src.DsaPatterns.LinkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addElements(head,2);
        head.addElements(head,3);
        head.addElements(head,4);
        head.addElements(head,5);

        ListNode reversedList = reverseBetween(head,2,4);

        while(reversedList!=null){
            System.out.println(reversedList.data);
            reversedList = reversedList.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right)
            return head;

        ListNode start = head;
        ListNode beforeReverse = null;

        int pos=1;


        while(start!=null && pos<left){
            beforeReverse = start;
            start=start.next;
            pos++;
        }

        ListNode prev = null;
        ListNode curr = start;
        int nodesToReverse = right-left+1;

        while(nodesToReverse>0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
            nodesToReverse--;

        }

        start.next=curr;
        if(beforeReverse!=null)
            beforeReverse.next = prev;
        else
            return prev;
        return head;

    }
}
