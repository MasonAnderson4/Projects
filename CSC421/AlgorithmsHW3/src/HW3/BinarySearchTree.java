package HW3;

import java.util.List;
import java.util.ArrayList;

/**
 * Generic class that implements a binary search tree, building upon the 
 * existing BinaryTree class.
 *   @param <T> the type of value stored, must be Comparable<T>
 *   @author Dave Reed (edited by: Mason Anderson)
 *   @version 10/03/24
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {
    /**
     * Overrides the super.add method to add according to the BST property.
     *   @param value the value to be added to the tree
     */
    public void add(T value) {
        this.root = this.add(this.root, value);
        if(isUnbalanced()) {
        	rebalance();
        }
    }
    private TreeNode<T> add(TreeNode<T> current, T value) {
        if (current == null) {
            return new TreeNode<T>(value, null, null);
        }

        if (value.compareTo(current.getData()) < 0) {
            current.setLeft(this.add(current.getLeft(), value));
        }
        else {
            current.setRight(this.add(current.getRight(), value));
        }
        return current;
    }
    
    /**
     * overrides the super.remove method to maintain tree balance
     * @return true if value is found and removed, false otherwise
     */
    public boolean remove(T value) {
    	if(!this.contains(value)) {
    		return false;
    	}
    	
    	this.root = this.remove(this.root, value);
    	if(isUnbalanced()) {
    		rebalance();
    	}
    	return true;
    }
    private TreeNode<T> remove(TreeNode<T> current, T value) {
    	if(current == null) {
    		return null;
    	}
    	
    	
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
     * Overrides the super.contains method to take advantage of binary search.
     *   @param value the value to be searched for
     *   @return true if that value is in the tree, otherwise false
     */
    public boolean contains(T value) {
        return this.contains(this.root, value);
    }
    private boolean contains(TreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }
        else if (value.equals(current.getData())) {
                return true;
        }
        else if (value.compareTo(current.getData()) < 0) {
            return this.contains(current.getLeft(), value);
        }
        else {
            return this.contains(current.getRight(), value);
        }
    }
    
    /**
     * rebalances the entire tree 
     */
    private void rebalance() {
    	
    	List<T> treeValues = this.asList(); 
    	
    	this.root = rebalance(treeValues, 0, treeValues.size()-1);
    	
    	
    }
    private TreeNode<T> rebalance(List<T> values, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	
    	int mid = (start + end) / 2;
    	
    	TreeNode<T> node = new TreeNode<T>(values.get(mid), null, null);
    	node.setLeft(rebalance(values, start, mid - 1));
    	node.setRight(rebalance(values, mid + 1, end));
    	
    	return node;
    }
    
    /**
     * checks to see if tree is unbalanced
     * @return true if unbalanced, false otherwise
     */
    private boolean isUnbalanced() {
    	if(this.height() > 1 + 2 *  (Math.log(this.size()) / Math.log(2))) {
    		return true;
    	}
    	return false;
    }

    ////////////////////////////////////////////////////////////////////////////
    /// FOR TESTING PURPOSES
    ////////////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(7);
        tree.add(2);
        tree.add(12);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(99);
        tree.add(88);
        System.out.println(tree.toString());
        
        System.out.println("size = " + tree.size());
        System.out.println(tree.contains(2) + " " + tree.contains(7)
                                            + " " + tree.contains(8));

        tree.remove(99);
        tree.remove(7);
        System.out.println(tree);
        System.out.println("size = " + tree.size());
        System.out.println(tree.contains(2) + " " + tree.contains(7)
                                            + " " + tree.contains(8));
    }
}
