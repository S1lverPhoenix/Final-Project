import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator extends JFrame implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons= new JButton[9];
    JButton[] x= new JButton[10];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton,clearButton,negButton;
    JPanel p;

    Font myfont=new Font("Ink Free", Font.BOLD, 30);

    protected double num1=0;
    protected double num2=0;
    protected double value=0;

    char operator;

    public Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield= new JTextField();
        textfield.setBounds(50, 30, 300, 50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        multButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("del");
        clearButton=new JButton("clear");
        negButton= new JButton("(-)");

        numberButtons[0]=addButton;
        numberButtons[1]=subButton;
        numberButtons[2]=multButton;
        numberButtons[3]=divButton;
        numberButtons[4]=decButton;
        numberButtons[5]=equButton;
        numberButtons[6]=delButton;
        numberButtons[7]=clearButton;
        numberButtons[8]=negButton;

        for(int i=0; i<9; i++){
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);

        }
        //numbers
        for(int i=0; i<10; i++){
            x[i]= new JButton(String.valueOf(i));
            x[i].addActionListener(this);
            x[i].setFont(myfont);
            x[i].setFocusable(false);

        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);
        
        p=new JPanel();
        p.setBounds(50,100,300,300);
        p.setLayout(new GridLayout(4,4,10,10));

        //adding buttons
        //1st row
        p.add(x[7]);
        p.add(x[8]);
        p.add(x[9]);
        p.add(divButton);
        //2nd row
        p.add(x[4]);
        p.add(x[5]);
        p.add(x[6]);
        p.add(multButton);
        //3rd row
        p.add(x[1]);
        p.add(x[2]);
        p.add(x[3]);
        p.add(subButton);
        //4th row
        p.add(x[0]);
        p.add(decButton);
        p.add(equButton);
        p.add(addButton);
        //bottom row
        frame.add(p);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clearButton);

        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //adding value to text field, one number only
        for(int i=0; i<10; i++){
            if(e.getSource()==x[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        //add button
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        //subtract button
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        //multiplication button
        if(e.getSource()==multButton){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        //division button
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        //decimal button
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        //clear button
        if(e.getSource()==clearButton){
            textfield.setText("");
        }
        //neg button
        if(e.getSource()==negButton){
            double d= Double.parseDouble(textfield.getText());
            d*=-1;
            textfield.setText(String.valueOf(d));
        }
        //del button
        if(e.getSource()==delButton){
            String s=textfield.getText();
            textfield.setText("");
            for(int i=0; i<s.length()-1; i++){
                textfield.setText(textfield.getText()+s.charAt(i));
            }
        }
        //equals button
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    value=num1+num2;
                    break;
            
                case '-':
                    value=Math.abs(num1-num2);
                    break;

                case '*':
                    value=num1*num2;
                    break;

                case'/':
                    value=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(value));
            num1=value;
        }
    }    
    public double getTotal(){
        return value;
    }
}
