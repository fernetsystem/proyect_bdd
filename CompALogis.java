import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class CompALogis extends Connect implements ActionListener{
	JFrame f;
	JLabel l1,l2,l3,l4,bak;
	JTextField text1,text2,text3,text4;
	JButton btn1,btn2,btn3,btn4,btn5;
	JTable table,table2;
	DefaultTableModel modelo,modelo2;
	JScrollPane src,src2;
	JLabel back;
    public CompALogis() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame("COMPRAR A LOGISTICA");
    l1 = new JLabel("Buscar");
    l2 = new JLabel("No. Factura");
    l3 = new JLabel("Codigo");
    l4 = new JLabel("Cantidad");
    text1 = new JTextField();
    text2 = new JTextField();
    text3 = new JTextField();
    text4 = new JTextField();
    btn1 = new JButton("Buscar");
    btn2 = new JButton("Añadir");
    btn3 = new JButton("Quitar");
    btn4 = new JButton("Realizar Pedidos");
    btn5 = new JButton("Cancelar Pedido");
    bak = new JLabel(new ImageIcon("B_HH1.png"));
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
    }
    public void use(){
    	f.add(bak);
    	bak.setLayout(null);
    	bak.add(l1);
    	bak.add(text1);
    	bak.add(btn1);
    	bak.add(l2);
    	bak.add(text2);
    	bak.add(l3);
    	bak.add(text3);
    	bak.add(l4);
    	bak.add(text4);
    	bak.add(btn2);
    	bak.add(btn3);
    	bak.add(btn4);
    	bak.add(btn5);	
    	l1.setBounds	(165,85,60,13);
    	text1.setBounds	(212,82,150,20);
    	btn1.setBounds	(365,80,75,20);
    	l2.setBounds	(165,370,120,13);
    	text2.setBounds	(235,367,70,20);
    	l3.setBounds	(330,370,60,13);
    	text3.setBounds	(375,367,75,20);
    	l4.setBounds	(470,370,60,13);
    	text4.setBounds	(530,367,60,20);
    	btn2.setBounds(475,410,75,45);
    	btn3.setBounds(563,410,75,45);
    	btn4.setBounds(485,560,150,20);
    	btn5.setBounds(485,590,150,20);
    	
	    src.setViewportView(table);
		bak.add(src);
		src.setBounds(165,120,600,220);
		src2.setViewportView(table2);
		bak.add(src2);
		src2.setBounds(165,410,300,150);
		llena();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
    	f.setVisible(true);
    	f.setBounds(10,10,895,705);
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