public class LinkedLists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = init10NodesLikedList();
        deleteMiddleNode(head, 5);
    }

    //Delete 5
    static void deleteMiddleNode(Node head, int value){
        if (head == null || head.next == null) return;

        Node lagNode = head;
        Node leadNode = head.next;

        while (leadNode.data != value){
            lagNode = leadNode;
            leadNode = leadNode.next;
        }

        lagNode.next = leadNode.next;
        printLinkedList(head);

    }

    private static Node init10NodesLikedList() {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node tail = new Node(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = tail;

        return head;
    }

    private static void printLinkedList(Node head){
        while (head != null){
            System.out.print( " -> " + head.data);
            head = head.next;
        }
    }
}
