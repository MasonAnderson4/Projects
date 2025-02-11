package HW7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

/**
 * Class that models a Finite State Machine.
 *   @author Mason Anderson (building on code by Dave Reed)
 */
public class FiniteStateMachine<StateLabel, EdgeLabel> {
    private HashMap<StateLabel, HashMap<EdgeLabel, StateLabel>> fsm;

    /**
     * Creates an empty finite state machine (with no states or edges).
     */
    public FiniteStateMachine() {
        fsm = new HashMap<StateLabel, HashMap<EdgeLabel, StateLabel>>();
    }

    /**
     * Adds an edge to the finite state machine.
     *   @param start the label of the starting state
     *   @param edge the label of the edge
     *   @param end the label of the ending state
     */
    public void addEdge(StateLabel start, EdgeLabel edge, StateLabel end) {
    	 	
    	if(fsm.containsKey(start)) {
    		HashMap<EdgeLabel, StateLabel> inner = fsm.get(start);
    		inner.put(edge, end);
    	}
    	else {
    		HashMap<EdgeLabel, StateLabel> newInner = new HashMap<EdgeLabel, StateLabel>();
    		newInner.put(edge, end);
    		fsm.put(start, newInner);
    	}
    	
    	
    }

    /**
     * Returns a String representation of the finite state machine.
     *   @return the String representation
     */
    public String toString() {
        return this.fsm.toString();
    }
    
    /**
     * Gets the adjacent state given the start state and edge labels. 
     *   @param startState the label of the start state
     *   @param edge the label of the edge
     *   @return the label of the ending state for that edge (or null if it doesn't exist)
     */
    public StateLabel getAdjacentState(StateLabel startState, EdgeLabel edge) {
    	HashMap<EdgeLabel, StateLabel> inner = fsm.get(startState);
    	if(inner != null) {
    		return inner.get(edge);
    	}
    	else {
    		return null;
    	}
    }
  
    /**
     * Returns a Set of all states labels that are adjacent to a given state.
     * @param startState the label of the start state
     * @return a Set of all state labels adjacent to startState
     */
    public Set<StateLabel> getAllAdjacentStates(StateLabel startState) {
    	
    	HashMap<EdgeLabel, StateLabel> inner = fsm.get(startState);
    	
    	if(inner != null) {
    		Set<StateLabel> adjacentStates = new HashSet<StateLabel>();
        	
        	for(StateLabel value : inner.values()) {
        		adjacentStates.add(value);
        	}
        	
        	return adjacentStates;
    	}
    	else {
    		return new HashSet<StateLabel>();
    	}
    	
    	
    }
        
    /**
     * Finds the ending state from a start state, given a sequence of edges.
     *   @param startState the label of the start state
     *   @param edgeSeq a list of edges to be followed from the start state
     *   @return the ending state after following the edge sequence
     */
    public StateLabel findEndState(StateLabel startState, List<EdgeLabel> edgeSeq) {

    	for(EdgeLabel edge : edgeSeq) {
    		startState = getAdjacentState(startState, edge);
    	}
    	
    	return startState;
    }


    ///////////////////////////////////////////////////////////////////////////

    public List<StateLabel> findPath(StateLabel startState, StateLabel endState) {
        List<StateLabel> startPath = new ArrayList<StateLabel>();
        startPath.add(startState);
        
        Queue<List<StateLabel>> paths = new LinkedList<List<StateLabel>>();
        paths.add(startPath);
        
        while (!paths.isEmpty()) {
            List<StateLabel> shortestPath = paths.remove();
            StateLabel current = shortestPath.get(shortestPath.size()-1);
            if (current.equals(endState)) {
                return shortestPath;
            }
            else {
                for (StateLabel s : this.getAllAdjacentStates(current)) {
                    if (!shortestPath.contains(s)) {
                        List<StateLabel> copy = new ArrayList<StateLabel>(shortestPath);
                        copy.add(s);
                        paths.add(copy);
                    }
                }
            }
        }
        return null;
    }
    
    //this method finds the edges in a FSM from a list of a state path
    // @param the list of state labels
    // @return the list of edge labels that were taken to get to the path 
    public List<EdgeLabel> findEdges(List<StateLabel> list){
    	
    	List<EdgeLabel> edges = new ArrayList<EdgeLabel>();
    	StateLabel nextValue = null;
    	
    	for(int i = 0; i < list.size()-1; i++) {
    		HashMap<EdgeLabel, StateLabel> inner = fsm.get(list.get(i));
    		
    		for(StateLabel value : inner.values()) {
    			if(value.equals(list.get(i+1))) {
    				nextValue = value;
    			}
    		}
    			
    		for(EdgeLabel edge : inner.keySet()) {
        		if(inner.get(edge).equals(nextValue)) {
       				edges.add(edge);
       			}
       		}
    		
    	}
    	return edges;
    }
 
}
