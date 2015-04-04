import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class Pedidos extends Connect implements ActionListener{
	public JFrame f;
	JLabel lb1,lb2,bak;
	JButton btn0,btn1,btn2,btn3,btn4,btn5;
	JTextField text0,text1;
	JTable table,table2;
	DefaultTableModel modelo,modelo2;
	JScrollPane src,src2;
	JLabel back;
	static String codigo="",nombre="",desc="",color="",depto="",existencia="",unidades="",precio="",existenciaS1;
	static String nuevaExistencia=""; static String nuevoPrecio="";	static int unidadesInt=0,existenciaInt=0;	static int precioInt=0;
	
    public Pedidos() {
     	super("127.0.0.1","directorio","root","w9w9dorotea");
     	f= new JFrame("SUCURSAL 1");
    	lb1 = new JLabel("Buscar");
    	lb2 = new JLabel("Id Pedido");
    	text0 = new JTextField();
    	text1 = new JTextField();
    	
    	Icon icono0 = new ImageIcon(getClass().getResource("106.png"));
    	Icon icono1 = new ImageIcon(getClass().getResource("105.png"));
		Icon icono2 = new ImageIcon(getClass().getResource("9999.png"));	
		Icon icono3 = new ImageIcon(getClass().getResource("icono6.png"));	
		Icon icono4 = new ImageIcon(getClass().getResource("999_99.png"));
		Icon icono5 = new ImageIcon(getClass().getResource("icono6.png"));	
    	btn0 = new JButton("Buscar",icono0);
    	btn1 = new JButton("Ver pedido");
    	btn2 = new JButton("MANDAR PRODUCTOS",icono2);
    	btn3 = new JButton("Cancelar");
    	btn4 = new JButton("Productos",icono4);
    	btn5 = new JButton("Regresar",icono5);
   	   	bak = new JLabel(new ImageIcon("B_NN1.png"));
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
	    src.setViewportView(table);
	    src2.setViewportView(table2);
		bak.add(src);
		bak.add(src2);
		bak.add(btn0);
		bak.add(text0);
		bak.add(lb2);
		bak.add(text1);
		bak.add(btn1);
		bak.add(btn2);
		bak.add(btn4);
		bak.add(btn5);
		text0.setBounds(600,110,130,20);
		btn0.setBounds(745,108,110,25);	btn0.setBackground(new Color(255,144,0));	btn0.setForeground(Color.WHITE);
		src.setBounds(205,150,640,200);
		lb2.setBounds(205,397,80,15);//
		text1.setBounds(275,394,60,20);//
		btn1.setBounds(355,391,130,25);	btn1.setBackground(new Color(111,135,143));		btn1.setForeground(Color.WHITE);//
		btn2.setBounds(626,470,220,50);	btn2.setBackground(new Color(111,135,143));		btn2.setForeground(Color.WHITE);//		
		btn4.setBounds(9,100,160,50);	btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);	
		btn5.setBounds(710,590,130,48);	btn5.setBackground(new Color(24,173,254));		btn5.setForeground(Color.WHITE);
	
		src2.setBounds(205,433,640,40);//
		llena();
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		f.setVisible(true);
		f.setBounds(20,20,891,700);
    }
    public void limpia(){
    	text0.setText("");
    	text1.setText("");
    	codigo="";     	nombre="";
    	desc="";    	color="";
    	depto="";		existencia="";
    	unidades="";    precio="";
    	existenciaS1=null;
	   nuevaExistencia="";	   	nuevoPrecio="";	
	   unidadesInt=0;			existenciaInt=0;
	   precioInt=0;
    }
	public void llena(){
	try{
		String query="select p.idfactura,fecha,idpedido,codigo,unidades,estado from pedidos p inner join facturas on p.idfactura=facturas.idfactura where idsucursal=1";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void llena2(){ 
	try{
		String query="select idfactura,idpedido,p.codigo,nombre,descripcion,color,depto,existencia,unidades,precio from pedidos p inner join prendas_logistica l  on p.codigo=l.codigo where idpedido="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table2.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
	}
	 public void busca(){ 
	String palabra = text0.getText();
	try{
		String query="select p.idfactura,fecha,idpedido,codigo,unidades,estado from pedidos p inner join facturas on p.idfactura=facturas.idfactura";
  		query=query+" where idsucursal=1 and p.idfactura like'%"+palabra+"%' or fecha like'%"+palabra+"%' or idpedido like'%"+palabra+"%' or codigo like'%"+palabra+"%' or unidades like'%"+palabra+"%' or estado like'%"+palabra+"%'";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
	}
	public void cambiarEstado(){
		try{
			String query = "UPDATE pedidos SET estado='SERVIDO' WHERE idpedido="+text1.getText();
    		stmt = conexion.prepareStatement(query);    		
    		int retorno = stmt.executeUpdate();
    		if(retorno==1){/*JOptionPane.showMessageDialog(null,"Producto Modificado");*/}
    		if(retorno==0){JOptionPane.showMessageDialog(null,"Error al cambiar el estado");}
		}catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
	}
	public void obtenerCodigoDelPedido(){
		try{
		String query="select idfactura,idpedido,p.codigo,nombre,descripcion,color,depto,existencia,unidades,precio from pedidos p inner join prendas_logistica l  on p.codigo=l.codigo where idpedido="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){
  			codigo = tabla.getString(3);			nombre= tabla.getString(4);
			desc= tabla.getString(5);    			color= tabla.getString(6);
			depto= tabla.getString(7);  			existencia= tabla.getString(8);
			unidades= tabla.getString(9);			precio= tabla.getString(10);
  		}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
		//JOptionPane.showMessageDialog(null,"PRIMERMETODO OBTENER DATOS DE LOGISTICA \n codigo: "+codigo+"\n nombre:"+nombre+"\n desc:"+desc+"\n color:"+color+"\n depto:"+depto+"\n existencia:"+existencia+"\n unidades:"+unidades+"\n precio:"+precio+"");
	}
	public void obtenerExistenciaDeS1(){
		try{
		String query="select * from prendas_sucursal1 where codigo="+codigo;
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){
			existenciaS1= tabla.getString(6);
  			}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
		//JOptionPane.showMessageDialog(null,"EXISTENSIA DEL PRODUCTO EN SUCURSAL 1: "+existenciaS1+"");
	}  
	public void insertarProducto(){
		
	if(existenciaS1==null){
		precioInt = Integer.parseInt(precio);
		precioInt = precioInt + 50;
		nuevoPrecio = Integer.toString(precioInt);
		//JOptionPane.showMessageDialog(null,"SERIA UN NUEVO PRODUCTO PARA LA SUCURSAL1 \nPRECIO DE FABRICA"+precio+"\nPRECIO PARA VENDER"+nuevoPrecio+"");
		try{
			String query="INSERT INTO prendas_sucursal1 VALUES("+codigo+",'"+nombre+"','"+desc+"','"+color+"','"+depto+"',"+unidades+","+nuevoPrecio+")";
  			stmt =conexion.prepareStatement(query);
  			int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"SE INSERTO UN NUEVO PRODUCTO A LA S1");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"OCURRIO UN ERRO AL INSERTAR A LA S1");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}else{
		//JOptionPane.showMessageDialog(null,"YA ESTOY DISPONIBLEE PARA LA SUCURSAL1 \nSOLO AUMENTA MI EXISTENCIA");
		unidadesInt = Integer.parseInt(unidades);
		existenciaInt = Integer.parseInt(existenciaS1);		
		existenciaInt = existenciaInt + unidadesInt;  
		nuevaExistencia = Integer.toString(existenciaInt);
		//JOptionPane.showMessageDialog(null,"EXISTENCIA ACTUAL:"+existenciaS1+"\n ME PIDIERON:"+unidades+"\nQUEDARIA \nEXS + UNID="+nuevaExistencia+"");
		try{
			String query="UPDATE prendas_sucursal1 SET existencia="+nuevaExistencia+" where codigo="+codigo;
  			stmt =conexion.prepareStatement(query);
  			int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"SE ACTUALIZO LA EXISTENCIA");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR AL ACTUALIZAR LA EXISTENCIA");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
		}	
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==btn0){
			busca();
		}
		if(evt.getSource()==btn1){
			llena2();
		}
		if(evt.getSource()==btn2){
			cambiarEstado();
			obtenerCodigoDelPedido();
			obtenerExistenciaDeS1();
			insertarProducto();
			llena();
			limpia();
			
		}
		if(evt.getSource()==btn4){
			f.setVisible(false);
    		Logistic Form1 = new Logistic();
    		Form1.usar();
		}
		if(evt.getSource()==btn5){
			f.setVisible(false);
			MenuLogistic MyMenuL = new MenuLogistic();
			MyMenuL.use();
		}
	}


    public static void main(String[] args) {
    	Pedidos p = new Pedidos();
     	p.use();
    	
    }
}