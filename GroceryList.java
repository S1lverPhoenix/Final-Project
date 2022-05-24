import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GroceryList {
	
    private static ArrayList<GroceryItem> groceryItems = new ArrayList<>();
	private static String[][] names = {
	{"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, 
	{"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, 
	{"Macaroni", "Apples", "Hamburger", "Peanuts", "Milk"},
	{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, 
	{"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}
	};
<<<<<<< Updated upstream
=======

	private static Double[][] prices = {
		{1.55, 0.59, 0.25, 1.34, 2.25},
		{1.25, 4.75, 3.51, 2.27, 3.99},
		{2.52, 1.99, 5.42, 4.99, 5.67},
		{1.32, 3.53, 2.83, 6.52, 4.36},
		{3.45, 4.54, 7.45, 2.15, 2.25}
	};
>>>>>>> Stashed changes
    //show the price of each item too

	public ArrayList<GroceryItem> getItems(){
		return groceryItems;
	}

	public void makeGroceryList(){
		int count = 0;
		for(int x = 0; x<names.length; x++){
			for(int y = 0; y<names[0].length; y++){
				groceryItems.add(new GroceryItem(names[x][y]));
				if(groceryItems.get(count).equals(null)){
					groceryItems.remove(count);
				}
				count++;
			}
		}
		System.out.println("Grocery Items : " + groceryItems);
	}

	
}
