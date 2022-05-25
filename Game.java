import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Image;

public class Game {
	private Money money = new Money();
	private Calculator calculator = new Calculator();
	private ArrayList<GroceryItem> items = new ArrayList<>();
	//private Image img = Toolkit.getDefaultTookkit().getImage("shelf.jpeg");
    public Game(){
        
    }
    
	public void GameOver(){
		double sum = 0;
		//if the value of the amount paid was greater than or equal to the correct value of the items +4 then we want to proceed
		for(GroceryItem g: items){
			sum+= g.calcTotalValue();
		}
		checkDollarBills(sum);
		
	}

	private void checkDollarBills(Double d) {
		if(money.getTotalDollars()<= d+4){}
			//open game over frame

	}

	/**
	 * This is called every time the Timer goes off.  Right now, it moves all 
	 * the Objects and checks for collisions.  This is common in games with flying
	 * Objects.  You can do more, though.  Like add items or move to new screens
	 * or check to see if the turn is over or...
	 */
	public void updateGame() {
    //System.out.println("Stuff Happening!");
		

	}
    /**
	 * Right now I am checking for collisions between GameObjects
	 */
	public void checkIfSelected() {
		
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
