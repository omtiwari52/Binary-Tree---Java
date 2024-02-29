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


    // Approach - 1 /// Complexity - O(n^2)
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight) + 1;
    }
    public static int calculateDiameter2(Node root){
        if (root==null){
            return 0;
        }
        int leftDiam = calculateDiameter2(root.left);
        int rightDiam = calculateDiameter2(root.right);
        int lftht = height(root.left);
        int rhtht = height(root.right);
        int selfDiam = lftht + rhtht + 1;
        return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
    }
     
    // Approach - 2 /// Complexity - O(n)
    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info calculateDiameter(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = calculateDiameter(root.left);
        Info rightInfo = calculateDiameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam , rightInfo.diam) , leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;

        return  new Info(diam , ht);
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

        System.out.println(calculateDiameter(root).diam);
    }
}
