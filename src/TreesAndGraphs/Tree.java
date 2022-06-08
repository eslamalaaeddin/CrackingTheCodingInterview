package TreesAndGraphs;

public class Tree {
    public static void main(String[] args) {
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
