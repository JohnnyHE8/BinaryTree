public class BinaryTree {
    public static void main(String args[])
    {
        Tree tree = new Tree();
        tree.Insert(1);
        tree.Insert(2);
        tree.Insert(3);
        tree.Insert(4);
        tree.Insert(5);
        tree.Insert(6);
        tree.Insert(7);
        tree.Insert(8);
        tree.Insert(9);
        tree.Insert(10);
        tree.Insert(11);

        tree.LesMax();
        tree.FindLesMax(10);
        tree.FindKey(2);
    }
}

class Node{
    int data;
    Node left;
    Node right;
    void Display(){
        System.out.println(data + " ");
    }
}

class Tree{
    private Node root;
    private static int Index = 0;

    public void Insert(int n){
        Node parent;
        Node newNode = new Node();
        newNode.data = n;

        if(root == null)
            root = newNode;
        else{
            Node current = root;
            while(true){
                parent = current;
                if(newNode.data < current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        break;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void LesMax(){
        Node parent = null;
        Node child = root;

        if(child == null)
            return;
        else{
            while(child.right != null){
                parent = child;
                child = child.right;
            }
        }

        if(child.left == null)
            System.out.println(parent.data);
        else{
            child = child.left;
            while(child.right != null)
                child = child.right;
            System.out.println(child.data);
        }
    }

    public void FindKthLargest(Node root, int k){
        if(root == null)
            return;

        FindKthLargest(root.right, k);
        if(++Index == k)
            System.out.println(root.data);
    }

    public void FindLesMax(int k){
        FindKthLargest(root, k);
    }

    public void FindKey(int data){
        Node current = root;

        while(current.data != data){
            if(current.data > data)
                current = current.left;
            else
                current = current.right;

            if(current == null)
                return;
        }

        System.out.println("Find: " + current.data);
    }
}