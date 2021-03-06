import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class MenuS1 extends Connect implements ActionListener {
	JFrame f;
	JLabel bak;
	Icon icono1,icono2,icono3,icono4,icono5,icono6;
	JButton btn5,btn6,btn7,btn8,btn9,btn10;
    public MenuS1() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame("MENU SUCURSAL 1");
    bak = new JLabel(new ImageIcon("M_NN3.png"));
    Icon icono5 = new ImageIcon(getClass().getResource("7_1.png"));
    Icon icono6 = new ImageIcon(getClass().getResource("9999.png"));
    Icon icono7 = new ImageIcon(getClass().getResource("7_3.png"));
    Icon icono8 = new ImageIcon(getClass().getResource("905.png"));
	Icon icono9 = new ImageIcon(getClass().getResource("icono11.png"));	
	Icon icono10 = new ImageIcon(getClass().getResource("icono12.png"));
    
    btn5 = new JButton("Inventario",icono5); 		 btn5.setBackground(new Color(111,135,143));		btn5.setForeground(Color.WHITE);	
    btn6 = new JButton("Solicitar",icono6); 		 btn6.setBackground(new Color(111,135,143));		btn6.setForeground(Color.WHITE);	
	btn7 = new JButton("Vender",icono7); 	 		 btn7.setBackground(new Color(111,135,143));		btn7.setForeground(Color.WHITE);	
	btn8 = new JButton("Reportes",icono8); 		 	 btn8.setBackground(new Color(111,135,143));		btn8.setForeground(Color.WHITE);	
    btn9 = new JButton("Respaldar",icono9); 		 btn9.setBackground(new Color(111,135,143));		btn9.setForeground(Color.WHITE);		
    btn10 = new JButton("Restaurar",icono10); 		 btn10.setBackground(new Color(111,135,143));		btn10.setForeground(Color.WHITE);		  
    }
    public void use(){
    	f.add(bak);
    	bak.setLayout(null);
    	bak.add(btn5);
   		bak.add(btn6);
   		bak.add(btn7);
   		bak.add(btn8);
   		bak.add(btn9);
   		bak.add(btn10);	
   		btn5.setBounds	 (9,100,160,50);
 		btn6.setBounds	 (9,160,160,50);
 		btn7.setBounds	 (9,220,160,50);
 		btn8.setBounds	 (9,280,160,50);
 		btn9.setBounds	 (9,340,160,50);
 		btn10.setBounds	 (9,400,160,50);
 		
 		btn5.addActionListener(this);
 		btn6.addActionListener(this);
    	btn7.addActionListener(this);
    	btn8.addActionListener(this);
    	btn9.addActionListener(this);
    	btn10.addActionListener(this);
		
    	f.setVisible(true);
    	f.setBounds		 (20,20,891,700);
    }
    
    public void actionPerformed(ActionEvent evt){
    	if(evt.getSource() == btn5){
    		f.setVisible(false);
    		Inventario Form1 = new Inventario();
    		Form1.use();
    	}
    	if(evt.getSource() == btn6){
    		f.setVisible(false);
    		CompALogis Form2 = new CompALogis();
    		Form2.use();
    	}
    	if(evt.getSource() == btn7){
    		f.setVisible(false);
    		Ventas Form3 = new Ventas();
    		Form3.use();
    	}
    	if(evt.getSource() == btn8){
    		f.setVisible(false);
    	}
    	if(evt.getSource() == btn9){
    		f.setVisible(false);
    	}
    	if(evt.getSource() == btn10){
    		f.setVisible(false);
    	}
    }
    public static void main(String args[]){
    	MenuS1 MyMenuS1 = new MenuS1();
    	MyMenuS1.use();
    }
    
    
}