import java.util.HashMap;

public class LinkedLists {
    static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
        }

    }

    static class HeadTailContainer {
        Node head;
        Node tail;

        public HeadTailContainer(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
//        Node head1 = createListFromNumberGetHead("41");
//        Node tail1 = getTail(head1);
//
//        Node head2 = createListFromNumberGetHead("561");
//        Node tail2 = getTail(head2);
//
//        Node last = createListFromNumberGetHead("845");

        Node head1 = createListFromNumberGetHead("264");
        Node tail1 = getTail(head1);

        Node head2 = createListFromNumberGetHead("1");
        Node tail2 = getTail(head2);

//        Node last = createListFromNumberGetHead("24");

//        tail1.next = last;
//        tail2.next = last;

        System.out.println(intersection(head1, head2));
    }

    static void testRemoveDuplciates() {
        Node head = createListFromNumberGetHead("213241");
        Node newHead = removeDuplicates(head);
        printSinglyLinkedList(newHead);
    }

    static void testDeleteMiddleNode() {
        Node head = init9NodesSinglyLinkedList();
        Node newHead = deleteMiddleNode(head, 5);
        printSinglyLinkedList(newHead);
    }

    static void testSumListsReverseAndForward() {
        Node head1 = createListFromNumberGetHead("716");
        Node head2 = createListFromNumberGetHead("592");
        printSinglyLinkedList(head1);
        printSinglyLinkedList(head2);

        System.out.println(sumListsReverse(head1, head2));

        Node head3 = createListFromNumberGetHead("617");
        Node head4 = createListFromNumberGetHead("295");
        System.out.println(sumListsForward(head3, head4));
    }

    static void testIsSinglyPalindrome() {
        Node head = createListFromNumberGetHead("121");
        Node head2 = createListFromNumberGetHead("123");
        System.out.println(isSinglyPalindrome(head));
        System.out.println(isSinglyPalindrome(head2));
    }

    static void testLoopDetection() {
        Node head = createCircularSinglyLinkedList();
        System.out.println("Loop Detected At Node: " + loopDetection(head));
    }

    static Node intersection(Node head1, Node head2){
        Node originalHead2 = head2;
        while (head1 != null){
            while (head2 != null){
                if (head1 == head2){
                    System.out.println(head1.data);
                    return head1;
                }
                head2 = head2.next;
            }
            head2 = originalHead2;
            head1 = head1.next;
        }
        return null;
    }


    //1->2->2->3->3->4->5
    static void partition(Node head, int pivot) {
        Node origin = head;
        while (head != null) {
            if (head.data < pivot) {
                System.out.print(" ->" + head.data);
            }
            head = head.next;
        }
        head = origin;
        while (head != null) {
            if (head.data > pivot) {
                System.out.print(" ->" + head.data);
            }
            head = head.next;
        }
    }

    static Node removeDuplicates(Node head) {
        Node removedDuplicatesHead = head;
        //Just for demonstrating
//    	System.out.println(head.hashCode());
//    	System.out.println(removedDuplicatesHead.hashCode());
        while (head != null) {
            Node iterator = head.next;
            Node nodeBeforeIterator = head;
            while (iterator != null) {
                if (head.data == iterator.data) {
//    				System.out.println(head.data);
                    nodeBeforeIterator.next = iterator.next;
                }
                nodeBeforeIterator = iterator;
                iterator = iterator.next;

            }
            //Just for demonstrating
//    		if (head.next == null) {
//    			System.out.println(head.hashCode());
//    	    	System.out.println(hNoremovedDuplicatesHeadde.hashCode());
//			}
    		/* Important concept
    		 * String s1 = "islam";
		    	String s2 = s1;
		    	
		    	System.out.println(s1);
		    	System.out.println(s2);
		    	
		    	s1 = "ahmed";
		    	
		    	System.out.println(s1);
		    	System.out.println(s2);
    		 */
            head = head.next;
        }
        return removedDuplicatesHead;
    }

    // Should we ask "are all values in the linked list distinct?"
    static int loopDetection(Node head) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head.hashCode())) return head.data;
            map.put(head.hashCode(), true);
            head = head.next;
        }
        return -1;
    }

    static boolean isSinglyPalindrome(Node head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.data);
            head = head.next;
        }

        String originalString = stringBuilder.toString();
        String reversedString = reverseString(originalString);

        return originalString.equals(reversedString);
    }

    // I left it :)
