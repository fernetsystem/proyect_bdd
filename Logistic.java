import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class Logistic extends Connect implements ActionListener {
	JFrame f;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,bak;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8;
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	Icon icono1,icono2,icono3,icono4,icono5,icono6;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	JLabel back;
	public Logistic() {
		super("127.0.0.1","ekta","root","w9w9dorotea");
		f = new JFrame("CONTROL DE PRODUCTOS");
		lb1 = new JLabel("Codigo");			text1 = new JTextField(20);
		lb2 = new JLabel("Nombre");			text2 = new JTextField(20);
		lb3 = new JLabel("Descripcion");	text3 = new JTextField(20);
		lb4 = new JLabel("Color");			text4 = new JTextField(20);
		lb5 = new JLabel("Departamento");	text5 = new JTextField(20);
		lb6 = new JLabel("Existencia");		text6 = new JTextField(20);
		lb7 = new JLabel("Precio");			text7 = new JTextField(20);
		lb8 = new JLabel("Buscar");			text8 = new JTextField(20);
		Icon icono1 = new ImageIcon(getClass().getResource("222.png"));
		Icon icono2 = new ImageIcon(getClass().getResource("ic4.png"));
		Icon icono3 = new ImageIcon(getClass().getResource("icono3.png"));
		Icon icono4 = new ImageIcon(getClass().getResource("ic2.png"));
		Icon icono5 = new ImageIcon(getClass().getResource("ic9.png"));
		Icon icono6 = new ImageIcon(getClass().getResource("icono6.png"));
		btn1 = new JButton("Limpiar",icono1);
		btn2 = new JButton("Agregar",icono2);
		btn3 = new JButton("Modificar",icono3);
		btn4 = new JButton("Eliminar",icono4);
		btn5 = new JButton(icono5);
		btn6 = new JButton("Regresar",icono6);
		bak = new JLabel(new ImageIcon("B_HH1.png"));
		modelo = new DefaultTableModel() {
	   		@Override
	   		public boolean isCellEditable(int fila, int columna) {
	       		return false;
	   			}
			};
		table = new JTable(modelo);
		src = new JScrollPane();
	}
	public void usar(){
		f.add(bak);
		bak.setLayout(null);
		bak.add(lb1); bak.add(text1);
		bak.add(lb2); bak.add(text2);
		bak.add(lb3); bak.add(text3);
		bak.add(lb4); bak.add(text4);
		bak.add(lb5); bak.add(text5);
		bak.add(lb6); bak.add(text6);
		bak.add(lb7); bak.add(text7);
		bak.add(lb8); bak.add(text8);
		bak.add(btn1);
		bak.add(btn2);
		bak.add(btn3);
		bak.add(btn4);
		bak.add(btn5);
		bak.add(btn6);
		// -|-|
		lb1.setBounds(185,150,100,20); text1.setBounds(230,150,70,20);
		lb2.setBounds(180,180,100,20); text2.setBounds(230,180,110,20);
		lb3.setBounds(156,210,100,20); text3.setBounds(230,210,110,20);
		lb4.setBounds(195,240,100,20); text4.setBounds(230,240,70,20);
		lb5.setBounds(145,270,100,20); text5.setBounds(230,270,50,20);
		lb6.setBounds(167,300,100,20); text6.setBounds(230,300,70,20);
		lb7.setBounds(190,330,100,20); text7.setBounds(230,330,70,20);
		/*btn1.setBounds(20,600,130,35);	btn1.setBackground(new Color(111,135,143));		btn1.setForeground(Color.WHITE);
		btn2.setBounds(155,600,130,35);	btn2.setBackground(new Color(111,135,143));		btn2.setForeground(Color.WHITE);
		btn3.setBounds(290,600,130,35);	btn3.setBackground(new Color(111,135,143));		btn3.setForeground(Color.WHITE);
		btn4.setBounds(425,600,130,35);	btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);*/
		//_
		btn1.setBounds(7,160,130,35);	btn1.setBackground(new Color(111,135,143));		btn1.setForeground(Color.WHITE);
		btn2.setBounds(7,200,130,35);	btn2.setBackground(new Color(111,135,143));		btn2.setForeground(Color.WHITE);
		btn3.setBounds(7,240,130,35);	btn3.setBackground(new Color(111,135,143));		btn3.setForeground(Color.WHITE);
		btn4.setBounds(7,280,130,35);	btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);
		btn6.setBounds(7,280,130,35);	btn6.setBackground(new Color(24,173,254));		btn6.setForeground(Color.WHITE);
		
		lb8.setBounds(220,90,100,20); text8.setBounds(280,90,200,20); 
		btn5.setBounds(490,85,80,35);	btn5.setBackground(new Color(255,144,0));		
		btn6.setBounds(720,590,130,48);
		src.setViewportView(table);
		bak.add(src);
		src.setBounds(350,150,500,250);
		llena();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		f.setVisible(true);
		f.setBounds(10,10,895,705);
	}
	public void limpiar(){
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");
			text6.setText("");
			text7.setText("");
			text8.setText("");
	}
	public void busca(){ 
	String palabra = text8.getText();
	try{
		String query="Select * from prendas_logistica where codigo like '%"+palabra+"%' or nombre like '%"+palabra+"%' or descripcion like '%"+palabra+"%' or color like '%"+palabra+"%' or depto like '%"+palabra+"%' or existencia like '%"+palabra+"%' or precio like '%"+palabra+"%'"; 
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));
		}catch(SQLException e){System.out.println(e);	}
	}
	public void busca2(){ 
	String palabra = text8.getText();
	try{
		String query="Select * from prendas_logistica where codigo like '%"+palabra+"%' or nombre like '%"+palabra+"%' or descripcion like '%"+palabra+"%' or color like '%"+palabra+"%' or depto like '%"+palabra+"%' or existencia like '%"+palabra+"%' or precio like '%"+palabra+"%'"; 
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){
  		text1.setText(tabla.getString(1));
		text2.setText(tabla.getString(2));
		text3.setText(tabla.getString(3));
		text4.setText(tabla.getString(4));
		text5.setText(tabla.getString(5));
		text6.setText(tabla.getString(6));
		text7.setText(tabla.getString(7));
  		}	
		}catch(SQLException e){System.out.println(e);	}
	}
    public void llena(){ 
	try{
		String query="Select * from prendas_logistica";
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void grabar(){
				String codigo = text1.getText(); 
				String nombre = text2.getText();
				String descri = text3.getText();
				String color = text4.getText();
				String depto = text5.getText(); 
				String exist = text6.getText();
				String precio = text7.getText();  
    	try{
    		stmt = conexion.prepareStatement("INSERT INTO prendas_logistica VALUES(?,?,?,?,?,?,?)");
    		stmt.setString(1,codigo);
		  	stmt.setString(2,nombre);
		  	stmt.setString(3,descri);
		  	stmt.setString(4,color);
		  	stmt.setString(5,depto);
		  	stmt.setString(6,exist);
		  	stmt.setString(7,precio);
    		int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"Producto dado de alta");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"Error al dar de alta");}
    	}catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
    	limpiar();
	}
	public void modificar(){
				String codigo = text1.getText(); 
				String nombre = text2.getText();
				String descri = text3.getText();
				String color = text4.getText();
				String depto = text5.getText(); 
				String exist = text6.getText();
				String precio = text7.getText();
		try{
			String cadena = "UPDATE prendas_logistica SET nombre=?,descripcion=?,color=?,depto=?,existencia=?,precio=? WHERE codigo=?;";
    		stmt = conexion.prepareStatement(cadena);
    		stmt.setString(7,codigo);
    		stmt.setString(1,nombre);
    		stmt.setString(2,descri);
    		stmt.setString(3,color);
    		stmt.setString(4,depto);
    		stmt.setString(5,exist);
    		stmt.setString(6,precio);
    		int retorno = stmt.executeUpdate();
    		if(retorno==1){JOptionPane.showMessageDialog(null,"Producto Modificado");}
    		if(retorno==0){JOptionPane.showMessageDialog(null,"Error al modificar");}
		}catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
		limpiar();
	}
	public void eliminar(){
    	String id = text1.getText(); 
    	try{
    		stmt = conexion.prepareStatement("delete from prendas_logistica where codigo=?;");
    		stmt.setString(1,id);
    		int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"Borrado con exito");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"Fracaso en el borrado");}
    	}catch(SQLException e){ JOptionPane.showMessageDialog(null,e);}
    }
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == btn1)
		{
			limpiar();
			llena();
		}
		if(evt.getSource() == btn2)
		{
			grabar();
			llena();
		}
		if(evt.getSource() == btn3)
		{
			modificar();
			llena();
		}
		if(evt.getSource() == btn4){
			eliminar();
			llena();
		}
		if(evt.getSource() == btn5){
			busca();
			busca2();
		}
		if(evt.getSource() == btn6){
			f.setVisible(false);
			MenuLogistic MyMenuL = new MenuLogistic();
			MyMenuL.use();
		}
	}
	public static void main(String[] args) {
		Logistic l = new Logistic();
		l.usar();
	}

}