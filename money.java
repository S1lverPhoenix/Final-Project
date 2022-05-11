import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.ImageIcon;

public class Money extends JFrame implements ActionListener {
    JFrame frame;
    JButton[] money = new JButton[6];
    JButton oneButton, fiveButton, tenButton, twentyButton, fiftyButton, hundredButton;
    JPanel j;

    private Image bill;
    private int value;

    public Money() {
        frame=new JFrame("Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1260,550);
        frame.setLayout(null);
        //setting dollar bills to buttons
        Icon one = new ImageIcon("images/money/one.jpeg");
        oneButton= new JButton(one);
        Icon five = new ImageIcon("images/money/five.jpeg");
        fiveButton= new JButton(five);
        Icon ten = new ImageIcon("images/money/ten.jpeg");
        tenButton= new JButton(ten);
        Icon twenty = new ImageIcon("images/money/twenty.jpeg");
        twentyButton= new JButton(twenty);
        Icon fifty = new ImageIcon("images/money/fifty.jpeg");
        fiftyButton= new JButton(fifty);
        Icon hundred = new ImageIcon("images/money/one.jpeg");
        hundredButton= new JButton(hundred);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    } 
}