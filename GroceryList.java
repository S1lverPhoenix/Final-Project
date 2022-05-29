import java.io.File;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class GroceryList {
	
    private static ArrayList<GroceryItem> groceryItems = new ArrayList<>();
	private ArrayList<JButton> buttonList= new ArrayList<>();
	private JButton button;
	private double totalPrice;
	private GameFrame gf;

	private static String[][] names = {
	{"Pineapples", "Bread", "Yogurt", "Berries", "PB"}, 
	{"Pudding", "Fish", "Cookies", "Pretzels", "Potatoes"}, 
	{"Macaroni", "Apples", "Burgers", "Peanuts", "Milk"},
	{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, 
	{"Carrots", "Eggs", "Hot Dogs", "Bananas", "Muffins"}
	};

	private static Double[][] prices = {
		{1.55, 0.59, 0.25, 1.34, 2.25},
		{1.25, 4.75, 3.51, 2.27, 3.99},
		{2.52, 1.99, 5.42, 4.99, 5.67},
		{1.32, 3.53, 2.83, 6.52, 4.36},
		{3.45, 4.54, 7.45, 2.15, 2.25}
	};
    //show the price of each item too
	public GroceryList(GameFrame gf){
		this.gf = gf;
	}
	public ArrayList<GroceryItem> getItems(){
		return groceryItems;
	}
	public String[][] getNames(){
		return names;
	}
	public Double[][] getPrices(){
		return prices;
	}
	public Double getSum(){
		double total = 0;
		for(GroceryItem gi: groceryItems){
			total+=gi.calcTotalValue();
		}
		return total;
	}
	public void makeGroceryList(){
		int count = 0;
		for(int x = 0; x<names.length; x++){
			for(int y = 0; y<names[0].length; y++){
				GroceryItem gi = new GroceryItem(names[x][y],prices[x][y]);
				groceryItems.add(gi);
				// if(groceryItems.get(count).equals(null)){
				// 	groceryItems.remove(count);
				// }
				//count++;
				//button= new JButton(groceryItems.get(groceryItems.size()-1).getIcon());

				buttonList.add(gi.getButton());
				gi.getButton().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						gi.incrementItemCount();
						totalPrice+=gi.getPrice();
						System.out.println(gi.toString());
						gf.setUpCount();
					}

				});
			}
		}
		//System.out.println("Grocery Items : " + groceryItems);
	}
	public ArrayList<JButton> getButtons(){
		return buttonList;
	}
	
	
}
