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
	JLabel lb1,lb2,bak;
	JButton btn1,btn2,btn3,btn4,btn5;
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
    	Icon icono1 = new ImageIcon(getClass().getResource("ic9.png"));
		Icon icono4 = new ImageIcon(getClass().getResource("999_99.png"));
		Icon icono5 = new ImageIcon(getClass().getResource("icono6.png"));	
    	btn1 = new JButton(icono1);
    	btn2 = new JButton("Mandar y aceptar");
    	btn3 = new JButton("Cancelar");
    	btn4 = new JButton("Productos",icono4);
    	btn5 = new JButton("Regresar",icono5);
   	    cmb1 = new JComboBox();	cmb1.setBackground(new Color(255,255,255));//		cmb1.setForeground(Color.WHITE);
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
		bak.add(lb1);
		bak.add(cmb1);
		bak.add(lb2);
		bak.add(text1);
		bak.add(btn1);
		bak.add(btn4);
		bak.add(btn5);
		cmb1.addItem("1");
		cmb1.addItem("2");
		lb1.setBounds(220,120,80,15);
		cmb1.setBounds(290,118,60,20);
		src.setBounds(220,150,300,150);
		lb2.setBounds(220,335,80,15);
		text1.setBounds(290,335,60,20);
		btn1.setBounds(370,330,80,35);	btn1.setBackground(new Color(255,144,0));		
		btn4.setBounds(9,100,160,50);	btn4.setBackground(new Color(111,135,143));		btn4.setForeground(Color.WHITE);	
		btn5.setBounds(720,590,130,48);	btn5.setBackground(new Color(24,173,254));		btn5.setForeground(Color.WHITE);
	
		src2.setBounds(220,380,500,100);
		llena("1 and 2");
		//llena2();
		btn1.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		cmb1.addItemListener(this);
		f.setVisible(true);
		f.setBounds(20,20,891,700);
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