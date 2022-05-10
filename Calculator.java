import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.Scanner;

public class Calculator extends JFrame implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons= new JButton[10];
    JButton[] x= new JButton[8];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton,clearButton;
    JPanel panel;

    Font myfont=new Font("Ink Free", Font.BOLD, 30);

    double num1=0;
    double num2=0;
    double value=0;

    char operator;

    public Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield= new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        multButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DELETE");
        clearButton=new JButton("CLEAR");

        numberButtons[0]=addButton;
        numberButtons[1]=subButton;
        numberButtons[2]=multButton;
        numberButtons[3]=divButton;
        numberButtons[4]=decButton;
        numberButtons[5]=equButton;
        numberButtons[6]=delButton;
        numberButtons[7]=clearButton;

        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }    
}
