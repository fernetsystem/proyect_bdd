import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class login {
	JPanel pan1,pan2,pan3;
	JButton btn1,btn2;
	JLabel lbl1,lbl2;
	JTextField txt1,txt2;
	JFrame fr1;
login() {
	fr1=new JFrame("Login");
	lbl1=new JLabel("Usuario");
	lbl2=new JLabel("Password");
	txt1=new JTextField(20);
	txt2=new JTextField(20);
	btn1=new JButton("Ingresar");
	btn2=new JButton("Salir");
	pan1=new JPanel();
	pan2=new JPanel();
	pan3=new JPanel();
    }
    public void usar(){
    	fr1.setLayout(new GridLayout(3,3));
    	pan1.add(lbl1);pan1.add(txt1);
    	pan2.add(lbl2);pan2.add(txt2);
    	pan3.add(btn1);pan3.add(btn2);
    	fr1.add(pan1);fr1.add(pan2);fr1.add(pan3);
    	btn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		}});
		btn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		System.exit(0);
		}});
    	fr1.setVisible(true);
    	fr1.pack();
    }
    public static void main(String[] args) {
    	login mylogin=new login();
    	mylogin.usar();
    }
}
