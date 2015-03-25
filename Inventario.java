import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Inventario extends Connect implements ActionListener{
	JFrame f;
	JLabel l1,bak;
	JTextField text1;
	JButton btn1,btn2,btn3,btn4;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	JLabel back;
    public Inventario() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame();
    l1 = new JLabel("Buscar");
    text1 = new JTextField();
    Icon icono1 = new ImageIcon(getClass().getResource("ic9.png"));
	Icon icono2 = new ImageIcon(getClass().getResource("icono6.png"));
    Icon icono3 = new ImageIcon(getClass().getResource("9999.png"));
    Icon icono4 = new ImageIcon(getClass().getResource("7_3.png"));
	btn1 = new JButton(icono1);
	btn2 = new JButton("Regresar",icono2);
	btn3 = new JButton("Solicitar",icono3); 		 	
	btn4 = new JButton("Vender",icono4); 	 		 	
    bak = new JLabel(new ImageIcon("B_NN1.png"));
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
    	f.add(bak);
    	bak.setLayout(null);
    	bak.add(l1);
    	bak.add(text1);
    	bak.add(btn1);
    	bak.add(btn2);	
    	bak.add(btn3);	
    	bak.add(btn4);	
    	l1.setBounds(235,125,60,13);
    	text1.setBounds(282,122,150,20);
    	btn1.setBounds(435,115,80,35);	btn1.setBackground(new Color(255,144,0));		
		btn2.setBounds(720,590,130,48);	btn2.setBackground(new Color(24,173,254));		btn2.setForeground(Color.WHITE);
   		btn3.setBounds(9,100,160,50);   btn3.setBackground(new Color(111,135,143));		btn3.setForeground(Color.WHITE);
 		btn4.setBounds(9,160,160,50);   btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);
    	src.setViewportView(table);
		bak.add(src);
		src.setBounds(235,180,600,250);
		llena();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		f.setVisible(true);
    	f.setBounds(20,20,891,700);
    }
    public void busca(){ 
	String palabra = text1.getText();
	try{
		String query="Select * from prendas_sucursal1 where codigo like '%"+palabra+"%' or nombre like '%"+palabra+"%' or descripcion like '%"+palabra+"%' or color like '%"+palabra+"%' or depto like '%"+palabra+"%' or existencia like '%"+palabra+"%' or precio like '%"+palabra+"%'"; 
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
    public void llena(){ 
	try{
		String query="Select * from prendas_sucursal1";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==btn1){
			busca();
		}
		if(evt.getSource()==btn2){
			f.setVisible(false);
			MenuS1 MyMenu = new MenuS1();
			MyMenu.use();
		}
		if(evt.getSource()==btn3){
    		f.setVisible(false);
    		CompALogis Form2 = new CompALogis();
    		Form2.use();
		}
		if(evt.getSource()==btn4){
    		f.setVisible(false);
    		Ventas Form3 = new Ventas();
    		Form3.use();
			
		}
	}
    public static void main(String args[]){
    	Inventario ive = new Inventario();
    	ive.use();
    }
}