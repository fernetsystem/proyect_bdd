import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.*;

public class Forma1 extends JPanel implements ActionListener {
   JFrame f;
   JLabel b, l1;
   JTextField text1;
   JButton btn1,btn2,btn3;
   JFileChooser chooser;
   String choosertitle;
   Icon icono_1,icono_2,icono_3;
  public Forma1() {
  	f = new JFrame();
  	l1 = new JLabel("Archivo");
  	text1 = new JTextField(20);
    Icon icono_1 = new ImageIcon(getClass().getResource("icono14.png"));
    Icon icono_2 = new ImageIcon(getClass().getResource("icono11.png"));
    Icon icono_3 = new ImageIcon(getClass().getResource("play.png"));
  	btn1 = new JButton(icono_1);
    btn2 = new JButton(icono_2);
    btn3 = new JButton(icono_3);
    b = new JLabel(new ImageIcon("113.jpg"));
   }
	public void usar1(){
		f.add(b);
		b.setLayout(null); 
		b.add(l1); 		b.add(text1);
    	b.add(btn1);	b.add(btn2);	b.add(btn3);
    				//- |	-	|
   		l1.setBounds(10,40,100,20);
   		text1.setBounds(70,40,200,20);
   		btn1.setBounds(280,35,125,35);
   		btn2.setBounds(130,100,130,35);
   		btn3.setBounds(300,200,130,40);
   		btn1.setText("Examinar");	btn1.setBackground(new Color(49,74,82));		btn1.setForeground(Color.WHITE);
   		btn2.setText("Respaldar");	btn2.setBackground(new Color(123,160,173));		btn2.setForeground(Color.WHITE); 
   		btn3.setText("Regresar");	btn3.setBackground(new Color(49,74,82));		btn3.setForeground(Color.WHITE); 
    	btn1.addActionListener(this);
    	btn2.addActionListener(this);
    	btn3.addActionListener(this);
    	f.setSize(476,302);
    	f.setVisible(true);
	}
  public void actionPerformed(ActionEvent e) {
    int result;
    if(e.getSource() == btn1){
    	chooser = new JFileChooser(); 
    	chooser.setCurrentDirectory(new java.io.File(".")); 
    	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	chooser.setAcceptAllFileFilterUsed(true);    
    	if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
    		String archivo_obtenido = chooser.getSelectedFile().toString();
    		text1.setText(archivo_obtenido);
      		//JOptionPane.showMessageDialog(null,"Archivo selecccionado:" + chooser.getSelectedFile());
      	}else{
      		JOptionPane.showMessageDialog(null,"No se selecciono un archivo");
      	}
     }
     if(e.getSource()==btn2){
     	String linea = null;
     	String Anombre = text1.getText();
     	try{
     		Runtime runtime = Runtime.getRuntime();
     		File recupera = new File(String.valueOf(Anombre)+".sql");
     		FileWriter fw = new FileWriter(recupera);
     		Process proceso = runtime.exec("C:\\Server\\mysql\\bin\\mysqldump --opt --password=w9w9dorotea --user=root --databases log -R ");
     		InputStreamReader irs = new InputStreamReader(proceso.getInputStream());
     		BufferedReader br = new BufferedReader(irs);
     		while((linea=br.readLine())!=null){
     			fw.write(linea+"\n");
     		}
     		fw.close();
     		irs.close();
     		br.close();
     		
     	}catch(IOException ex){JOptionPane.showMessageDialog(null,ex); 
     	}
     }
     if(e.getSource()==btn3){
     	f.setVisible(false);
     	MenuEMP mymenu = new MenuEMP();
     	mymenu.usar();
 
     }
  }
  public static void main(String[] args) {
    Forma1 fr = new Forma1();
    fr.usar1();
    }
}


