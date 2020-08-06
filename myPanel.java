/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxapp;

/**
 *
 * @author SHEKHAR
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myPanel implements ActionListener{
    
      private static int PayableTax= 0;
   private static String userInput;

   protected static JPanel jp = new JPanel();
   private static JLabel jl1;
   private static JLabel jl2;
   private static JTextField jt1;
   private static JButton jb1;
   public static JButton jb2;
   private static  final GridBagLayout gbl = new GridBagLayout();
    
    protected myPanel(){}
    
    protected void Display(){
    
//SetPanel
jp.setVisible(true);
jp.setBounds(200,300,200,300);//250,500,250,500 } old values - larger panel
jp.setBackground(Color.BLACK);
//jp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

//Components
    jl1 = new JLabel("Enter your Salary Below");
    jl2 = new JLabel("*Your Payable Tax will show here*");
jt1 = new JTextField("                                 ");
jb1 = new JButton("Tax Table");
jb2 = new JButton("Ok");
//Label 1
jl1.setBounds(30,50,30,50);
jl1.setVisible(true);
//Label 2
jl2.setBounds(30,50,30,50);
jl2.setVisible(true);
//Text filed
jt1.equals(userInput);
jt1.setBounds(250,20,250,20);
jt1.setVisible(true);
//Button1
jb1.setBounds(20,30,20,30);
jb1.addActionListener(this);
jb1.setVisible(true);
//Button2
jb2.setBounds(10,10,10,10);
jb2.addActionListener(this);
jb2.setVisible(true);

//Grid Settings
GridBagConstraints gbc = new GridBagConstraints();
jp.setLayout(gbl);
//gbc.insets= new Insets(0,0,50,10);/*up,right,down,left*/

//Button1
gbc.gridx= 0;
gbc.gridy= 0;
//jb1.addActionListener(this);
jp.add(jb1,gbc);

//Button2
gbc.gridx=0;
gbc.gridy=11;
jp.add(jb2,gbc);

//Text
//gbc.insets= new Insets(0,10,0,0);/*up,right,down,left*/
gbc.gridx=0;
gbc.gridy=10;
jp.add(jt1,gbc);

//Label
gbc.gridx=0;
gbc.gridy=6;
jp.add(jl1,gbc);

//Label2
gbc.gridx=0;
gbc.gridy=30;
jp.add(jl2,gbc);

jp.validate();

}
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==jb1){
    JOptionPane.showMessageDialog(null,"​Taxable income (R)	​Rates of tax (R)\n" +
"1 – 205 900	18% of taxable income\n" +
"205 901 – 321 600	37 062 + 26% of taxable income above 205 900\n" +
"321 601 – 445 100	67 144 + 31% of taxable income above 321 600\n" +
"445 101 – 584 200	105 429 + 36% of taxable income above 445 100\n" +
"584 201 – 744 800	155 505 + 39% of taxable income above 584 200\n" +
"744 801 – 1 577 300	218 139 + 41% of taxable income above 744 800\n" +
"1 577 301 and above	559 464 + 45% of taxable income above 1 577 300");
    }
    if(e.getSource()==jb2){
    Calculate c = new Calculate();
    c.Calculate();
    }
    }

class Calculate{

protected Calculate(){}
private void Conversion(){
try{
    
    userInput=jt1.getText();
  /*with the .replace method ... you must replace what u want while also displaying it or casting it
    or what ever u doing with it
    */
    System.out.println(userInput.replace(" ",""));
    PayableTax=Integer.parseInt(userInput.replace(" ",""));// this statemnt is the problem nth else
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"Oops...Something Goof'd !\n"
        + "You entered a String which cannot be used here !\n"
        + "Please eneter a number(s)\n"
        + "NOTE:You do not need to ad any currency symbols or annotation.");
}
}

protected void Calculate(){
    //JOptionPane.showMessageDialog(null,"Hii");
    Conversion();
if(PayableTax >= 1 && PayableTax <= 205900){
    PayableTax = PayableTax /100*18;
    }
    else if(PayableTax >= 205901 && PayableTax <= 321600){
    PayableTax = PayableTax / 100 * 26 + 37062;
    }
    else if(PayableTax >= 321601 && PayableTax <= 445100){
    PayableTax = PayableTax / 100 * 31 + 67144;
    }
    else if(PayableTax >= 445101 && PayableTax <= 584200){
    PayableTax = PayableTax / 100 * 36 + 105429;
    }
    else if(PayableTax >= 584201 && PayableTax <= 744800){
    PayableTax = PayableTax / 100 * 39 + 155505;
    }
    else if(PayableTax >= 744801 && PayableTax <= 1577300){
    PayableTax = PayableTax / 100 * 41 + 218139;
    }
    else if(PayableTax <= 1577301){
    PayableTax = PayableTax / 100 * 45 + 559464;
    
   
    }
    showAnswer();
}
private void showAnswer(){
    System.out.println("showAnswer() is working");
jl2.setText(" ");
jl2.setText("R "+PayableTax);
}
}}