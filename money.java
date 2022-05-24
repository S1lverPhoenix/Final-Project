import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Money extends JFrame implements ActionListener{
    JFrame frame;
    
    JButton[] money = new JButton[7];
    JButton oneButton, fiveButton, tenButton, twentyButton, fiftyButton, hundredButton,amtTotal;
    private static int totalPaid;
    private int oneC, fiveC, tenC, twentyC, fiftyC, hundC;
    private double amount;

    public Money() {
        
        frame=new JFrame("Money");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1450,560);
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
        Icon hundred = new ImageIcon("Images/money/hundred.jpeg");
        hundredButton= new JButton(hundred);
        
        //total value button
        amtTotal=new JButton("Total");
        amtTotal. setFont(new Font("Times New Roman", Font. PLAIN, 80));

        money[0]=oneButton;
        money[1]=fiveButton;
        money[2]=tenButton;
        money[3]=twentyButton;
        money[4]=fiftyButton;
        money[5]=hundredButton;
        money[6]=amtTotal;

        for(int i=0; i<7; i++){
            money[i].addActionListener(this);
            money[i].setFocusable(false);
        }

        oneButton.setBounds(0,0,226,530);
        fiveButton.setBounds(226,0,228,530);
        tenButton.setBounds(454,0,228,530);
        twentyButton.setBounds(682,0,228,530);
        fiftyButton.setBounds(910,0,228,530);
        hundredButton.setBounds(1138,0,228,530);
        amtTotal.setBounds(454,454,456,285);

        //adding to the frame
        frame.add(oneButton);
        frame.add(fiveButton);
        frame.add(tenButton);
        frame.add(twentyButton);
        frame.add(fiftyButton);
        frame.add(hundredButton);
        frame.add(amtTotal);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==oneButton && oneC <= 4){
            System.out.println("One dollar has been paid!");
            totalPaid+=1;
            oneC++;
        }
        if(e.getSource()==fiveButton && fiveC <= 1){
            System.out.println("Five dollars have been paid!");
            totalPaid+=5;
            fiveC++;
        }
        if(e.getSource()==tenButton && tenC <= 1){
            System.out.println("Ten dollars have been paid!");
            totalPaid+=10;
            tenC++;
        }
        if(e.getSource()==twentyButton && twentyC <= 3){
            System.out.println("Twenty dollars have been paid!");
            totalPaid+=20;
            twentyC++;
        }
        if(e.getSource()==fiftyButton && fiftyC <= 1){
            System.out.println("Fifty dollars have been paid!");
            totalPaid+=50;
            fiftyC++;
        }
        if(e.getSource()==hundredButton && hundC <= 1){
            System.out.println("A hundred dollars have been paid!");
            totalPaid+=100;
            hundC++;
        }
        //for(int i=0; i<1; i++){
            //if there is a button corresponding to this source call
            //if(e.getSource()==amtTotal){
                System.out.println("The Total amount paid was: "+ totalPaid);

            //}  
            return;
        } 
    //} 
    public double getTotalDollars(){
        return totalPaid;
    }
   
}

