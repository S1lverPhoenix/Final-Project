import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GroceryList {
    private static ArrayList<GroceryItem> groceryItems = new ArrayList<>();
	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, {"Macaroni", "Apples", "Null", "Peanuts", "Milk"},{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}};
    
	public ArrayList<GroceryItem> getItems(){
		return groceryItems;
	}

	public void makeGroceryList(){
		int count = 0;
		for(int x = 0; x<names.length; x++){
			for(int y = 0; y<names[0].length; y++){
				groceryItems.add(new GroceryItem(names[x][y]));
				if(groceryItems.get(count).getName().equals("Null")){
					groceryItems.remove(count);
				}
				count++;
			}
		}
	}
}
