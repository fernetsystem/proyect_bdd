import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Inventario extends Connect implements ActionListener{
	JFrame f;
	JLabel l1,bak;
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
    bak = new JLabel(new ImageIcon("B_NN1.png"));
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
    	bak.add(l1);
    	bak.add(text1);
    	bak.add(btn1);	
    	l1.setBounds(235,125,60,13);
    	text1.setBounds(282,122,150,20);
    	btn1.setBounds(435,120,75,20);
    	src.setViewportView(table);
		bak.add(src);
		src.setBounds(235,180,600,250);
		llena();
		btn1.addActionListener(this);
		f.setVisible(true);
    	f.setBounds(200,200,891,700);
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