package AlgoMaster.LinkedList;

public class ReverseInGroupOfK {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        ListNode head = linkedList.getHead();
        ListNode newHead = reverseInGroupOfK(head,3);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static ListNode reverseInGroupOfK(ListNode head,int k) {
        if(head==null && head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode last = null;

        while(temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode==null){
                if(last!=null){
                    last.next=temp;
                }
                break;
            }

            ListNode next = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp==head){
                head = kthNode;
            }
            else{
                last.next = kthNode;
            }
            last = temp;
            temp = next;

        }
        return head;
    }
    private static ListNode getKthNode(ListNode temp,int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }

    public static void reverse(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;

        }
        temp = prev;

    }
}
