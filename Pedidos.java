import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class Pedidos extends Connect implements ItemListener,ActionListener{
	public JFrame f;
	JLabel lb1,lb2;
	JButton btn1,btn2,btn3;
	JComboBox cmb1;
	JTextField text1;
	JTable table,table2;
	DefaultTableModel modelo,modelo2;
	JScrollPane src,src2;
	JLabel back;
    public Pedidos() {
     	super("127.0.0.1","ekta","root","w9w9dorotea");
     	f= new JFrame("FIND");
    	lb1 = new JLabel("Sucursal");
    	lb2 = new JLabel("No.Factura");
    	text1 = new JTextField();
    	btn1 = new JButton("Buscar");
    	btn2 = new JButton("Mandar y aceptar");
    	btn3 = new JButton("Cancelar");
   	    cmb1 = new JComboBox();	cmb1.setBackground(new Color(255,255,255));//		cmb1.setForeground(Color.WHITE);
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
	    f.setLayout(null);
	    src.setViewportView(table);
	    src2.setViewportView(table2);
		f.add(src);
		f.add(src2);
		f.add(lb1);
		f.add(cmb1);
		f.add(lb2);
		f.add(text1);
		f.add(btn1);
		cmb1.addItem("1");
		cmb1.addItem("2");
		lb1.setBounds(20,20,80,15);
		cmb1.setBounds(90,18,60,20);
		src.setBounds(20,50,300,150);
		lb2.setBounds(20,230,80,15);
		text1.setBounds(90,230,60,20);
		btn1.setBounds(170,230,100,20);
		src2.setBounds(20,260,300,100);
		llena("1 and 2");
		//llena2();
		btn1.addActionListener(this);
		cmb1.addItemListener(this);
		f.setVisible(true);
    	f.setSize(510,540);
    	f.setLocation(500,300);
    }
	public void llena(String selecionado){
	try{
		String query="Select * from facturas where idsucursal="+selecionado;
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){System.out.println(e);	}
	}
	public void llena2(){ 
	try{
		String query="select idfactura,idpedido,pedi.codigo,nombre,unidades from pedidos pedi join prendas_logistica on pedi.codigo=prendas_logistica.codigo where idfactura="+text1.getText();
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		table2.setModel(DbUtils.resultSetToTableModel(tabla));	
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
	} 
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==btn1){
			llena2();
		}
	}
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==cmb1) {
            String seleccionado=(String)cmb1.getSelectedItem();
            llena(seleccionado);
        }
    }
    public static void main(String[] args) {
    	Pedidos p = new Pedidos();
     	p.use();
    	
    }
}