import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class CompALogis {
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField text1,text2,text3;
	JButton btn1,btn2,btn3,btn4,btn5;
	JTable table,table2;
	DefaultTableModel modelo,modelo2;
	JScrollPane src,src2;
	JLabel back;
	
    public CompALogis() {
    f = new JFrame();
    l1 = new JLabel("Buscar");
    l2 = new JLabel("Codigo");
    l3 = new JLabel("Cantidad");
    text1 = new JTextField();
    text2 = new JTextField();
    text3 = new JTextField();
    btn1 = new JButton("Buscar");
    btn2 = new JButton("Añadir");
    btn3 = new JButton("Quitar");
    btn4 = new JButton("Realizar Pedido");
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
    	f.add(btn2);
    	f.add(btn3);
    	f.add(btn4);
    	f.add(btn5);	
    	l1.setBounds(35,55,60,13);
    	text1.setBounds(82,52,150,20);
    	btn1.setBounds(235,50,75,20);
    	l2.setBounds(35,370,60,13);
    	text2.setBounds(81,367,100,20);
    	l3.setBounds(211,370,60,13);
    	text3.setBounds(266,367,75,20);
    	btn2.setBounds(355,410,75,45);
    	btn3.setBounds(433,410,75,45);
    	btn4.setBounds(355,560,150,20);
    	btn5.setBounds(355,590,150,20);
    	
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
		src2.setViewportView(table2);
		f.add(src2);
		src2.setBounds(35,410,300,250);
		modelo2.addColumn("Codigo");
		modelo2.addColumn("Nombre");
		modelo2.addColumn("Cantidad");
		
    	f.setVisible(true);
    	f.setBounds(300,300,680,718);
    }
    public static void main(String args[]){
    	CompALogis com = new CompALogis();
    	com.use();
    }
    
    
}