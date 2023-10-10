class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        boolean[] isPresent = new boolean[10000];
        for (int i : nums) {
            isPresent[i] = true;
        }

        int componentCount = 0;
        ListNode ptr = head;

        while (ptr != null) {
            if (isPresent[ptr.val]) {
                componentCount++;

                while (ptr.next != null && isPresent[ptr.next.val]) {
                    ptr = ptr.next;
                }
            }
            ptr = ptr.next;
        }

        return componentCount;
    }

    public static ListNode convertToLinkedList(int[] elements) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;

        for (int i : elements) {
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head;
        int[] nums;
        Solution test = new Solution();

        head = convertToLinkedList(new int[]{0, 1, 2, 3});
        nums = new int[]{0, 1, 3};
        System.out.println(test.numComponents(head, nums));

        head = convertToLinkedList(new int[]{0, 1, 2, 3, 4});
        nums = new int[]{0, 3, 1, 4};
        System.out.println(test.numComponents(head, nums));

        head = convertToLinkedList(new int[]{0, 1, 2, 3, 4, 5, 6});
        nums = new int[]{0, 3, 1, 4, 6};
        System.out.println(test.numComponents(head, nums));
    }
}