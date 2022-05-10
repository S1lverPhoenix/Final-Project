import javax.swing.*;

public class SwingGraphicsGame {

	    public static void main(String[] args) {
			Calculator calc = new Calculator();
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GameFrame wnd = new GameFrame("Dollar Up!");
	                
	                wnd.setVisible(true);
	                
	            }
	        });
	    }
	}