import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Inventario extends Connect implements ActionListener{
	JFrame f;
	JLabel l1;
	JTextField text1;
	JButton btn1;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	JLabel back;
    public Inventario() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
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
		llena();
		btn1.addActionListener(this);
		f.setVisible(true);
    	f.setBounds(300,300,680,400);
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
	}
    public static void main(String args[]){
    	Inventario ive = new Inventario();
    	ive.use();
    }
}