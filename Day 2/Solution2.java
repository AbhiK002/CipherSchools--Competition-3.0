class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        String output = "";
        Node ptr = this;

        while (ptr != null) {
            output += (ptr.data + " -> ");
            ptr = ptr.next;
        }
        output += " null";
        return output;
    }
}

public class Solution2{
    Node divide(int N, Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node evenReceiver = head;
        Node evenSender = head;

        while (evenReceiver.next != null && evenReceiver.data % 2 == 0 && evenReceiver.next.data % 2 == 0) evenReceiver = evenReceiver.next;
        evenSender = evenReceiver;

        while (evenSender != null && evenSender.next != null) {
            if (evenSender.next.data % 2 == 0) {
                Node temp = evenSender.next;
                evenSender.next = evenSender.next.next;

                if (evenReceiver.data % 2 != 0) {
                    temp.next = evenReceiver;
                    head = temp;
                    evenReceiver = head;
                }
                else {
                    temp.next = evenReceiver.next;
                    evenReceiver.next = temp;
                    evenReceiver = evenReceiver.next;
                }
                continue;
            }
            evenSender = evenSender.next;
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
        int N;
        Solution2 test = new Solution2();

        head = convertToLinkedList(new int[]{17, 15, 8, 9, 2, 4, 6});
        N = 7;
        System.out.println(test.divide(N, head));

        head = convertToLinkedList(new int[]{1, 3, 5, 7});
        N = 4;
        System.out.println(test.divide(N, head));
    }
}