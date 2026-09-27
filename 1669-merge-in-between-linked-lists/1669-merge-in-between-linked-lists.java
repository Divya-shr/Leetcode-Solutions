/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

    // Loop to get node at 'a-1' index and store it in curr1.
        ListNode curr1 = list1;
        for( int i=0; i<a-1; i++){
            curr1 = curr1.next;
        }

    // Loop to get node at 'b+1' index and store it in sec_curr1.   
        ListNode sec_curr1 = curr1.next;
        for( int i=a; i<b+1; i++){
           sec_curr1 = sec_curr1.next;
        }

    // Loop to get last node of list2 and store it in curr2.
        ListNode curr2 = list2;
        while(curr2.next != null){
            curr2 = curr2.next;
        }

    // Finally , updating nodes 
        curr1.next = list2;
        curr2.next = sec_curr1;
        return list1;

    }
}    