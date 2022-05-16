import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameFrame extends JFrame {
	// private BufferedImage sprite;
	private int prints = 0;
	private Game game = new Game();
	private Image img;
	private GroceryList items = new GroceryList();

	// starting dimensions of window (pixels)
	
	//change dimensions to make it bigger to fit the count of the items of what the user clicked in the bottom:
	//name, price, count of how many times each item is clicked
	public static final int WIDTH = 500, HEIGHT = 300, REFRESH = 40;
	// private void init(){
	// 	BufferedImage loader = new BufferedImage();
	// 	BufferedImage spriteSheet = null; 
	// 	try{
	// 		spriteSheet = loader.loadImg("food.jpg");
	// 	} 
	// 	catch(IOException e){
	// 		Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	// 	}
	// 	SpriteSheet ss = new SpriteSheet(spriteSheet);
	// 	sprite= ss.getSprite(0,0, 20, 40);
	
	// where the game objects are displayed
	private JPanel panel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,null);
			game.drawTheGame(g);
			items.makeGroceryList();
			for(GroceryItem gi:items.getItems()){
				gi.draw(g);
			}
			// tried to get rid of some stuttering, changing REFRESH 
			// improved this issue
			panel.getToolkit().sync();
		}
	};
	private Timer timer;//timer that runs the game


	public GameFrame(String string) {
		super(string);
		setUpStuff();
	}

    /**
	 * Sets up the panel, timer, other initial objects in the game.
	 * The Timer goes off every REFRESH milliseconds.  Every time the
	 * Timer goes off, the game is told to update itself and then the 
	 * view is refreshed.  
	 */
	private void setUpStuff() {
		System.out.println("Setting up");
		try {
            File f = new File("Images/shelf.jpeg");
            img = ImageIO.read(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.add(panel);
		this.pack();
		timer = new Timer(REFRESH, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.updateGame();
				panel.repaint();
			}
		});
		fillItems();
		timer.start();
		this.setVisible(true);
		panel.requestFocusInWindow();

		//addKeys(panel);
	
	
	// private void start() {
    //     try {
    //         File f = new File("images/backgrounds/shelf.jpeg");
    //         img = ImageIO.read(f);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
        
        panel = new JPanel() {
            @Override 
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0,0,null);
				//g.drawImage(sprite, 100,100, null);
				repaint();
                //grid.draw(g);
            }
        };
	// panel.addMouseListener(new MouseListener()){
	// 	public void mousePressed(MouseEvent me) {
	// 		clickedAt(me);
	// 	}
	// });

	// protected void clickedAt(MouseEvent me) {
	// 	System.out.println("You just clicked "+me);	
	// 	game.justClicked(me);
	// 	panel.repaint();
	// }

}

	private void fillItems() {

	}
}
