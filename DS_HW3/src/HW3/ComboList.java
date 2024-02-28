package HW3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Starter class for implementing a ComboList.
 *   @author Dave Reed (modified by Mason Anderson)
 *   @author 2/22/24
 */
public class ComboList<T> {
    private Node<ArrayList<T>> front;
    private Node<ArrayList<T>> back;
    private int nodeCapacity;
    private int listSize;
    
    /**
     * Constructs an empty list.
     *   @param capacity maximum number of values that can be stored in a node
     */
    public ComboList(int capacity) {
        this.nodeCapacity = capacity;
        this.front = new Node<ArrayList<T>>(new ArrayList<T>(), null);
        this.back = this.front;
        this.listSize = 0;
    }
    
    /**
     * Adds an element to the end of the list.
     *   @param item the item to be added
     */
    public void add(T item) {
        if (this.back.getData().size() == this.nodeCapacity) {
            this.back.setNext(new Node<ArrayList<T>>(new ArrayList<T>(), null));
            this.back = this.back.getNext();
        }
        this.back.getData().add(item);
        this.listSize++;
    }

    /**
     * Displays the contents of the ComboList, node by node, for debugging purposes.
     */
    public void sneakPeek() {
        Node<ArrayList<T>> stepper = this.front;
        int nodeNum = 0;
        while (stepper != null) {
            System.out.println(nodeNum++ + ": " + stepper.getData());
            stepper = stepper.getNext();
        }	
    }
    
    // This method gets the size of the combo list
    // @return combo list size
    public int size() {
    	return this.listSize;
    }
    
    
    // This method gets the value at a certain index
    // @param the index wanted
    // @return the value of the index
    public T get(int index) {
    	Node<ArrayList<T>> stepper = this.front;
    	
    	if(index < this.listSize && index >= 0) {		
    		 while (stepper != null && index >= stepper.getData().size()) { 
    	            index -= stepper.getData().size();
    	            stepper = stepper.getNext();
    	        }
    	        if (stepper == null) {
    	            throw new IndexOutOfBoundsException("Invalid index");
    	        }
    		
    	}
    	else {
    		throw new IndexOutOfBoundsException("Invalid index");
    	}
    	return stepper.getData().get(index);
    }
    
    
    // This method adds a value at a certain index, taking into account the node capacity and creating new nodes if needed
    // @param the index where you want to add and the value you want to add
    // @return adds into the combolist and returns true
    public boolean add(int index, T value) {
    	Node<ArrayList<T>> stepper = this.front;
    	if(index < this.listSize && index >= 0) {
    		this.listSize++;
    		while(index > stepper.getData().size()) {
    			index -= stepper.getData().size();
    			stepper = stepper.getNext();
    		}
    		
    		if(this.nodeCapacity != stepper.getData().size()) {
    			stepper.getData().add(index, value);
    		}
    		else if(stepper.getNext() != null && stepper.getData().size() >= this.nodeCapacity && stepper.getNext().getData().size() != this.nodeCapacity) {
    			T mover = stepper.getData().get(this.nodeCapacity-1);
    			stepper.getData().remove(this.nodeCapacity-1);
    			stepper.getData().add(index, value);
    			stepper.getNext().getData().add(0, mover);
    		}
    		else {
    			T mover = stepper.getData().get(this.nodeCapacity-1);
    			if(stepper.getNext() == null) {
    				this.back.setNext(new Node<ArrayList<T>>(new ArrayList<T>(), null));
    				this.back = this.back.getNext();
        			stepper.getData().remove(this.nodeCapacity-1);
        			stepper.getData().add(index, value);
    			}
    			
    			else{
    				stepper.setNext(new Node<ArrayList<T>>(new ArrayList<T>(), stepper.getNext()));	
    			}
    			stepper = stepper.getNext();
    			stepper.getData().add(mover);
    			
    		}
    	}
    	else {
    		throw new IndexOutOfBoundsException("Invalid index");
    	}
    	return true;
    }
    
    // This method turns the combolist into one list
    // @return the combolist as a list
    public List<T> toList(){
        Node<ArrayList<T>> stepper = this.front;
        List<T> list = new ArrayList<T>();
        while(stepper != null) {
        	list.addAll(stepper.getData());
        	stepper = stepper.getNext();
        }
    	return list;
    }
    
    // This method turns the combolist into a single string
    // @return the combolist as a string
    public String toString(){
    	List<T> list = toList();
    		
    	return list.toString();
    }
    
    // This method clears the combolist for the testing portion of the assignment
    public void clear() {
        this.front = new Node<ArrayList<T>>(new ArrayList<T>(), null);
        this.back = this.front;
        this.listSize = 0;
    }

    
   ///////////////////////////////////////////////////////////////////////////////////////// 
    // I know I didn't use this at all, but I am keeping it here for future reference
    public Iterator<T> iterator(){
    	return  new ComboIterator();
    }
    
    private class ComboIterator implements Iterator<T>{
    	Node<ArrayList<T>> currentNode;
    	int currentIndex;
    	
    	public ComboIterator() {
    		this.currentNode = ComboList.this.front;
    		this.currentIndex = 0;
    	}
    	
    	public boolean hasNext() {
    		return this.currentNode != null && this.currentIndex < this.currentNode.getData().size();
    	}
    	
    	public T next() {
    		T value = this.currentNode.getData().get(this.currentIndex);
    		this.currentIndex++;
    		if(this.currentIndex == this.currentNode.getData().size()) {
    			this.currentNode = this.currentNode.getNext();
    			this.currentIndex = 0;
    		}
    		return value;
    	}
    }
}

