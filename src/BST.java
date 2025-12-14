import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Dylan Kothari
 * @version: 12/13/25
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Call the recursive method to search for val
        return treeSearch(val, root);
    }
    public boolean treeSearch(int val, BSTNode root) {
        BSTNode currentNode = root;
        // Return true if val is equal to the value of the current node
        if (val == currentNode.getVal()) {
            return true;
        }
        //Return false if the value is not in the tree
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            return false;
        }
        if (val < currentNode.getVal()) {
            // If val is less, search the left side of the tree
            return treeSearch(val, root.getLeft());
        }
        // Otherwise search the right side
        else return treeSearch(val, root.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {

        // TODO: Complete inorder traversal
        // Call the recursive method to return the inorder transversal
        return traversalInOrder(root);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Call the recursive method to return the preorder traversal
        return traversalPreOrder(root);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Call the recurisve method to return the postorder traversal
        return traversalPostOrder(root);
    }
    public ArrayList<BSTNode> traversalInOrder(BSTNode root) {
        // Create an ArrayList to return the inorder list with the given root
        ArrayList<BSTNode> inOrdered = new ArrayList<BSTNode>();
        // Create an ArrayList to temporairly hold results free from the recursive calls
        ArrayList<BSTNode> temp = new ArrayList<BSTNode>();
        BSTNode currentNode = root;
        // If there is no node
        if(currentNode == null) {
            // Return the arrayList
            return temp;
        }
        // Call the traversal on the left subtree and store it in temp
        temp = traversalInOrder(currentNode.getLeft());
        // Add it to the ordered ArrayList
        addToArrayList(temp, inOrdered);
        // Add the root after the left subtree and before the right subtree
        inOrdered.add(currentNode);
        // Call traversal on the right subtree and store it in temp
        temp = traversalInOrder(currentNode.getRight());
        // Add it to the ordered ArrayList
        addToArrayList(temp, inOrdered);
        return inOrdered;
    }
    public ArrayList<BSTNode> traversalPreOrder(BSTNode root) {
        // Create an ArrayList to return the pre-order list with the given root
        ArrayList<BSTNode> preOrdered = new ArrayList<>();
        // Create an ArrayList to temporaily hod  results from the recurisive calls
        ArrayList<BSTNode> temp = new ArrayList<>();
        BSTNode currentNode = root;
        // If there is no node
        if(currentNode == null) {
            return temp;
        }
        // Add the root before both the left subtree the right subtree
        preOrdered.add(currentNode);
        // Call traversal on the left subtree and store in in temp
        temp = traversalPreOrder(currentNode.getLeft());
        // Add it to the ordered ArrayList
        addToArrayList(temp, preOrdered);
        // Call traversal on the right subtree and store it in temp
        temp = traversalPreOrder(currentNode.getRight());
        // Add it to the ordered ArrayList
        addToArrayList(temp, preOrdered);
        return preOrdered;
    }
    public ArrayList<BSTNode> traversalPostOrder(BSTNode root) {
        ArrayList<BSTNode> postOrdered = new ArrayList<>();
        ArrayList<BSTNode> temp = new ArrayList<>();
        BSTNode currentNode = root;
        // If there is no node
        if(currentNode == null)
        {
            return temp;
        }
        // Call traversal on the left subtree and store it in temp
        temp = traversalPostOrder(currentNode.getLeft());
        // Add it to the ordered ArrayList
        addToArrayList(temp, postOrdered);
        // Call traversal on the right side of the subtree and store it in temp
        temp = traversalPostOrder(currentNode.getRight());
        // Add it to the ordered ArrayList
        addToArrayList(temp, postOrdered);
        // Add the root after both the left subtree right subtree
        postOrdered.add(currentNode);
        return postOrdered;

    }
    // Helper method to add left or right side of the tree in order to the ordered arrayList
    public void addToArrayList(ArrayList <BSTNode> temp, ArrayList<BSTNode> ordered) {
        for(int i = 0; i < temp.size(); i++) {
            ordered.add(temp.get(i));
        }
    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val, BSTNode root) {
        // TODO: Complete insert
        BSTNode currentNode = root;
        // Call helper method that takes in value and the root
        treeInsertion(val, currentNode);
    }
    public void treeInsertion(int val, BSTNode currentNode) {
        // Create a new node with the value asked for
        BSTNode newNode = new BSTNode(val);
        // If a node with this value already exists
        if(search(val)) {
            // Exit and return nothing
            return;
        }
        // If there are no more nodes to compare
        if(currentNode.getRight() == null && currentNode.getLeft() == null) {
            // If the value is greater than the current root
            if(val > currentNode.getVal()) {
                // Put the new node with the value to the right
                currentNode.setRight(newNode);
            }
            // Set current tree to a tree with a inserted node to the left
            currentNode.setLeft(newNode);
        }
        if(val > currentNode.getVal()) {
            // Go through the right side of the tree
            insert(val,currentNode.getRight());
        }
        // Set current tree to a tree with a inserted node to the left
        insert(val, currentNode.getLeft());
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8, tree.root);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
