import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class TheMenuS1 implements ActionListener,ItemListener {
		int sw=0;
       public JMenu menu1,menu2,menu3;
       public JMenuBar mb;
        JMenuItem mi11;
        JMenuItem mi21;
        JMenuItem mi31,mi32;
        Icon ic1,ic2,ic3,ic4;
    public TheMenuS1() {
    	mb = new JMenuBar();
    	Icon ic1 = new ImageIcon(getClass().getResource("ic1.png"));
    	Icon ic2 = new ImageIcon(getClass().getResource("ic8.png"));
    	Icon ic3 = new ImageIcon(getClass().getResource("ic4.png"));
    	Icon ic4 = new ImageIcon(getClass().getResource("ic33.png"));
    	menu1 = new JMenu("Productos"); 
    	menu2 = new JMenu("Pedidos");
    	menu3 = new JMenu("Procesos especiales"); 
    	mi11 = new JMenuItem(ic1);
    	mi21 = new JMenuItem(ic2);
    	mi31 = new JMenuItem(ic3);
    	mi32 = new JMenuItem(ic4);
    }
    public void usar(){
    	//f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));
   		//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	mb.add(menu1);mb.add(menu2);mb.add(menu3);
    	mi11.setText("Mis productos");
    	mi21.setText("Mostrar pedidos");
    	mi31.setText("Respaldar");
    	mi32.setText("Restaura");
    	menu1.addActionListener(this);
    	menu2.addActionListener(this);
    	mi11.addActionListener(this);
    	mi21.addActionListener(this);
    	mi31.addActionListener(this);
    	mi32.addActionListener(this);
    	menu1.add(mi11);
    	menu2.add(mi21);
    	menu3.add(mi31);menu3.add(mi32);	
    }
    public void actionPerformed(ActionEvent e){}
    /*
    if(e.getSource()==mi11){
    	Logistic l = new Logistic();
    	l.usar();
    	//log mylog = new log();
    	//mylog.usar();
    }
    if(e.getSource()==mi21){
    	//f.setVisible(false);
    	//Forma1 myform1 = new Forma1();
    	//myform1.usar1();
    }
    if(e.getSource()==mi31){
    	//f.setVisible(false);
    	//Forma2 myform2 = new Forma2();
    	//myform2.usar1();
    }
    if(e.getSource()==mi32){
    	//f.setVisible(false);
    	//Forma3 myform3 = new Forma3();
    	//myform3.usar1();
    }
    }*/
    public void itemStateChanged(ItemEvent ie){
    	String state = "deselected";
    	if(ie.getStateChange()==ItemEvent.SELECTED){
    		state = "selected";
    	}
    }
}


