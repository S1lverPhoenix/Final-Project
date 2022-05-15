import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Money extends JFrame implements ActionListener{
    JFrame frame;
    JButton[] money = new JButton[6];
    JButton oneButton, fiveButton, tenButton, twentyButton, fiftyButton, hundredButton;
    private int total=0;

    public Money() {
        frame=new JFrame("Money");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1260,600);
        frame.setLayout(null);

        //setting dollar bills to buttons
        Icon one = new ImageIcon("Images/money/one.jpeg");
        oneButton= new JButton(one);
        Icon five = new ImageIcon("Images/money/five.jpeg");
        fiveButton= new JButton(five);
        Icon ten = new ImageIcon("Images/money/ten.jpeg");
        tenButton= new JButton(ten);
        Icon twenty = new ImageIcon("Images/money/twenty.jpeg");
        twentyButton= new JButton(twenty);
        Icon fifty = new ImageIcon("Images/money/fifty.jpeg");
        fiftyButton= new JButton(fifty);
        Icon hundred = new ImageIcon("Images/money/one.jpeg");
        hundredButton= new JButton(hundred);

        money[0]=oneButton;
        money[1]=fiveButton;
        money[2]=tenButton;
        money[3]=twentyButton;
        money[4]=fiftyButton;
        money[5]=hundredButton;

        for(int i=0; i<6; i++){
            money[i].addActionListener(this);
            money[i].setFocusable(false);
        }

        oneButton.setBounds(50,430,100,50);
        fiveButton.setBounds(150,430,100,50);
        tenButton.setBounds(250,430,100,50);
        twentyButton.setBounds(350,430,100,50);
        fiftyButton.setBounds(450,430,100,50);
        hundredButton.setBounds(550,430,100,50);

        frame.add(oneButton);
        frame.add(fiveButton);
        frame.add(tenButton);
        frame.add(twentyButton);
        frame.add(fiftyButton);
        frame.add(hundredButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==oneButton){
            System.out.println("One dollar has been paid!");
        }
        if(e.getSource()==fiveButton){
            System.out.println("Five dollars have been paid!");
        }
        if(e.getSource()==tenButton){
            System.out.println("Ten dollars have been paid!");
        }
        if(e.getSource()==twentyButton){
            System.out.println("Twenty dollars have been paid!");
        }
        if(e.getSource()==fiftyButton){
            System.out.println("Fifty dollars have been paid!");
        }
        if(e.getSource()==hundredButton){
            System.out.println("A hundred dollars have been paid!");
        }
    }

    
}