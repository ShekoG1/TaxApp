/*
A Basic Java application designed,by Shekhar Maharaj,
to calculate tax in Zar(South African Rands)
for the 2021 tax year.
-see Display comments for the tax table as well as TableDisplay !
 */
package taxapp;

import javax.swing.JFrame;

/**
 *
 * @author SHEKHAR
 */
public class TaxApp {

    //Constructers
    static JFrame jf = new JFrame("TaxCalculater");
    static myPanel d = new myPanel();
    
    public static void main(String[] args) {
        // TODO code application logic here
        myFrame();
        d.Display();
    }
    private static void myFrame(){ 
jf.setBounds(200,300,200,300);//250,500,250,500 } old values - larger frame
jf.setVisible(true);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setResizable(false);
jf.add(d.jp);



}
}
