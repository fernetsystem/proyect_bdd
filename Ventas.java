import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Ventas {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField text1,text2,text3,text4,text5,text6,text7;
	JButton btn1,btn2,btn3;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
    public Ventas() {
    f = new JFrame();
    l1 = new JLabel("No. Cuenta");
    l2 = new JLabel("Fecha");
    l3 = new JLabel("Codigo");
    l4 = new JLabel("Cantidad");
    l5 = new JLabel("TOTAL");
    l6 = new JLabel("Recibo");
    l7 = new JLabel("Cambio");
    text1 =new JTextField();
    text2 =new JTextField();
    text3 =new JTextField();
    text4 =new JTextField();
    text5 =new JTextField();
    text6 =new JTextField();
    text7 =new JTextField();
    btn1 = new JButton("Añadir");
    btn2 = new JButton("Quitar");
    btn3 = new JButton("Realizarventa");
    modelo = new DefaultTableModel() {
	   		@Override
	   		public boolean isCellEditable(int fila, int columna) {
	       		return false;
	   			}
			};
	table = new JTable(modelo);
	src = new JScrollPane();
    }
    public void use(){
    	f.setLayout(null);
    	f.add(l1);	   	f.add(text1);
    	f.add(l2);		f.add(text2);
    	f.add(l3);		f.add(text3);
    	f.add(l4);		f.add(text4);
    	f.add(l5);		f.add(text5);
    	f.add(l6);		f.add(text6);
    	f.add(l7);		f.add(text7);
    	f.add(src);
    	f.add(btn1);
    	f.add(btn2);
    	f.add(btn3);
    	l1.setBounds	  (	18,	55,100,20);
    	text1.setBounds	  (	84,	55,100,20);
    	l2.setBounds	  (384, 55, 37,20);
    	text2.setBounds	  (427, 55,100,20);
    	l3.setBounds	  ( 20,100, 40,20);
    	text3.setBounds   ( 67,100,100,20);
    	l4.setBounds	  (188,100,100,20);
    	text4.setBounds	  (243,100, 40,20);
    	src.setViewportView(table);
		src.setBounds	  ( 20,135,300,250);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		btn1.setBounds	 (330,135, 80,50);
		btn2.setBounds	 (420,135, 80,50);
		l5.setBounds	 (340,215,100,20);
    	text5.setBounds	 (390,215, 60,20);
    	l6.setBounds	 (340,245,100,20);
    	text6.setBounds	 (390,245, 60,20);
    	l7.setBounds	 (340,275,100,20);
    	text7.setBounds	 (390,275, 60,20);
 		btn3.setBounds	 (330,330,130,50);
    	f.setVisible(true);
    	f.setBounds		 (200,200,560,450);
    }
    public static void main(String args[]){
    	Ventas ve = new Ventas();
    	ve.use();
    }
    
    
}