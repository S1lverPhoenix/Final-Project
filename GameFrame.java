import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class GameFrame extends JFrame {
	private int prints = 0;
	private Image img;
	private GroceryList items;
	private Game game;
	//= new GroceryList();
	JPanel p =new JPanel();
	private String[][] groceryNamesTable = 	new String[25][1];
	DefaultTableModel model ;//= new DefaultTableModel(groceryNamesTable, groceryHeader);
	JTable groceryTable ;
	//{
		// {"Pineapples", "0"}, {"Bread", "0"}, {"Yogurt", "0"}, {"Strawberries", "0"}, {"Peanut Butter", "0"},
		// {"Pudding", "0"}, {"Tuna", "0"}, {"Cookies", "0"}, {"Pretzels", "0"}, {"Potatoes", "0"},
		// {"Macaroni", "0"}, {"Apples", "0"}, {"Hamburger", "0"}, {"Peanuts", "0"}, {"Milk", "0"},
		// {"Cheese", "0"}, {"Chips", "0"}, {"Cereal", "0"}, {"Broccoli", "0"}, {"Eggplant", "0"},
		// {"Carrots", "0"}, {"Eggs", "0"}, {"Hot Dogs", "0"}, {"Banana", "0"}, {"Muffins", "0"}
		// };

		public void setUpCount(){
			int count = 0;
			for(int r = 0; r<items.getNames().length; r++){
				for(int c = 0; c<5; c++){
				String[] temp = {items.getNames()[r][c], items.getItems().get(count).itemCountString()};
				//System.out.println(temp.toString());
				groceryNamesTable[count] = temp; 
				count++;
				}
			}
		model = new DefaultTableModel(groceryNamesTable, groceryHeader);
		groceryTable.setModel(model);
		repaint();
	}

	
	String[] groceryHeader = { "Item", "Count" };

	// starting dimensions of window (pixels)
	
	//change dimensions to make it bigger to fit the count of the items of what the user clicked in the bottom:
	//name, price, count of how many times each item is clicked
	public static final int WIDTH = 600, HEIGHT = 700, REFRESH = 40;
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

	//drawing the game, grocery items and all
	private JPanel panel = new JPanel() {
		@Override 
		public void paintComponent(Graphics g) {
			
				super.paintComponent(g);
			g.drawImage(img, 0,0,null);
			//g.drawImage(sprite, 100,100, null);
			//grid.draw(g);
			setUpCount();
			repaint();
		}
	};
	// private JPanel panel;// = new JPanel() {
	// 	@Override
	// 	public void paintComponent(Graphics g) {
	// 		super.paintComponent(g);
	// 		g.drawImage(img, 0,0,null);
	// 		// game.drawTheGame(g);  // nothing will be drawn with this. is this required ?
	// 		items.makeGroceryList();
	// 		for(GroceryItem gi:items.getItems()){
	// 			//System.out.println("Grocery Item :" + gi);
	// 			gi.draw(g);
	// 		}
	// 		// tried to get rid of some stuttering, changing REFRESH 
	// 		// improved this issue
	// 		panel.getToolkit().sync();
	// 	}
	// };
	private Timer timer;//timer that runs the game

	private JPanel cartPanel = new JPanel();


	public GameFrame(String string) {
		super(string);
		items = new GroceryList(this);
		setUpStuff();
		
		}

    /**
	 * Sets up the panel, timer, other initial objects in the game.
	 * The Timer goes off every REFRESH milliseconds.  Every time the
	 * Timer goes off, the game is told to update itself and then the 
	 * view is refreshed.  
	 */
	private void setUpStuff() {
		panel.setLayout(null);
		System.out.println("Setting up");
		items.makeGroceryList();
		game = new Game(items);
		try {
            File f = new File("Images/shelf.jpeg");
            img = ImageIO.read(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		for(JButton button:items.getButtons()){
			panel.add(button);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setResizable(true);
	
		this.setResizable(false);

		// setting up the cartPanel
		 
		groceryTable = new JTable(model);
		setTable(groceryTable);
		setUpCount();

		// DefaultTableModel model = new DefaultTableModel(groceryNamesTable, groceryHeader);
		// JTable groceryTable = new JTable(model);
		groceryTable.setPreferredScrollableViewportSize(new Dimension(450,85)); //63
		groceryTable.setFillsViewportHeight(true);
		// to add scrollbar
		JScrollPane js=new JScrollPane(groceryTable);
		js.setVisible(true);
		cartPanel.add(js);
		cartPanel.add(new JScrollPane(groceryTable));
		cartPanel.setPreferredSize(new Dimension(WIDTH, 200));

		// add the panel to the frame
		this.add(panel, BorderLayout.CENTER);

		// add the cartpanel to the frame
		this.add(cartPanel, BorderLayout.SOUTH);
		this.pack();

		timer = new Timer(REFRESH, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUpCount();
				//game.updateGame();
				panel.repaint();
			}
		});
		timer.start();
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		panel.requestFocusInWindow();

		System.out.println("Panel set up complete");
	}

	private void setTable(JTable jt){
		
		jt.setPreferredScrollableViewportSize(new Dimension(450,85)); //63
		jt.setFillsViewportHeight(true);
		// to add scrollbar
		JScrollPane js=new JScrollPane(jt);
		js.setVisible(true);
		cartPanel.add(js);
		cartPanel.add(new JScrollPane(jt));
		cartPanel.setPreferredSize(new Dimension(WIDTH, 200));

	}
	public void deletePanels(){
		p.setVisible(false);
		panel.setVisible(false);
		cartPanel.setVisible(false);
		groceryTable.setVisible(false);
		this.setVisible(false);
	}

	public void unDelete() {
		p.setVisible(true);
		panel.setVisible(true);
		cartPanel.setVisible(true);
		groceryTable.setVisible(true);
		this.setVisible(true);
	}
}
