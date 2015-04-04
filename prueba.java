import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class prueba extends Connect {
	static String codigo="",nombre="",desc="",color="",depto="",existencia="",unidades="",precio="",existenciaS1;
	static String nuevaExistencia=""; static String nuevoPrecio="";	static int unidadesInt=0,existenciaInt=0;	static int precioInt=0;

    public prueba() {
    	super("127.0.0.1","directorio","root","w9w9dorotea");
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
		JOptionPane.showMessageDialog(null,"PRIMERMETODO OBTENER DATOS DE LOGISTICA \n codigo: "+codigo+"\n nombre:"+nombre+"\n desc:"+desc+"\n color:"+color+"\n depto:"+depto+"\n existencia:"+existencia+"\n unidades:"+unidades+"\n precio:"+precio+"");
	}
	public void obtenerExistenciaDeS1(){
		try{
		String query="select * from test where codigo="+codigo;
  		stmt =conexion.prepareStatement(query);
  		tabla=stmt.executeQuery();
  		while(tabla.next()){
			existenciaS1= tabla.getString(6);
  			}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);	}
		JOptionPane.showMessageDialog(null,"EXISTENSIA DEL PRODUCTO EN SUCURSAL 1: "+existenciaS1+"");
	}  
	public void insertarProducto(){
	if(existenciaS1==null){
		precioInt = Integer.parseInt(precio);
		precioInt = precioInt + 50;
		nuevoPrecio = Integer.toString(precioInt);
		//JOptionPane.showMessageDialog(null,"SERIA UN NUEVO PRODUCTO PARA LA SUCURSAL1 \nPRECIO DE FABRICA"+precio+"\nPRECIO PARA VENDER"+nuevoPrecio+"");}
		try{
			String query="INSERT INTO test VALUES("+codigo+",'"+nombre+"','"+desc+"','"+color+"','"+depto+"',"+unidades+","+nuevoPrecio+")";
  			stmt =conexion.prepareStatement(query);
  			int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"SE INSERTO UN NUEVO PRODUCTO A LA S1");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"OCURRIO UN ERRO AL INSERTAR A LA S1");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
	}else{
		JOptionPane.showMessageDialog(null,"YA ESTOY DISPONIBLEE PARA LA SUCURSAL1 \nSOLO AUMENTA MI EXISTENCIA");
		unidadesInt = Integer.parseInt(unidades);
		existenciaInt = Integer.parseInt(existenciaS1);		
		existenciaInt = existenciaInt + unidadesInt;  
		nuevaExistencia = Integer.toString(existenciaInt);
		//JOptionPane.showMessageDialog(null,"EXISTENCIA ACTUAL:"+existenciaS1+"\n ME PIDIERON:"+unidades+"\nQUEDARIA \nEXS + UNID="+nuevaExistencia+"");
		try{
			String query="UPDATE test SET existencia="+nuevaExistencia+" where codigo="+codigo;
  			stmt =conexion.prepareStatement(query);
  			int retorno = stmt.executeUpdate();
    		if(retorno == 1){JOptionPane.showMessageDialog(null,"SE ACTUALIZO LA EXISTENCIO");}
    		if(retorno == 0){JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR AL ACTUALIZAR LA EXISTENCIA");}
		}catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
		}	
	} 
     public static void main(String[] args) {
    	prueba p = new prueba();
     	p.obtenerCodigoDelPedido();
     	p.obtenerExistenciaDeS1();
     	p.insertarProducto();
    }
}