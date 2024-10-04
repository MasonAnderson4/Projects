package HW3;


import java.util.ArrayList;
import java.util.List;

/**
 * Generic class that implements a binary tree structure.
 *   @author Dave Reed (edited by: Mason Anderson)
 *   @version 10/03/24
 */
public class BinaryTree<T> {    
    protected TreeNode<T> root;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Adds a value to the binary tree (at a random  location).
     *   @param value the value to be added
     */
    public void add(T value) {
        this.root = this.add(this.root, value);
    }
    private TreeNode<T> add(TreeNode<T> current, T value) {
        if (current == null) {
            current = new TreeNode<T>(value, null, null);
        }
        else if (Math.random() < 0.5) {
            current.setLeft(this.add(current.getLeft(), value)); 
        }
        else {
            current.setRight(this.add(current.getRight(), value));
        }
        current.update();
        return current;
    }

    /**
     * Determines the size of the binary tree.
     *   @return the size (number of nodes in the tree)
     */
    public int size() {
    	if(this.root == null) {
    		return 0;
    	}
    	else {
    		return this.root.getSize();
    	}
    }
   

    /**
     * Determines the size of the binary tree.
     *   @return the size (number of nodes in the tree)
     */
    public int height() {
        if(this.root == null) {
        	return 0;
        }
        else {
        	return this.root.getHeight();
        }
    }
    /**
     * Determines whether the tree contains a particular value.
     *   @param value the value to be searched for
     *   @return true if value is in the tree, otherwise false
     */
    public boolean contains(T value) {
        return this.contains(this.root, value);
    }
    private  boolean contains(TreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }
        else {
            return value.equals(current.getData()) ||
                   this.contains(current.getLeft(), value) ||
                   this.contains(current.getRight(), value);
        }
    }

    /**
     * Removes one occurrence of the specified value.
     *   @param value the value to be removed
     *   @return true if the value was found and removed, else false
     */
    public boolean remove(T value) {
        if (!this.contains(value)) {
            return false;
        }
        else {
            this.root = this.remove(this.root, value);
            return true;
        }
    }
    private TreeNode<T> remove(TreeNode<T> current, T value) {
        if (value.equals(current.getData())) {
            if (current.getLeft() == null) {
                current = current.getRight();
            }
            else {
                TreeNode<T> righty = current.getLeft();
                while (righty.getRight() != null) {
                    righty = righty.getRight();
                }
                current.setData(righty.getData());
                current.setLeft(this.remove(current.getLeft(), current.getData()));
            }
        }
        else if (this.contains(current.getLeft(), value)) {
            current.setLeft(this.remove(current.getLeft(), value));
        }
        else {
            current.setRight(this.remove(current.getRight(), value));
        }
        return current;
    }
    
    /**
     * Converts the tree to a String from an ordered list.
     *   @return the String representation of the tree.
     */
    public String toString() {
       return asList().toString();
    }
   
    
    /**
     * converts the tree to a List using an inorder traversal
     * @return the List representation of the tree
     */
    public List<T> asList() { 
    	List<T> result = new ArrayList<T>(); 
    	if(this.root == null) { 
    		return result; 
    	} 
    	asList(this.root,result); 
    	return result;
	  
	  } 
    private List<T> asList(TreeNode<T> current, List<T> result){ 
    	if(current == null) { 
    		return result; 
    	}
	  
	  asList(current.getLeft(), result);
	  
	  result.add(current.getData());
	  
	  asList(current.getRight(), result);
	  
	  return result; 
	  }
	 


    ////////////////////////////////////////////////////////////////////////////
    /// FOR TESTING PURPOSES
    ////////////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(7);
        tree.add(2);
        tree.add(12);
        tree.add(1);
        tree.add(5);        
        tree.add(6);
        tree.add(99);
        tree.add(88);
        System.out.println(tree);
        
        System.out.println("size = " + tree.size());
        System.out.println("height = " + tree.height());
        System.out.println(tree.contains(2) + " " + tree.contains(7)
                                            + " " + tree.contains(8));

        tree.remove(99);
        tree.remove(7);
        System.out.println(tree);
        System.out.println("size = " + tree.size());
        System.out.println("height = " + tree.height());
        System.out.println(tree.contains(2) + " " + tree.contains(7)
                                            + " " + tree.contains(8));

    }
}
