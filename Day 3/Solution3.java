class Solution3 {
    void reorderlist(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node turtle = head;
        Node rabbit = head;

        // find middle node of linked list using slow and fast pointers
        while (rabbit != null && rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }

        // point rabbit to the last node
        while (rabbit.next != null) rabbit = rabbit.next;

        // reverse the nodes after turtle
        turtle.next = reverse(turtle.next, rabbit);

        // shift the first node of second half between the nodes of first half repeatedly
        Node nodeInserter = head;

        while (nodeInserter != turtle) {
            Node target = turtle.next;
            turtle.next = turtle.next.next;

            target.next = nodeInserter.next;
            nodeInserter.next = target;

            nodeInserter = nodeInserter.next.next;
        }
    }

    public Node reverse(Node head, Node tail)
    {
        if (head == null || head.next == null) return head;

        Node ptr = head;
        Node last = tail;

        while (head != last)
        {
            head = head.next;
            ptr.next = last.next;
            last.next = ptr;
            ptr = head;
        }

        return head;
    }

    public static Node convertToLinkedList(int[] elements) {
        Node head = new Node(0);
        Node ptr = head;

        for (int i : elements) {
            ptr.next = new Node(i);
            ptr = ptr.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node head;
        Solution3 test = new Solution3();

        head = convertToLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        test.reorderlist(head);
        System.out.println(head);

        head = convertToLinkedList(new int[]{1, 2, 3, 4, 5});
        test.reorderlist(head);
        System.out.println(head);

        head = convertToLinkedList(new int[]{17, 15, 8, 9, 2, 4, 6});
        test.reorderlist(head);
        System.out.println(head);
    }
}