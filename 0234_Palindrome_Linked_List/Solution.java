
//   Definition for singly-linked list.
//   public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
class Solution {
    
    // ListNode globalHead;
    // public boolean usingGlobalHead(ListNode tail)
    // {
    //     if(tail == null)
    //         return true;
        
    //     boolean ans = usingGlobalHead(tail.next);

    //     if(globalHead.val==tail.val)
    //     {
    //         globalHead=globalHead.next;
    //         return true & ans;
    //     }
    //     return false & ans;
    // }

    public boolean reversalSecondHalf(ListNode head)
    {
        //to Find mid point
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reversing Second Half:
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Compairing the palindrom
        while(prev!=null && head!=null)
        {
            if(prev.val!=head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;

        // globalHead = head;
        // return usingGlobalHead(head.next);
        
        return reversalSecondHalf(head);
        
    }
}