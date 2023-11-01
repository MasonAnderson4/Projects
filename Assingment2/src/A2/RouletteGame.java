package A2;

import java.util.Scanner;

/*
 * @author Mason Anderson
 * @version 10/15/23
 */

public class RouletteGame extends java.lang.Object{
    
	int numCredits;
    public RouletteGame(){

    }
	
	public void addCredits(int numCredits) {
		if(numCredits <0) {
			System.out.println("Invalid number of credits.");
		}
		else {
			this.numCredits = numCredits;
		}
	}
	/*
	 * @param numCredits the number of Credits user wants to add
	 * @return adds credits to existing number of credits
	 */
	
	public int checkCredits(){
		return numCredits;
	}
	/*
	 * @return number of Credits
	 */
	
	public java.lang.String makeBet(int betAmount, java.lang.String betType){
		
		java.lang.String win = new java.lang.String();
		java.lang.String lose = new java.lang.String();
		java.lang.String error = new java.lang.String();
		
		
		if(numCredits >= betAmount && betAmount>=1) {
			numCredits -= betAmount;
			
			RouletteWheel spinNow = new RouletteWheel();
			java.lang.String resultNum = spinNow.spin();
			java.lang.String resultCol = spinNow.getColor(resultNum);
			java.lang.String resultPar = spinNow.getParity(resultNum);
			
			if(resultCol.contains(betType) || resultPar.contains(betType)) {
				System.out.println(numCredits);
				numCredits += 2*betAmount;
				System.out.println(numCredits);
				win = "The spin is " + resultNum + " (" + betType + ") - YOU WIN";
				return win;
			}
			else if((" " + resultNum + " ").contains(" " + betType + " ")) {
				numCredits += 36*betAmount;
				win = "The spin is " + resultNum + " - YOU WIN";
				return win;
			}
			else if(betType.contains("black") || betType.contains("red")) {
				lose = "The spin is " + resultNum + " (" + resultCol + ") - YOU LOSE";
				return lose;
			}
			else if(betType.contains("odd") || betType.contains("even")) {
				lose = "The spin is " + resultNum + " (" + resultPar + ") - YOU LOSE";
				return lose;
			}
			else {
				lose = "The spin is " + resultNum + " - YOU LOSE";
				return lose;
			}
			
		}
		else if(numCredits<betAmount) {
			error = "Error - not enough credits";
			return error;
		}
		else {
			error = "Error - bet size too small";
			return error;
		}

}

  public static void main(String[] args) { Scanner console = new
  Scanner(System.in); RouletteGame session = new RouletteGame();
  
  session.addCredits(100); int cont = 1;
  System.out.println("Welcome to roulette!");
  
  while(cont>0) { System.out.print("Enter bet amount: "); int betAmount =
  console.nextInt(); System.out.print("Enter bet type: "); java.lang.String
  betType = console.next();
  
  System.out.println(session.makeBet(betAmount, betType));
  System.out.println("Current credits: " + session.checkCredits());
  
  System.out.println("Continue (1) or exit (0): "); cont = console.nextInt(); }
  
  System.out.println("Closing roulette session..."); console.close();
  
  }
 
}
