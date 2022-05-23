import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JTextField;

public class GroceryItem {
    private  Image image;
    private String name;
    private double price;
    private boolean show;
    private int xLoc;
    private int yLoc;
    private static final int SQUARE_HEIGHT = 59; //58
	private static final int SQUARE_WIDTH = 87; //87
	private static String[][] names = {
        {"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, 
        {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, 
        {"Macaroni", "Apples", "Null", "Peanuts", "Milk"},
        { "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, 
        {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}
        };
    private static JTextField textField;

    //JTextField pineapple = new JTextField("Pineapples");
    //pineapple.setBounds(0,10,5,3);
    //frame.add(pineapple);
    
    public GroceryItem(String s){
        name = s;
        for(int r = 0; r<names.length; r++){
            // System.out.println(r);
            for(int c = 0; c<names[0].length; c++){
                String n = names[r][c];
                // System.out.println(n);
                if(name.equals(n)){
                    xLoc = r + 2;
                    yLoc = c + 1;
                    image = openImageFromSpriteSheet(c*SQUARE_HEIGHT+70, r*SQUARE_WIDTH+40, SQUARE_WIDTH, SQUARE_HEIGHT);
                }
            }
        }
        //open an image here

        textField = new JTextField(name);

        //.add(pineapple);

        //set visibility to true
    }

    public String toString(){
        return name;
    }
    public String getName(){
        return name;
    }
    public JTextField getTextField(){
        return textField;
    }

    public void addPrice(double d) {
        price = d;
    }

    // public void draw(String path) throws IOException{
    //     URL url = this.getClass().getResource(path);
    //     java.awt.image.BufferedImage img = ImageIO.read(url);
    // }


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
        //System.out.println("Image is "+image+" for  "+name);
        if (image != null){
            g.drawImage(image, x*SQUARE_HEIGHT, y*SQUARE_WIDTH, null);
        }
        else{
            System.out.println("Image "+image+" is null for "+name);
        }
               
    }
}

