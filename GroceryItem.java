import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
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
    private static final int SQUARE_HEIGHT = 59; //59
	private static final int SQUARE_WIDTH = 87; //87

	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Berries", "PB"}, {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, {"Macaroni", "Apples", "Hamburger", "Peanuts", "Milk"},{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}};
    
    public GroceryItem(String s, Double p){
        price = p;
        name = s;
        for(int x = 0; x<names.length; x++){
            System.out.println(x);
            for(int y = 0; y<names[0].length; y++){
                System.out.println(y);
                String n = names[x][y];
                System.out.println(n);
                if(name.equals(n)){
                    xLoc = 2*x+1;
                    yLoc = y;
                image = openImageFromSpriteSheet(y*SQUARE_HEIGHT+70, x*SQUARE_WIDTH+40, SQUARE_WIDTH, SQUARE_HEIGHT);
                icon = new ImageIcon(image);
                button = new JButton(icon);
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
	// protected static BufferedImage openImageFromSpriteSheet(int x, int y, int w, int h) {
	// 	openImage();
	// 	Image temp = ((BufferedImage) Image).getSubimage(x,y,w,h).getScaledInstance(SQUARE_WIDTH, SQUARE_HEIGHT, BufferedImage.SCALE_SMOOTH);
    //     return (BufferedImage) temp;

	// }

    // public void draw(){
    //     for(int x = 0; x<names.length; x++){
    //         for(int y = 0; y<names[0].length; y++){
    //             if(name.equals(names[x][y])){
    //                 BufferedImage itemImage = (BufferedImage) openImageFromSpriteSheet(x*SQUARE_HEIGHT, y*SQUARE_WIDTH, SQUARE_WIDTH, SQUARE_HEIGHT);
    //                 try {
    //                     BufferedImage main = ImageIO.read(new File("Images/grocery.png"));
    //                     Graphics g = main.getGraphics();
    //                     g.drawImage(itemImage, x*SQUARE_HEIGHT, y*SQUARE_WIDTH, null);
    //                 } catch (IOException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //         }
    //     }
    // }

    protected  Image openImageFromSpriteSheet(int y, int x, int w, int h) {
		openImage();
        BufferedImage temp = ((BufferedImage) image).getSubimage(x,y,w,h);
        return temp.getScaledInstance(SQUARE_WIDTH, SQUARE_HEIGHT, BufferedImage.SCALE_SMOOTH);
		//return temp;
	}


    public void draw(Graphics g){
        int x = xLoc, y = yLoc;
        if (image != null){
            g.drawImage(image, x*SQUARE_HEIGHT, y*SQUARE_WIDTH, null);
            g.drawString(name + " $" + price, (2*y+1) * SQUARE_HEIGHT , (x)*SQUARE_WIDTH/2 + 30);
        }
        else{
            System.out.println("Image "+image+" is null for "+name);
        }
               
    }
}

