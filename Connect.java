import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class Connect extends TheMenuS1{
	PreparedStatement stmt = null;
	Connection conexion = null;
	ResultSet tabla = null;
    public Connect(String server, String base, String usuario,String pass) {
    	String cadena = "";
    	cadena = "jdbc:mysql://"+server+"/"+base+"?user="+usuario+"&password="+pass;
    	
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		conexion = DriverManager.getConnection(cadena);
    		//System.out.println(conexion);
    		
    	}catch(ClassNotFoundException e){JOptionPane.showMessageDialog(null,e);}
    	catch(Exception es){JOptionPane.showMessageDialog(null,es);}
    }
}