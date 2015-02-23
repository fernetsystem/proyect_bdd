import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
public class Logistic {
	JFrame f;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8;
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	Icon icono1,icono2,icono3,icono4,icono5,icono6;
	JTable table;
	DefaultTableModel modelo;
	JScrollPane src;
	JLabel back;
	public Logistic() {
		f = new JFrame();
		lb1 = new JLabel("Codigo");			text1 = new JTextField(20);
		lb2 = new JLabel("Nombre");			text2 = new JTextField(20);
		lb3 = new JLabel("Descripcion");	text3 = new JTextField(20);
		lb4 = new JLabel("Color");			text4 = new JTextField(20);
		lb5 = new JLabel("Departamento");	text5 = new JTextField(20);
		lb6 = new JLabel("Existencia");		text6 = new JTextField(20);
		lb7 = new JLabel("Precio");			text7 = new JTextField(20);
		lb8 = new JLabel("Buscar");			text8 = new JTextField(20);
		Icon icono1 = new ImageIcon(getClass().getResource("icono1.png"));
		Icon icono2 = new ImageIcon(getClass().getResource("icono2.png"));
		Icon icono3 = new ImageIcon(getClass().getResource("icono3.png"));
		Icon icono4 = new ImageIcon(getClass().getResource("icono4.png"));
		Icon icono5 = new ImageIcon(getClass().getResource("icono5.png"));
		Icon icono6 = new ImageIcon(getClass().getResource("icono6.png"));
		btn1 = new JButton("Limpiar",icono1);
		btn2 = new JButton("Agregar",icono2);
		btn3 = new JButton("Modificar",icono3);
		btn4 = new JButton("Eliminar",icono4);
		btn5 = new JButton(icono5);
		btn6 = new JButton("Regresar",icono6);
		modelo = new DefaultTableModel() {
	   		@Override
	   		public boolean isCellEditable(int fila, int columna) {
	       		return false;
	   			}
			};
		table = new JTable(modelo);
		src = new JScrollPane();
	    back = new JLabel(new ImageIcon("b.jpg"));
	}
	public void usar(){
		f.add(back);
		back.setLayout(null);
		back.add(lb1); back.add(text1);
		back.add(lb2); back.add(text2);
		back.add(lb3); back.add(text3);
		back.add(lb4); back.add(text4);
		back.add(lb5); back.add(text5);
		back.add(lb6); back.add(text6);
		back.add(lb7); back.add(text7);
		back.add(lb8); back.add(text8);
		back.add(btn1);
		back.add(btn2);
		back.add(btn3);
		back.add(btn4);
		back.add(btn5);
		back.add(btn6);
		// -|-|
		lb1.setBounds(10,20,100,20); text1.setBounds(100,20,200,20);
		lb2.setBounds(10,50,100,20); text2.setBounds(100,50,200,20);
		lb3.setBounds(10,80,100,20); text3.setBounds(100,80,200,20);
		lb4.setBounds(10,110,100,20); text4.setBounds(100,110,200,20);
		lb5.setBounds(10,140,100,20); text5.setBounds(100,140,200,20);
		lb6.setBounds(10,170,100,20); text6.setBounds(100,170,200,20);
		lb7.setBounds(10,200,100,20); text7.setBounds(100,200,200,20);
		btn1.setBounds(20,240,130,35);
		btn2.setBounds(155,240,130,35);
		btn3.setBounds(290,240,130,35);
		btn4.setBounds(425,240,130,35);
		lb8.setBounds(20,300,100,20); text8.setBounds(80,300,200,20); btn5.setBounds(290,290,100,35);
		src.setViewportView(table);
		back.add(src);
		src.setBounds(10,340,600,340);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Color");
		modelo.addColumn("Depto");
		modelo.addColumn("Existencia");
		modelo.addColumn("Precio");
		f.setVisible(true);
		f.setSize(650,750);
	}
	public static void main(String[] args) {
		Logistic l = new Logistic();
		l.usar();
	}

}