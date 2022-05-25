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

    }

    static void testDeleteMiddleNode(){
        Node head = init9NodesLinkedList();
        Node newHead = deleteMiddleNode(head, 5);
        printLinkedList(newHead);
    }

    //Delete 5
    static Node deleteMiddleNode(Node head, int value){
        if (head == null || head.next == null) throw new RuntimeException("ههه؟");

        Node lagNode = head;
        Node leadNode = head.next;

        while (leadNode.data != value){
            lagNode = leadNode;
            leadNode = leadNode.next;
        }

        lagNode.next = leadNode.next;

        return head;
    }

    static void testSumListsReverseAndForward(){
        Node head1 = createListFromNumber("716");
        Node head2 = createListFromNumber("592");
        printLinkedList(head1);
        printLinkedList(head2);

        System.out.println(sumListsReverse(head1, head2));

        Node head3 = createListFromNumber("617");
        Node head4 = createListFromNumber("295");
        System.out.println(sumListsForward(head3, head4));
    }

    //:(7-> 1 -> 6) + (5 -> 9 -> 2).
    static long sumListsReverse(Node headList1, Node headList2){
        //convert list to number
        String number1String = convertListToNumber(headList1);
        String number2String = convertListToNumber(headList2);
        //reverse that number
        long number1 = reverseNumber(number1String);
        long number2 = reverseNumber(number2String);

        return number1 + number2;
    }

    // (6 -> 1 -> 7) + (2 -> 9 -> 5)
    static long sumListsForward(Node headList1, Node headList2){
        //convert list to number
        String number1String = convertListToNumber(headList1);
        String number2String = convertListToNumber(headList2);
        //reverse that number
        long number1 = Long.parseLong(number1String);
        long number2 = Long.parseLong(number2String);

        return number1 + number2;
    }

    static String convertListToNumber(Node head){
        StringBuilder numberBuilder = new StringBuilder();
        while (head != null){
            numberBuilder.append(head.data);
            head = head.next;
        }
        return numberBuilder.toString();
    }

    static Long reverseNumber(String number){
        char[] numberAsArray = number.toCharArray();
        StringBuilder reversedNumberBuilder = new StringBuilder();

        for (int i = numberAsArray.length - 1; i >= 0; i--) {
            reversedNumberBuilder.append(numberAsArray[i]);
        }
        return Long.parseLong(reversedNumberBuilder.toString());
    }

    private static Node init9NodesLinkedList() {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node tail = new Node(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = tail;

        return head;
    }

    private static Node createListFromNumber(String number){
        Node head = new Node(Integer.parseInt(String.valueOf(number.charAt(0))));
        Node iterator = head;
        char[] numberArray = number.toCharArray();
        for (int i = 1; i < numberArray.length; i++) {
            iterator.next = new Node(Integer.parseInt(String.valueOf(number.charAt(i))));
            iterator = iterator.next;
        }

        return head;
    }

    private static void printLinkedList(Node head){
        while (head != null){
            System.out.print( " -> " + head.data);
            head = head.next;
        }
        System.out.println();
    }
}