//    static boolean isDoublyPalindrome(Node head, Node tail, int i, int j){
//        while (head != null && tail != null && head.data == tail.data && i < j){
//            System.out.println(i + " " + j + " " + head.data + " " + tail.data);
//            isDoublyPalindrome(head.next, tail.previous, i++, j--);
//        }
//
//        return i == j;
//    }


    //Delete 5
    static Node deleteMiddleNode(Node head, int value) {
        if (head == null || head.next == null) throw new RuntimeException("ههه؟");

        Node lagNode = head;
        Node leadNode = head.next;

        while (leadNode.data != value) {
            lagNode = leadNode;
            leadNode = leadNode.next;
        }

        lagNode.next = leadNode.next;

        return head;
    }

    //:(7-> 1 -> 6) + (5 -> 9 -> 2).
    static long sumListsReverse(Node headList1, Node headList2) {
        //convert list to number
        String number1String = convertListToNumber(headList1);
        String number2String = convertListToNumber(headList2);
        //reverse that number
        long number1 = Long.parseLong(reverseString(number1String));
        long number2 = Long.parseLong(reverseString(number2String));

        return number1 + number2;
    }

    // (6 -> 1 -> 7) + (2 -> 9 -> 5)
    static long sumListsForward(Node headList1, Node headList2) {
        //convert list to number
        String number1String = convertListToNumber(headList1);
        String number2String = convertListToNumber(headList2);
        //reverse that number
        long number1 = Long.parseLong(number1String);
        long number2 = Long.parseLong(number2String);

        return number1 + number2;
    }

    static String convertListToNumber(Node head) {
        StringBuilder numberBuilder = new StringBuilder();
        while (head != null) {
            numberBuilder.append(head.data);
            head = head.next;
        }
        return numberBuilder.toString();
    }

    static String reverseString(String number) {
        char[] numberAsArray = number.toCharArray();
        StringBuilder reversedNumberBuilder = new StringBuilder();

        for (int i = numberAsArray.length - 1; i >= 0; i--) {
            reversedNumberBuilder.append(numberAsArray[i]);
        }
        return reversedNumberBuilder.toString();
    }


    private static Node init9NodesSinglyLinkedList() {
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

    private static HeadTailContainer init9NodesDoublyLinkedList() {
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
//        head.previous = tail;

        node2.next = node3;
        node2.previous = head;

        node3.next = node4;
        node3.previous = node2;

        node4.next = node5;
        node4.previous = node3;

        node5.next = node6;
        node5.previous = node4;

        node6.next = node7;
        node6.previous = node5;

        node7.next = node8;
        node7.previous = node6;

        node8.next = tail;
        node8.previous = node7;

        return new HeadTailContainer(head, tail);
    }

    private static Node createCircularSinglyLinkedList() {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node tail = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;
        tail.next = node3;


        return head;
    }

    private static Node createListFromNumberGetHead(String number) {
        Node head = new Node(Integer.parseInt(String.valueOf(number.charAt(0))));
        Node iterator = head;
        char[] numberArray = number.toCharArray();
        for (int i = 1; i < numberArray.length; i++) {
            iterator.next = new Node(Integer.parseInt(String.valueOf(number.charAt(i))));
            iterator = iterator.next;
        }
        return head;
    }

    static Node getTail(Node head){
        while (head.next != null){
            head = head.next;
        }
        return head;
    }

    private static HeadTailContainer createDoublyListFromNumber(String number) {
        Node head = new Node(Integer.parseInt(String.valueOf(number.charAt(0))));
        Node iterator = head;
        char[] numberArray = number.toCharArray();
        for (int i = 1; i < numberArray.length; i++) {
            iterator.next = new Node(Integer.parseInt(String.valueOf(number.charAt(i))));
            iterator = iterator.next;
            iterator.previous = head;
        }

        return new HeadTailContainer(head, iterator);
    }

    private static void printSinglyLinkedList(Node head) {
        int counter = 0;
        while (head != null) {
            if (counter == 0)
                System.out.print(head.data);
            else
                System.out.print(" -> " + head.data);
            counter++;
            head = head.next;
        }
        System.out.println();
    }

    private static void printDoublyLinkedList(Node head) {
        int counter = 0;
        while (head != null) {
            if (counter == 0)
                System.out.print(head.data);
            else
                System.out.print(" <-> " + head.data);
            counter++;
            head = head.next;
        }
        System.out.println();
    }
}
