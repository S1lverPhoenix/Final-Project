import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Toolkit;
import java.awt.Image;

public class Game {
	
	private Calculator calculator = new Calculator();
	private ArrayList<GroceryItem> items = new ArrayList<>();
	private Image img;
	private Money money = new Money();
    public Game(){
        
    }
    
	// public void GameOver(){
	// 	double sum = 0;
	// 	//if the value of the amount paid was greater than or equal to the correct value of the items +4 then we want to proceed
		
	// }
	public boolean gameOver(){
		for(int i=0; i<checkDollarBills().size(); i++){
			if(checkDollarBills().get(i)!=money.getBills().get(i)){
				return false;
			}
		}
		return true;	
	}

	private ArrayList checkDollarBills() {
		ArrayList<Integer> correctBills = new ArrayList<Integer>();
		int count;
		double sum=0;
		//gets the correct sum of the items in the grocery list to be compared later
		for(GroceryItem g: items){
			sum+= g.calcTotalValue();
		}
		for(int i=money.getBills().size()-1; i>=0; i--){
			count=0;
		if(sum-100>=0){
			sum-=100;
			count++;
			correctBills.add(count);
			break;
		}
		if(sum-50>=0){
			sum-=50;
			count++;
			correctBills.add(count);
			break;
		}

		if(sum-20>=0){
			while(sum-20>=0 && count<=2){
				sum-=20;
				count++;
			}
			correctBills.add(count);
			break;
		}
		if(sum-10>=0){
			sum-=10;
			count++;
			correctBills.add(count);
			break;
		}
		if(sum-5>=0){
			sum-=5;
			count++;
			correctBills.add(count);
			break;
		}
		if(sum-1>=0){
			while(sum-1>=0 && count<=4){
				sum-=1;
				count++;
			}
			correctBills.add(count);
			break;
		}
	}
	return correctBills;
}



	/**
	 * Draws all the stuff in the game without changing them
	 * No reason to change this unless you wanted a background
	 * or something.
	 * @param g
	 */
    public void drawTheGame(Graphics g) {
		//snake.draw(g);
		// items is currently empty - nothing will be printed out
		for(GroceryItem go:items) {
			//System.out.println("Listing items in Game object: " + go);
			go.draw(g);
		}

	}
		
	
	/** called when the left arrow is pressed.  Probably move something
	 *  to the left, or turn left or... */
	public void ltHit(ActionEvent e) {
		System.out.println("Left!!");
	}
	/** called when the left arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public void leftReleased(ActionEvent e) {
        System.out.println("Released Left!!");
    }
	/** called when the right arrow is pressed.  Probably move something
	 *  to the right, or turn right or... */
	public void rtHit(ActionEvent e) {
        
		System.out.println("Right!");
	}
	/** called when the right arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public void rightReleased(ActionEvent e) {
		System.out.println("Released &&&&  Right!!");
    }
	/** called when the up arrow is pressed.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public  void upHit(ActionEvent e) {
		System.out.println("Up!!");
	}
	/** called when the up arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
	public void upReleased(ActionEvent e) {
		System.out.println("Released ^^^^  Up!!");
    }
}
