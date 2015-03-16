import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class CompALogis extends Connect implements ActionListener{
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField text1,text2,text3,text4;
	JButton btn1,btn2,btn3,btn4,btn5;
	JTable table,table2;
	DefaultTableModel modelo,modelo2;
	JScrollPane src,src2;
	JLabel back;
    public CompALogis() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame();
    l1 = new JLabel("Buscar");
    l2 = new JLabel("No. Factura");
    l3 = new JLabel("Codigo");
    l4 = new JLabel("Cantidad");
    text1 = new JTextField();
    text2 = new JTextField();
    text3 = new JTextField();
    text4 = new JTextField();
    btn1 = new JButton("Buscar");
    btn2 = new JButton("A�adir");
    btn3 = new JButton("Quitar");
    btn4 = new JButton("Realizar Pedidos");
    btn5 = new JButton("Cancelar Pedido");
  	modelo = new DefaultTableModel() {
	   		@Override
	   		public boolean isCellEditable(int fila, int columna) {
	       		return false;
	   			}
			};
	table = new JTable(modelo);
	src = new JScrollPane();
	modelo2 = new DefaultTableModel() {
	   		@Override
	   		public boolean isCellEditable(int fila, int columna) {
	       		return false;
	   			}
			};
	table2 = new JTable(modelo2);
	src2 = new JScrollPane();
	
	back = new JLabel(new ImageIcon("b.jpg"));
    }
    public void use(){
    	f.setLayout(null);
    	f.add(l1);
    	f.add(text1);
    	f.add(btn1);
    	f.add(l2);
    	f.add(text2);
    	f.add(l3);
    	f.add(text3);
    	f.add(l4);
    	f.add(text4);
    	f.add(btn2);
    	f.add(btn3);
    	f.add(btn4);
    	f.add(btn5);	
    	l1.setBounds(35,55,60,13);
    	text1.setBounds(82,52,150,20);
    	btn1.setBounds(235,50,75,20);
    	l2.setBounds	(35,370,120,13);
    	text2.setBounds	(105,367,70,20);
    	l3.setBounds	(200,370,60,13);
    	text3.setBounds	(245,367,75,20);
    	l4.setBounds	(340,370,60,13);
    	text4.setBounds	(400,367,60,20);
    	btn2.setBounds(355,410,75,45);
    	btn3.setBounds(433,410,75,45);
    	btn4.setBounds(355,560,150,20);
    	btn5.setBounds(355,590,150,20);
    	
	    src.setViewportView(table);
		f.add(src);
		src.setBounds(35,90,600,250);
		src2.setViewportView(table2);
		f.add(src2);
		src2.setBounds(35,410,300,250);
		modelo2.addColumn("Codigo");
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Cantidad");
		llena();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
    	f.setVisible(true);
    	f.setBounds(300,300,680,718);
    }
	public void llena(){ 
	try{
		String query="Select * from prendas_logistica";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void busca(){ 
	String palabra = text1.getText();
	try{
		String query="Select * from prendas_logistica where codigo like '%"+palabra+"%' or nombre like '%"+palabra+"%' or descripcion like '%"+palabra+"%' or color like '%"+palabra+"%' or depto like '%"+palabra+"%' or existencia like '%"+palabra+"%' or precio like '%"+palabra+"%'"; 
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void llena2(){ 
	try{
		String query="select p.codigo,nombre,unidades from pedidos join prendas_logistica p on pedidos.codigo=p.codigo where idfactura="+text2.getText();
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table2.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void insertar_Facturas(){ 
	try{
		String query="insert into facturas values("+text2.getText()+",1,'2015-03-16','NoServido')";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_Pedidos(){ 
	try{
		String query="insert into pedidos values(null,"+text2.getText()+","+text3.getText()+","+text4.getText()+")";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarFactura(){ 
	try{
		String query="delete from facturas where idfactura="+text2.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarPedidos(){ 
	try{
		String query="delete from pedidos where idfactura="+text2.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void quitar_Pedido(){ 
	try{
		String query="delete from pedidos where codigo="+text3.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
    public void actionPerformed(ActionEvent e){
  		if(e.getSource()==btn1){
  				busca();
  		}
  		if(e.getSource()==btn2){
  				insertar_Pedidos();
  				llena2();
  		}
  		if(e.getSource()==btn3){
  				quitar_Pedido();
  				llena2();	
  		}
  		if(e.getSource()==btn4){
  				insertar_Facturas();
  		}
		if(e.getSource()==btn5){
  				cancelarPedidos();
  				cancelarFactura();
  				llena2();
  				
  		}  		
    }
    public static void main(String args[]){
    	CompALogis com = new CompALogis();
    	com.use();
    }   
}