import java.io.IOException;

import javax.swing.*;

public class SwingGraphicsGame {

	    public static void main(String[] args) {
			Calculator calc = new Calculator();
			//Money money= new Money();
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GameFrame wnd = new GameFrame("Framey");
	                wnd.setVisible(true);
	            }
	        });
	    }
	}