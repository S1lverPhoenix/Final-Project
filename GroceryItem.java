import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class GroceryItem {
    private  Image image;
    private String name;
    private double price;
    private boolean show;
    private int xLoc;
    private int yLoc;
    private static final int SQUARE_HEIGHT = 85;
	private static final int SQUARE_WIDTH = 115;
	private static String[][] names = {{"Pineapples", "Bread", "Yogurt", "Strawberries", "Peanut Butter"}, {"Pudding", "Tuna", "Cookies", "Pretzels", "Potatoes"}, {"Macaroni", "Apples", "Null", "Peanuts", "Milk"},{ "Cheese", "Chips", "Cereal", "Broccoli", "Eggplant"}, {"Carrots", "Eggs", "Hot Dogs", "Banana", "Muffins"}};

    public GroceryItem(String s){
        name = s;
        for(int x = 0; x<names.length; x++){
            for(int y = 0; y<names[0].length; y++){
                if(name.equals(names[x][y])){
                    xLoc = x;
                    yLoc = y;
                 image =  openImageFromSpriteSheet(x*SQUARE_HEIGHT, y*SQUARE_WIDTH, SQUARE_WIDTH, SQUARE_HEIGHT);
                }
            }
        }
        //open an image here
    }

    public String getName(){
        return name;
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
                    if (image != null){
                        g.drawImage( image, x*SQUARE_HEIGHT, y*SQUARE_WIDTH, null);
                    }
                    else{
                        System.out.println("Image "+image+" is null for "+name);
                    }
               
    }
}

