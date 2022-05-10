import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameFrame extends JFrame {
	private int prints = 0;
	private Game game = new Game();
	private Image img;

	// starting dimensions of window (pixels)
	public static final int WIDTH = 500, HEIGHT = 300, REFRESH = 40;
	
	// where the game objects are displayed
	private JPanel panel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0,0,null);
			game.drawTheGame(g);
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
            File f = new File("Images.png/shelf.jpeg");
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
		timer.start();
		this.setVisible(true);
		panel.requestFocusInWindow();

		//addKeys(panel);
	}

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
                //grid.draw(g);
            }
        };


}
}
