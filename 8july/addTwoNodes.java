import java.util.*;

public class addTwoNodes {
    int val;
    addTwoNodes next;

    addTwoNodes(int val) {
        this.val = val;
        this.next = null;
    }

    public static addTwoNodes addTwoNumbers(addTwoNodes l1, addTwoNodes l2) {
        addTwoNodes dummy = new addTwoNodes(0);
        addTwoNodes current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new addTwoNodes(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    public static void printList(addTwoNodes head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addTwoNodes l1 = new addTwoNodes(2);
        l1.next = new addTwoNodes(4);
        l1.next.next = new addTwoNodes(3);

        addTwoNodes l2 = new addTwoNodes(5);
        l2.next = new addTwoNodes(6);
        l2.next.next = new addTwoNodes(4);

        addTwoNodes result = addTwoNumbers(l1, l2);

        printList(result);
    }
}
