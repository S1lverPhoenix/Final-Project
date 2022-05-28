import java.io.File;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameOver implements ActionListener{
    JFrame congrats;
    private Image img;
    //private Calculator calculator = new Calculator();
    private Money money = new Money();
    JButton[] button =new JButton[1];
    JButton tryAgainButton = new JButton("Try Again!");
    Font myfont=new Font("Ink Free", Font.BOLD, 30);

    public GameOver(Graphics g){
        congrats= new JFrame("Game Over!");
        congrats.setResizable(true);
        congrats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        congrats.setSize(500, 500);
        congrats.setLayout(null);
       
            try {
            File f = new File("Images/gameover.png");
            img = ImageIO.read(f);
            } catch (Exception e) {
            e.printStackTrace();
            }
            g.drawImage(img, 100, 100, null);
        

            tryAgainButton = new JButton("Try Again!");
            button[0] = tryAgainButton;
            button[0].addActionListener(this);
            button[0].setFont(myfont);
            button[0].setFocusable(false);
    
}
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tryAgainButton){
        //how to make it go to the starting grocery aisle again?
    }
    }   
}

    


    
