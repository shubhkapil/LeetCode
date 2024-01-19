
//   Definition for singly-linked list.
//   public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
 
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val) 
            head = head.next;
        
        if(head == null)
            return head;

        ListNode curr = head;
        while(curr!=null && curr.next!=null && curr.next.val == val)
            curr = curr.next;

        if(curr==null)
            head.next = null;
        else if(curr!=head)
            head.next = curr.next;
            
        removeElements(head.next,val);
        
        return head;
    }
}