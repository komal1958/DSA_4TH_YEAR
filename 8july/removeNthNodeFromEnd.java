import java.util.*;
import java.io.*;

public class removeNthNodeFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dummy.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken();
        int sz = (int) st.nval;

        ListNode head = null, tail = null;

        for (int i = 0; i < sz; i++) {
            st.nextToken();
            int v = (int) st.nval;

            ListNode node = new ListNode(v);

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        st.nextToken();
        int n = (int) st.nval;

        Solution sol = new Solution();
        ListNode res = sol.removeNthFromEnd(head, n);

        boolean first = true;
        while (res != null) {
            if (!first) System.out.print(" ");
            System.out.print(res.val);
            first = false;
            res = res.next;
        }
    }
}
