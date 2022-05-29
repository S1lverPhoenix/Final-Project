import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Game {
	private Money money = new Money(this);
	//private Calculator calculator = new Calculator();
	private GroceryList items;
	private Image img;
    public Game(GroceryList algi){
        items = algi;
    }
    
	// public void GameOver(){
	// 	double sum = 0;
	// 	//if the value of the amount paid was greater than or equal to the correct value of the items +4 then we want to proceed
		
	// }
	public boolean gameOver(){
		ArrayList<Integer> bills = checkDollarBills();
		ArrayList<Integer> moneyBills = money.getBills();
		for(int i=0; i<bills.size(); i++){
			if(moneyBills.get(i)!=bills.get(i)){
				System.out.println("Wrong!! Try Again");
				System.out.println(moneyBills.toString());
				System.out.println(bills.toString());
				return false;
			}
		}
		System.out.println("This works!");

		return true;	
	}

	public void restartWin(){

		money.deletePanel();
		items.getGF().deletePanels();
		JFrame frame = new JFrame("Congratulations!!!!!!!!!!!!!");
		JButton endGame = new JButton();
		endGame.setText(" You Win!! Click here to quit :)");
		endGame.setBounds(20, 20, 20, 20);
		endGame.setBackground(Color.DARK_GRAY);
		frame.add(endGame);
		frame.setSize(300, 300);
		frame.setVisible(true);
		endGame.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				System.exit(0);
			}  
		});  			
	}

	public void restartLose(){
		JFrame framey = new JFrame("Try Again :(");
		JButton playAgain = new JButton("That's not quite right, click here to try again!");
		playAgain.setBounds(20, 20, 20, 20);
		framey.add(playAgain);
		framey.setSize(300, 300);
		money.deletePanel();
		items.getGF().deletePanels();
		framey.setVisible(true);
		playAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				money.unDelete();
				items.getGF().unDelete();
				framey.setVisible(false);				
			}
			
		});
	}

	private ArrayList checkDollarBills() {
		ArrayList<Integer> correctBills = new ArrayList<Integer>();
		int count = 0;
		double sum=0;
		//gets the correct sum of the items in the grocery list to be compared later
		sum = items.getSum();
		//for(int i=0; i<=money.getBills().size(); i++){
		//int tracker = 0;
		if(sum-100>-1){
			sum-=100;
			count++;
		}
		correctBills.add(0, count);
		count = 0;
		if(sum-50>-1){
			sum-=50;
			count++;
		}
		correctBills.add(0, count);
		count = 0;

		if(sum-20>-1){
			while(sum-20>-1 && count<=2){
				sum-=20;
				count++;
			}
		}
		correctBills.add(0, count);
		count = 0;
		if(sum-10>-1){
			sum-=10;
			count++;
		}
		correctBills.add(0, count);
		count = 0;
		if(sum-5>-1){
			sum-=5;
			count++;
		}
		correctBills.add(0, count);
		count = 0;
		if(sum-1>-1){
			while(sum-1>-1 && count<=4){
				sum-=1;
				count++;
			}
		}
		correctBills.add(0, count);
		count = 0;
		
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
		for(GroceryItem go:items.getItems()) {
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
