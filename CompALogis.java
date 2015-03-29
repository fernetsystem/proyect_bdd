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
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
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
    Icon icono1 = new ImageIcon(getClass().getResource("ic9.png"));
    Icon icono6 = new ImageIcon(getClass().getResource("7_1.png"));
    Icon icono7 = new ImageIcon(getClass().getResource("7_3.png"));
    Icon icono8 = new ImageIcon(getClass().getResource("icono6.png"));
    btn1 = new JButton(icono1);
    btn2 = new JButton("Añadir");
    btn3 = new JButton("Quitar");
    btn4 = new JButton("Solicitar Pedidos");
    btn5 = new JButton("Cancelar Pedidos");
    btn6 = new JButton("Inventario",icono6); 		 	
    btn7 = new JButton("Vender",icono7); 	
    btn8 = new JButton("Regresar",icono8); 		 
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
    	bak.add(btn6);
    	bak.add(btn7);
    	bak.add(btn8);		
    	l1.setBounds	(165,89,60,13);
    	text1.setBounds	(212,86,150,20);
    	btn1.setBounds	(365,80,80,35);		btn1.setBackground(new Color(255,144,0));
    	l2.setBounds	(165,370,120,13);
    	text2.setBounds	(235,367,70,20);
    	l3.setBounds	(330,370,60,13);
    	text3.setBounds	(375,367,75,20);
    	l4.setBounds	(470,370,60,13);
    	text4.setBounds	(530,367,60,20);
    	btn2.setBounds(475,410,75,45);		btn2.setBackground(new Color(181,230,29));		btn2.setForeground(Color.WHITE);
    	btn3.setBounds(563,410,75,45);		btn3.setBackground(new Color(255,28,28));		btn3.setForeground(Color.WHITE);
 		btn4.setBounds	 (165,590,160,45);	btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);	
 		btn5.setBounds	 (335,590,160,45);	btn5.setBackground(new Color(111,135,143));		btn5.setForeground(Color.WHITE);	
 		btn6.setBounds	 (7,100,130,50); 	btn6.setBackground(new Color(111,135,143));		btn6.setForeground(Color.WHITE);	
    	btn7.setBounds	 (7,160,130,50);	btn7.setBackground(new Color(111,135,143));		btn7.setForeground(Color.WHITE);	
    	btn8.setBounds(720,590,130,48);		btn8.setBackground(new Color(24,173,254));		btn8.setForeground(Color.WHITE);
   		
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
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
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
		String query="insert into facturas values("+text2.getText()+",1,localtimestamp())";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"SOLICITUD DE PRODUCTOS ENVIADA");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Error al solicitar los pedidos");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_Pedidos(){ 
	try{
		String query="insert into pedidos values(null,"+text2.getText()+","+text3.getText()+","+text4.getText()+",'EN ESPERA')";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Se agrego un pedido a la lista");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Error al agregar un pedido");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarFactura(){ 
	try{
		String query="delete from facturas where idfactura="+text2.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"SE CANCELO EL PEDIDO CORRECTAMENTE");}
    	if(retorno == 0){/*JOptionPane.showMessageDialog(null,"Ocurrio un error al cancelar el pedido");*/}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarPedidos(){ 
	try{
		String query="delete from pedidos where idfactura="+text2.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){/*JOptionPane.showMessageDialog(null,"SE CANCELO EL PEDIDO CORRECTAMENTE");*/}
    	if(retorno == 0){/*JOptionPane.showMessageDialog(null,"Ocurrio un error al cancelar un pedido");*/}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void quitar_Pedido(){ 
	try{
		String query="delete from pedidos where codigo="+text3.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){/*JOptionPane.showMessageDialog(null,"");*/}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso al quitar el pedidos");}
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
  				f.setVisible(false);
				MenuS1 MyMenuS1 = new MenuS1();
				MyMenuS1.use();
  		}
		if(e.getSource()==btn5){
  				cancelarPedidos();
  				cancelarFactura();
  				llena2(); 		
  				text1.setText("");
    			text2.setText(""); 
    			text3.setText("");
    			text4.setText("");
  		}
  		if(e.getSource()==btn6){
    		f.setVisible(false);
    		Inventario Form1 = new Inventario();
    		Form1.use();
  		}
  		if(e.getSource()==btn7){
  			f.setVisible(false);
    		Ventas Form3 = new Ventas();
    		Form3.use();
  		}
  		if(e.getSource()==btn8){
  			f.setVisible(false);
			MenuS1 MyMenu = new MenuS1();
			MyMenu.use();
  		}  		
    }
    public static void main(String args[]){
    	CompALogis com = new CompALogis();
    	com.use();
    }   
}