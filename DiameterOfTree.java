public class DiameterOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight) + 1;
    }
    public static int calculateDiameter(Node root){
        if (root==null){
            return 0;
        }
        int leftDiam = calculateDiameter(root.left);
        int rightDiam = calculateDiameter(root.right);
        int lftht = height(root.left);
        int rhtht = height(root.right);
        int selfDiam = lftht + rhtht + 1;
        return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
    }
    public static void main(String[] args) {
        /*   
                1
               / \
              2   3
             / \ / \
            4  5 6  7

        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(calculateDiameter(root));
    }
    
}
