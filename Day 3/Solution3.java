class Solution3 {
    void reorderlist(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node ptr = head;

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

        head = convertToLinkedList(new int[]{1, 2, 3, 4, 5});
        test.reorderlist(head);
        System.out.println(head);

        head = convertToLinkedList(new int[]{17, 15, 8, 9, 2, 4, 6});
        test.reorderlist(head);
        System.out.println(head);
    }
}