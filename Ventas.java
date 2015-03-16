import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class Ventas extends Connect implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,bak;
	JTextField text1,text2,text3,text4,text5,text6,text7;
	Icon icono1,icono2,icono3,icono4,icono5,icono6;
	JButton btn1,btn2,btn3,btn4;
	JComboBox cmb1;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	static String existencia="";
    public Ventas() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame();
    l1 = new JLabel("No. Cuenta");
    l2 = new JLabel(new ImageIcon("ic8.png"));
    l3 = new JLabel("Codigo");
    l4 = new JLabel("Cantidad");
    l5 = new JLabel("TOTAL");
    l6 = new JLabel("Recibo");
    l7 = new JLabel("Cambio");
    bak = new JLabel(new ImageIcon("v5.jpg"));
    text1 =new JTextField();
    text2 =new JTextField();
    text3 =new JTextField();
    text4 =new JTextField();
    text5 =new JTextField();
    text6 =new JTextField();
    text7 =new JTextField();
    Icon icono1 = new ImageIcon(getClass().getResource("ic15.png")); //20,70,94
    Icon icono2 = new ImageIcon(getClass().getResource("ic1.png"));  //66,100,114
    Icon icono3 = new ImageIcon(getClass().getResource("ic33.png"));
    btn1 = new JButton(icono1);	btn1.setBackground(new Color(111,135,143));		
    btn2 = new JButton(icono2);	btn2.setBackground(new Color(111,135,143));		
    btn3 = new JButton("Realizar venta",icono3); btn3.setBackground(new Color(111,135,143));		btn3.setForeground(Color.WHITE);	
    btn4 = new JButton("Cancelar venta",icono2); btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);	
    cmb1 = new JComboBox();	cmb1.setBackground(new Color(255,255,255));//		cmb1.setForeground(Color.WHITE);
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
    	bak.add(l1);		bak.add(text1);
    	bak.add(l2);		bak.add(text2);
    	bak.add(l3);		bak.add(text3);
    	bak.add(l4);		bak.add(text4);
    	bak.add(l5);		bak.add(text5);
    	bak.add(l6);		bak.add(text6);
    	bak.add(l7);		bak.add(text7);
    	bak.add(src);
   		bak.add(btn1);    	
   		bak.add(btn2);
   		bak.add(btn3);
   		bak.add(btn4);
   		bak.add(cmb1);
    	l1.setBounds	  (	18,	55,100,20);
    	text1.setBounds	  (	84,	55,100,20);
    	l2.setBounds	  (376, 40, 50,50);
    	text2.setBounds	  (427, 55,100,20);
    	l3.setBounds	  ( 20,100, 40,20);
    	cmb1.setBounds    ( 67,100,100,20);
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
 		btn3.setBounds	 (330,330,160,50);
 		btn4.setBounds	 (330,380,160,50);
 		btn1.addActionListener(this);
 		btn2.addActionListener(this);
    	btn3.addActionListener(this);
    	btn4.addActionListener(this);
		llena();    
    	f.setVisible(true);
    	f.setBounds		 (200,200,560,450);
    }
    public void llena(){ 
	try{
		String query="Select * from prendas_sucursal1";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){ cmb1.addItem(tabla.getString(1));}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void llenaTabla1(){ 
	try{
		String query="select v.codigo,nombre,precio as precio_unitario,unidades,unidades*precio as importe from ventas_sucursal1 v join prendas_sucursal1 pre on v.codigo=pre.codigo where idcuenta="+text1.getText();
    	stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarCuenta(){ 
	try{
		String query="delete from cuentas_sucursal1 where idcuenta="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarVentas(){ 
	try{
		String query="delete from ventas_sucursal1 where idcuenta="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_cuenta(){ 
	try{
		String query="INSERT INTO cuentas_sucursal1 VALUES("+text1.getText()+",'"+text2.getText()+"')";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_venta(){ 
	try{
		String query = "INSERT INTO ventas_sucursal1 VALUES(NULL,"+text1.getText()+","+cmb1.getSelectedItem() +","+text4.getText()+")";
    	stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void eliminar_venta(){ 
	try{
		String query = "DELETE FROM ventas_sucursal1 WHERE codigo="+cmb1.getSelectedItem()+" and idcuenta="+text1.getText();
    	stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
    
    public void actionPerformed(ActionEvent evt){
    	if(evt.getSource() == btn1){
    		insertar_venta();
    		llenaTabla1();
    	}
    	if(evt.getSource() == btn2){
    		eliminar_venta();
    		llenaTabla1();
    	}
    	if(evt.getSource()==btn3){
    		insertar_cuenta();
    	}
    	if(evt.getSource()==btn4){
    		cancelarCuenta();
    		cancelarVentas();
    		llenaTabla1();
    	}
    }
    public static void main(String args[]){
    	Ventas ve = new Ventas();
    	ve.use();
    }
    
    
}