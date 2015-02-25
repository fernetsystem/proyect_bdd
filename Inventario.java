import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Inventario {
	JFrame f;
	JLabel l1;
	JTextField text1;
	JButton btn1;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	JLabel back;
    public Inventario() {
    f = new JFrame();
    l1 = new JLabel("Buscar");
    text1 = new JTextField();
    btn1 = new JButton("Buscar");
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
    	f.add(l1);
    	f.add(text1);
    	f.add(btn1);	
    	l1.setBounds(35,55,60,13);
    	text1.setBounds(82,52,150,20);
    	btn1.setBounds(235,50,75,20);
    	src.setViewportView(table);
		f.add(src);
		src.setBounds(35,90,600,250);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Color");
		modelo.addColumn("Depto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		llenaTabla1();
		f.setVisible(true);
    	f.setBounds(300,300,680,400);
    }
    public void llenaTabla1(){
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ekta?user=root&password=w9w9dorotea");
			Statement instruccion = conexion.createStatement();
			ResultSet tabla = instruccion.executeQuery("Select * from prendas_sucursal1;");
			while(tabla.next()){ 
			Object[] fila = new Object[7];
                fila[0] = tabla.getString(1);
                fila[1] = tabla.getString(2);
                fila[2] = tabla.getString(3);
                fila[3] = tabla.getString(4);
                fila[4] = tabla.getString(5);
                fila[5] = tabla.getString(6);
                fila[6] = tabla.getString(7); 
                modelo.addRow(fila); 
			}
			} catch(ClassNotFoundException e) { JOptionPane.showMessageDialog(null,e);}
			catch(SQLException e) { System.out.println(e);JOptionPane.showMessageDialog(null,e);}
	}
    public static void main(String args[]){
    	Inventario ive = new Inventario();
    	ive.use();
    }
}