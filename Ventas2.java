import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class Ventas2 extends Connect implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,bak;
	JTextField text1,text2,text3,text4,text5,text6,text7;
	Icon icono1,icono2,icono3,icono4,icono5,icono6;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	JComboBox cmb1;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	static String mytotalCad;
    public Ventas2() {
    super("127.0.0.1","ekta","root","w9w9dorotea");
    f = new JFrame("VENTAS SUCURSAL 2");
    l1 = new JLabel("No. Cuenta");
    //l2 = new JLabel(new ImageIcon("ic8.png"));
    l3 = new JLabel("Codigo");
    l4 = new JLabel("Cantidad");
    l5 = new JLabel("TOTAL");
    l6 = new JLabel("Recibo");
    l7 = new JLabel("Cambio");
    bak = new JLabel(new ImageIcon("B_NN1.png"));
    text1 =new JTextField();
    //text2 =new JTextField();
    text3 =new JTextField();
    text4 =new JTextField();
    text5 =new JTextField();
    text6 =new JTextField();
    text7 =new JTextField();
    Icon icono1 = new ImageIcon(getClass().getResource("ic15.png")); //20,70,94
    Icon icono2 = new ImageIcon(getClass().getResource("ic1.png"));  //66,100,114
    Icon icono3 = new ImageIcon(getClass().getResource("4444.png"));
    Icon icono4 = new ImageIcon(getClass().getResource("6666.png"));
    Icon icono5 = new ImageIcon(getClass().getResource("7_1.png"));
    Icon icono6 = new ImageIcon(getClass().getResource("9999.png"));
    Icon icono7 = new ImageIcon(getClass().getResource("7_3.png"));
    Icon icono8 = new ImageIcon(getClass().getResource("100.png"));
	Icon icono9 = new ImageIcon(getClass().getResource("icono6.png"));
    btn1 = new JButton(icono1);	btn1.setBackground(new Color(111,135,143));		
    btn2 = new JButton(icono2);	btn2.setBackground(new Color(111,135,143));		
    btn3 = new JButton("Realizar venta",icono3); btn3.setBackground(new Color(111,135,143));		btn3.setForeground(Color.WHITE);	
    btn4 = new JButton("Cancelar venta",icono4); btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);	
    
    btn5 = new JButton("Inventario",icono5); 		 btn5.setBackground(new Color(111,135,143));		btn5.setForeground(Color.WHITE);	
    btn6 = new JButton("Solicitar",icono6); 		 btn6.setBackground(new Color(111,135,143));		btn6.setForeground(Color.WHITE);	
	btn7 = new JButton("Vender",icono7); 	 		 btn7.setBackground(new Color(111,135,143));		btn7.setForeground(Color.WHITE);	
	btn8 = new JButton("Pedidos",icono8); 		 	 btn8.setBackground(new Color(111,135,143));		btn8.setForeground(Color.WHITE);	
    btn9 = new JButton("Regresar",icono9);		     btn9.setBackground(new Color(24,173,254));		btn9.setForeground(Color.WHITE);
	
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
    	//bak.add(l2);		bak.add(text2);
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
   		
   		bak.add(btn5);
   		bak.add(btn6);
   		bak.add(btn9);
   		
   		bak.add(cmb1);
    	l1.setBounds	  (218,105,100,20);
    	text1.setBounds	  (284,105,100,20);
    	//l2.setBounds	  (576, 90, 50,50);
    	//text2.setBounds	  (627,105,100,20);
    	l3.setBounds	  (220,150, 40,20);
    	cmb1.setBounds    (267,150,100,20);
    	l4.setBounds	  (388,150,100,20);
    	text4.setBounds	  (443,150, 40,20);
    	src.setViewportView(table);
		src.setBounds	  (220,185,300,250);
		btn1.setBounds	 (530,185, 80,50);	
		btn2.setBounds	 (620,185, 80,50);
		l5.setBounds	 (540,270,100,20);
    	text5.setBounds	 (590,270, 60,20);
    	l6.setBounds	 (540,300,100,20);
    	text6.setBounds	 (590,300, 60,20);
    	l7.setBounds	 (540,325,100,20);
    	text7.setBounds	 (590,325, 60,20);
 		btn3.setBounds	 (230,590,160,45);
 		btn4.setBounds	 (400,590,160,45);
 		
 		btn5.setBounds	 (9,100,160,50);
 		btn6.setBounds	 (9,160,160,50);
 		btn9.setBounds	(720,590,130,48);
 		btn1.addActionListener(this);
 		btn2.addActionListener(this);
    	btn3.addActionListener(this);
    	btn4.addActionListener(this);
    	btn5.addActionListener(this);
    	btn6.addActionListener(this);
    	btn9.addActionListener(this);
    	    text6.addActionListener(this);

		llena();    
    	f.setVisible(true);
    	f.setBounds		 (20,20,891,700);
    }
    public void llena(){ 
	try{
		String query="Select * from prendas_sucursal2";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){ cmb1.addItem(tabla.getString(1));}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void llenaTabla1(){ 
	try{
		String query="select v.codigo,nombre,precio as precio_unitario,unidades,unidades*precio as importe from ventas_sucursal2 v join prendas_sucursal2 pre on v.codigo=pre.codigo where idcuenta="+text1.getText();
    	stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarCuenta(){ 
	try{
		String query="delete from cuentas_sucursal2 where idcuenta="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void cancelarVentas(){ 
	try{
		String query="delete from ventas_sucursal2 where idcuenta="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Fac exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Fac");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_cuenta(){ 
	try{
		String query="INSERT INTO cuentas_sucursal2 VALUES("+text1.getText()+",localtimestamp())";
  		stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void insertar_venta(){ 
	try{
		String query = "INSERT INTO ventas_sucursal2 VALUES(NULL,"+text1.getText()+","+cmb1.getSelectedItem() +","+text4.getText()+")";
    	stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
	public void eliminar_venta(){ 
	try{
		String query = "DELETE FROM ventas_sucursal2 WHERE codigo="+cmb1.getSelectedItem()+" and idcuenta="+text1.getText();
    	stmt =conexion.prepareStatement(query);
  		int retorno = stmt.executeUpdate();
    	if(retorno == 1){JOptionPane.showMessageDialog(null,"Ped exitosa");}
    	if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso de Pedi");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}
   public void SumaTotal(){ 
	try{
		String query="select sum(unidades*precio) as Total From ventas_sucursal2 v join prendas_sucursal2 pre on v.codigo=pre.codigo  where idcuenta="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){ 
  			mytotalCad = tabla.getString(1);
  			text5.setText(tabla.getString(1));	}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}

    public void actionPerformed(ActionEvent evt){
    	if(evt.getSource() == btn1){
    		insertar_venta();
    		llenaTabla1();
    		SumaTotal();
    	}
    	if(evt.getSource() == btn2){
    		eliminar_venta();
    		llenaTabla1();
    		SumaTotal();
    	}
    	if(evt.getSource()==btn3){
    		insertar_cuenta();
    		f.setVisible(false);
    		Ventas2 Form3 = new Ventas2();
    		Form3.use();
    	}
    	if(evt.getSource()==btn4){
    		cancelarCuenta();
    		cancelarVentas();
    		llenaTabla1();
    	}
    	if(evt.getSource()==btn5){
    		f.setVisible(false);
    		Inventario2 Form1 = new Inventario2();
    		Form1.use();
    	}
    	if(evt.getSource()==btn6){
    		f.setVisible(false);
    		CompALogis2 Form2 = new CompALogis2();
    		Form2.use();
    	}
    	if(evt.getSource()==btn9){
			f.setVisible(false);
			MenuS2 MyMenuS2 = new MenuS2();
			MyMenuS2.use();
    	}
    	if(evt.getSource() == text6){
    		int mytotal,recibo,cambio;
    		String cambioCad,reciboCad;
			String nulo="";
			if(text6.getText().equals(nulo)){
			JOptionPane.showMessageDialog(null,"No se ah recibido nada");}
			else { text7.requestFocusInWindow();
					reciboCad = text6.getText(); 
   					mytotal = Integer.parseInt(mytotalCad);
   					recibo = Integer.parseInt(reciboCad);
   					if(recibo >= mytotal){
   						cambio = recibo - mytotal ;
   						cambioCad = Integer.toString(cambio);
						text7.setText(cambioCad);
   					}else{
   						JOptionPane.showMessageDialog(null,"Dinero insuficiente para la compra");
   						text6.setText("");
   						text6.requestFocusInWindow();
   					}
				}
    	}
    }
    public static void main(String args[]){
    	Ventas2 ve = new Ventas2();
    	ve.use();
    }
    
    
}