package TreesAndGraphs;

import java.util.Arrays;

public class Tree {
    public static void main(String[] args) {

    }

    static void testGetBSTFromArray(){
        int[] array1 = {2, 4, 6, 8, 9, 10, 20};
        int[] array2 = {2, 4, 6, 7, 8, 9, 10, 11, 20};

        inOrderTraversal(getMinimalBSTFromArray(array1));
        System.out.println();
        inOrderTraversal(getMinimalBSTFromArray(array2));
    }

    static TreeNode getMinimalBSTFromArray(int[] array) {
        TreeNode root;
        if (array.length == 1) {
            root = new TreeNode(array[0]);
            return root;
        }

        if (array.length == 2) {
            root = new TreeNode(array[1]);
            root.setLeft(new TreeNode(array[0]));
            return root;
        }

        root = new TreeNode(array[array.length / 2]);
        root.setLeft(getMinimalBSTFromArray(Arrays.copyOfRange(array, 0, array.length / 2)));
        root.setRight(getMinimalBSTFromArray(Arrays.copyOfRange(array, array.length / 2 + 1, array.length)));

        return root;
    }

    static void testTraversing() {
        TreeNode root = initBST();
        System.out.print("InOrder: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("PreOrder: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("PostOrder: ");
        postOrderTraversal(root);
        System.out.println();
    }

    static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    static TreeNode initBST() {
        TreeNode root = new TreeNode(8);
        TreeNode four = new TreeNode(4);
        TreeNode ten = new TreeNode(10);
        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);

        root.setLeft(four);
        root.setRight(ten);

        four.setLeft(two);
        four.setRight(six);

        ten.setLeft(nine);
        ten.setRight(twenty);

        return root;
    }
}
