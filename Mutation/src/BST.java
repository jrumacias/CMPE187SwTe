import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * The BST DOES NOT have duplicates
 *
 * found from: https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 *
 * Comments by Tyler Bruno
 *
 * display(), getRootNode(), BST(list), addArrayList(), and getRootNodeValue() was created by Tyler Bruno
 */
public class BST {

    public static Node root;

    public BST() {
        this.root = null;
    }

    public BST(ArrayList<Integer> list){
        /**
         * @param list that will be added to the created BST.
         */

        addArrayList(list);
    }

    public static void addArrayList(ArrayList<Integer> list)
    {
        /**
         * Add the arraylist to the tree
         *
         * @param list is the array list of integers (id) that will be added to the tree
         */

        for(int id:list)
        {
            insert(id);
        }
    }

    public int getSize(Node root){
        /**
         * method found from: https://algorithms.tutorialhorizon.com/find-the-size-of-the-binary-tree/
         */
        if(root==null){
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public Node getRootNode(){
        /**
         *
         * gets the root node
         *
         * @author Tyler Bruno
         * @return root node
         */
        return root;
    }

    public int getRootNodeValue(){
        /**
         * gets the root node valu
         *
         * @author Tyler Bruno
         * @return root node id
         */
        return root.id;
    }



    public static boolean find(int id) {
        /**
         * Find the node in the tree
         * @param id is the id of the node
         * @return true if node is found
         */

        //Starts at root node
        Node current = root;

        //Loop till node is found or no more nodes left to search
        while (current != null) {
            if (current.id == id) {//If current id is equal to numbmer we are searching for
                return true;
            } else if (current.id > id) {//current node is bigger than the id go left of the tree
                current = current.left;
            } else {//If current node is smaller than the id go right of the tree
                current = current.right;
            }
        }
        return false;//id not found
    }

    public boolean delete(int id) {
        /**
         * deletes the node with inputted id
         *
         * @param id of the node we are looking to delete.
         * @return returns true if the node was deleted
         *
         *
         */
        Node parent = root;
        Node current = root;

        boolean isLeftChild = false;

        while (current.id != id) {
            parent = current;

            if (current.id > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        /**
         * Gets the successor node
         *
         * @param deleleNode node we are looking for successor for
         *
         * @return the successsor
         */
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public int minValue(){
        /**
         * gets the minimum value in the tree (left most value in the tree
         *
         * @return the minimum value in the tree.
         */
        Node current = root;


        while (current.left != null) {
            current = current.left;
        }

        return (current.id);

    }

    public static boolean insert(int id) {
        /**
         * inserts unique nodes into the binary tree
         *
         * Modified by Tyler Bruno
         *
         * @param id is the value of the node
         * @return void
         */

        //Create new node
        Node newNode = new Node(id);

        //If there is no node in the root, make this new created node the root
        if (root == null) {
            root = newNode;
            return true;
        }

        //Find duplicates. If duplicated do not add to BST.
        if(find(id)== true)
        {
            return true;
        }

        Node current = root;


        Node parent = null;

        //Search for the proper location of the node
        while (true) {
            parent = current;
            if (id < current.id) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return true;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return true;
                }
            }
        }

    }

    public void display(Node root) {
        /**
         * Displays the tree
         *
         * @param root is the root node
         * @return void
         */
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.id);
            display(root.right);
        }
    }



    public int getValues(Node root) {
        /**
         * Displays the tree
         * THIS DOESNt WORK
         * @param root is the root node
         * @return void
         */

        if (root != null) {
            getValues(root.left);

            getValues(root.right);
            return(root.id);
        }
        else {
            return -999;
        }

    }

    public void display(){
        /**
         *
         * @author Tyler Bruno
         *
         * displays all the nodes in the tree
         *
         * @return void
         */
//        System.out.println("Root = " + root.id);
        if(root != null)
        {
            display(root.left);
            System.out.print(" " + root.id);
            display(root.right);
        }
        System.out.println("");
    }
}