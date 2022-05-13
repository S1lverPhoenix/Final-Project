import javax.swing.*;

public class SwingGraphicsGame {

	    public static void main(String[] args) {
			//Calculator calc = new Calculator();
			GroceryList items = new GroceryList();
			items.makeGroceryList();
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GameFrame wnd = new GameFrame("Dollar Up!");
	                wnd.setVisible(true);
					items.getItems().get(1).draw();

	            }
	        });
	    }
	}