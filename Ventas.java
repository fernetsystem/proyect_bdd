import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Ventas implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField text1,text2,text3,text4,text5,text6,text7;
	JButton btn1,btn2,btn3;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	static String existencia="";
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
 		btn1.addActionListener(this);
 		btn2.addActionListener(this);
    	btn3.addActionListener(this);
    
    	f.setVisible(true);
    	f.setBounds		 (200,200,560,450);
    }
    public void llenaTabla1(){
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
			Statement instruccion = conexion.createStatement();
			ResultSet tabla = instruccion.executeQuery("Select * from ventas_sucursal1 where idcuenta="+text1.getText()+";");
			while(tabla.next()){ 
			Object[] fila = new Object[4];
                fila[0] = tabla.getString(1);
                fila[1] = tabla.getString(2);
                fila[2] = tabla.getString(3);
                fila[3] = tabla.getString(4); 
                modelo.addRow(fila); 
			}
			} catch(ClassNotFoundException e) { JOptionPane.showMessageDialog(null,e);}
			catch(SQLException e) { System.out.println(e);JOptionPane.showMessageDialog(null,e);}
	}
	public void sacar_ex(){
		
		try{ Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
			Statement instruccion = conexion.createStatement();
			ResultSet tabla = instruccion.executeQuery("Select * from prendas_sucursal1 where codigo="+text3.getText()+";");
			while(tabla.next()){ 
                 existencia = tabla.getString(6);
			     text5.setText(tabla.getString(6));
			     
			}
			} catch(ClassNotFoundException e) { JOptionPane.showMessageDialog(null,e);}
			catch(SQLException e) { System.out.println(e);JOptionPane.showMessageDialog(null,e);}
			JOptionPane.showMessageDialog(null,existencia);
	}	
	
    public void insertar_cuenta(){
		
		PreparedStatement stmt = null;
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
    		String query1 = "INSERT INTO cuentas_sucursal1 VALUES("+text1.getText()+",'"+text2.getText()+"')";
    		stmt = conexion.prepareStatement(query1);	
    		int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"Venta exitosa");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de venta");}
    	}catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null,e);}
    		catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
    		catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
    public void insertar_venta(){
    	int exi,cant,tot=0;
    	exi = Integer.parseInt(existencia);
    	cant = Integer.parseInt(text4.getText());
    	tot = exi-cant;
    	String resu = "";
    	resu = Integer.toString(tot);
    	JOptionPane.showMessageDialog(null,tot);
		PreparedStatement stmt = null,stmt2=null;
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
    		String query1 = "INSERT INTO ventas_sucursal1 VALUES(NULL,"+text1.getText()+","+text3.getText()+","+text4.getText()+")";
    		stmt = conexion.prepareStatement(query1);
    		int retorno = stmt.executeUpdate();
    		String query2 = "UPDATE prendas_sucursal1 SET existencia="+resu+" where codigo="+text3.getText();
    		stmt2 = conexion.prepareStatement(query2);
    		int retorno2 = stmt2.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"Se agrego una prenda");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"No s epudo agregar una prenda");}
    	}catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null,e);}
    		catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
    		catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
    public void eliminar_venta(){
		PreparedStatement stmt = null;
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
    		String query1 = "DELETE FROM ventas_sucursal1 WHERE codigo="+text3.getText();
    		stmt = conexion.prepareStatement(query1);
    		int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"Se removio una prenda");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"No s epudo remover una prenda");}
    	}catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null,e);}
    		catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
    		catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
    public void actionPerformed(ActionEvent evt){
    	if(evt.getSource() == btn1){
    		//JOptionPane.showMessageDialog(null,"h");
    		sacar_ex();
    		insertar_venta();
    	
    		llenaTabla1();
    	}
    	if(evt.getSource() == btn2){
    		//JOptionPane.showMessageDialog(null,"h");
    		eliminar_venta();
    		llenaTabla1();
    	}
    	if(evt.getSource()==btn3){
    		insertar_cuenta();
    	}
    }
    public static void main(String args[]){
    	Ventas ve = new Ventas();
    	ve.use();
    }
    
    
}