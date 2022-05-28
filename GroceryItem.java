import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GroceryItem {
    private  Image image;
    private String name;
    private double price;
    private boolean show;
    private int xLoc;
    private int yLoc;
    private Icon icon;
    private JButton button;
    // private JButton button;
    // private ArrayList<JButton> buttonList = new ArrayList<>();
    private static final int SQUARE_HEIGHT = 59; //59
	private static final int SQUARE_WIDTH = 87; //87
    private int itemCount;
	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Berries", "PB"}, 
                                        {"Pudding", "Fish", "Cookies", "Pretzels", "Potatoes"}, 
                                        {"Macaroni", "Apples", "Burgers", "Peanuts", "Milk"},
                                        { "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, 
                                        {"Carrots", "Eggs", "Hot Dogs", "Bananas", "Muffins"}};
    public GroceryItem(String s, Double p){
        name = s;
        price = p;
        button = new JButton();
        for(int x = 0; x<names.length; x++){
            //System.out.println(x);
            for(int y = 0; y<names[0].length; y++){
                //System.out.println(y);
                String n = names[x][y];
                //System.out.println(n);
                if(name.equals(n)){
                    yLoc = 2*x;
                    xLoc = y;
                image = openImageFromSpriteSheet(y*SQUARE_WIDTH+40, x*SQUARE_HEIGHT+70, SQUARE_WIDTH, SQUARE_HEIGHT);
                icon = new ImageIcon(image);
                button.setIcon(icon);
                button.setBounds(xLoc*SQUARE_WIDTH+20*xLoc+15, yLoc*SQUARE_HEIGHT-17*yLoc+15, SQUARE_WIDTH, SQUARE_HEIGHT);
                // button = new JButton(icon);
                // buttonList.add(button);
                }
            }
        }
    }

    public String toString(){
        return name;
    }
    public String getName(){
        return name;
    }

    public void addPrice(double d) {
        price = d;
    }
    public String[][] getNames(){
        return names;
    }

    public Image getImage(){
        return image;
    }
    
    private  void openImage() {
		if (image==null) {
			try {
				File f = new File("Images/grocery.png");
			   image = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
        }
    }
    public void incrementItemCount(){
        itemCount++;
    }
    public double calcTotalValue(){
        return itemCount*price;
    }

    protected  Image openImageFromSpriteSheet(int x, int y, int w, int h) {
		openImage();
        BufferedImage temp = ((BufferedImage) image).getSubimage(x,y,w,h);
        return temp.getScaledInstance(SQUARE_WIDTH, SQUARE_HEIGHT, BufferedImage.SCALE_SMOOTH);
		//return temp;
	}


    public void draw(Graphics g){
        int x = xLoc, y = yLoc;
        if (image != null){
            g.drawImage(image, x*SQUARE_HEIGHT, y*SQUARE_WIDTH, null);

            //if (!name.equals("Null")) {
                g.drawString(name + " $" + price, (2*y+1) * SQUARE_HEIGHT , (x)*SQUARE_WIDTH/2 + 30);
            //}
        }
        else{
            System.out.println("Image "+image+" is null for "+name);
        }
               
    }

    public Icon getIcon() {
        return icon;
    }

    public JButton getButton() {
        return button;
    }

    public double getPrice() {
        return price;
    }
    public String getPriceString() {
        String ans  = "";
        ans += price;
        return ans;
    }

    public String itemCountString(){
		String ans = new String();
		ans +=itemCount;
		return ans;
	}
}

