package HW6;

import java.util.HashMap;

/** This class represents the evensies game with different approaches to find expected tokens
 * @author Mason Anderson
 * @version 12/03/24
 */


public class Evensies {
	
	private static HashMap<String, Double> cache;
	private static double correctNoBottomsies = 16.0/36.0;
	private static double incorrectNoBottomsies = 16.0/36.0;
	private static double correctBottomsies = 2.0/36.0;
	private static double incorrectBottomsies = 2.0/36.0;
	
	public Evensies() {
		cache = new HashMap<String, Double>();
	}
	
	
	/**
     *  Determines the expected # of tokens for the player at the game's end,
     *  using a top-down, divide & conquer approach.
     *    @param tokens the number of tokens currently held by the player
     *    @param rounds the number of rounds left to be played
     *    @return expected tokens as a double
     */
     public static double expectedTopDown(int tokens, int rounds) {
    	 
    	 if(rounds == 0 || tokens <= 0) {
    		 return tokens;
    	 }
    	 

    	 return (correctNoBottomsies * expectedTopDown(tokens + 1, rounds - 1)) + 
    			 (incorrectNoBottomsies * expectedTopDown(tokens - 1, rounds - 1)) +
    			 (correctBottomsies * expectedTopDown(tokens, rounds - 1)) +
    			 (incorrectBottomsies * expectedTopDown(tokens - 2, rounds - 1));
    
     }
     
     /**
      *  Determines the expected # of tokens for the player at the game's end,
      *  using a bottom-up, dynamic programming approach.
      *    @param tokens the number of tokens currently held by the player
      *    @param rounds the number of rounds left to be played
      *    @return expected tokens as a double
      */
     public static double expectedBottomUp(int tokens, int rounds) {
    	 double winGrid[][] = new double[rounds + 1][rounds + tokens + 1];
    	 
    	 for(int t = 0; t <= tokens + rounds; t++) {
    		 winGrid[0][t] = t;
    	 }
    	 
    	 for(int r = 1; r <= rounds; r++) {
    		 for(int t = 0; t <= tokens + rounds; t++) {
    			 if(t == 0) {
    				 winGrid[r][t] = 0;
    			 }
    			 else {
    				 double expectedTokens = 0;
    				 
    			
    				 if(t + 1 <= tokens + rounds) {
    					 expectedTokens += (correctNoBottomsies * winGrid[r-1][t+1]);
    				 }
    				 
    				 if(t - 1 >= 0) {
    					 expectedTokens += (incorrectNoBottomsies * winGrid[r-1][t-1]);
    				 }
    				 
    				 if(t - 2 >= 0) {
    					 expectedTokens += (incorrectBottomsies * winGrid[r-1][t-2]);
    				 }
    				 else {
    					    expectedTokens += (incorrectBottomsies * -1);
    				}
    				 
    				 expectedTokens += (correctBottomsies * winGrid[r-1][t]);
    				 
    				 winGrid[r][t] = expectedTokens;
    			 }
    		 }
    	 }
    	  
    	 
    	 return winGrid[rounds][tokens];
     }
     
     /**
      *  Determines the expected # of tokens for the player at the game's end,
      *  using a top-down caching approach.
      *    @param tokens the number of tokens currently held by the player
      *    @param rounds the number of rounds left to be played
      *    @return expected tokens as a double
      */
     public static double expectedCaching(int tokens, int rounds) {
    	 
    	 if(rounds == 0 || tokens <= 0) {
    		 return tokens;
    	 }
    	 
    	 String key = tokens + "-" + rounds;
    	 
    	 if(cache.containsKey(key)) {
    		 return cache.get(key);
    	 }
    	 
    	 double result = (correctNoBottomsies * expectedCaching(tokens + 1, rounds - 1)) + 
		 (incorrectNoBottomsies * expectedCaching(tokens - 1, rounds - 1)) +
		 (correctBottomsies * expectedCaching(tokens, rounds - 1)) +
		 (incorrectBottomsies * expectedCaching(tokens - 2, rounds - 1));
    	 
    	 cache.put(key, result);
   
    	 return result;
     }
     
    

}
