import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//CREAMOS NUESTRA CLASE "Ventana" Y LA HACEMOS QUE HEREDE LOS ATRIBUTOS
//Y METODOS DE LA CLASE "Frame"
public class meenu extends Frame{
   //CREAMOS UN OBJETO DE DATOS "MenuBar" PARA CREAR NUESTRA BARRA 
   //QUE CONTENDRA LOS MENUS
   MenuBar barra = new MenuBar();//LA DECLARAMOS E INSTANCIAMOS.

   //CREAMOS LOS MENUS QUE ESTARAN DENTRO DE LA BARRA DE MENUS QUE 
   //ACABAMOS DE CREAR
   Menu logistica = new Menu("Logistica");
   Menu clientes = new Menu("Clientes");
   Menu sucursal1=new Menu("Sucursal 1");
   Menu sucursal2=new Menu("Sucursal 2");
   Menu salir=new Menu("Salir");

   //PARA CREAR UN SUBMENU, BASTA CON INTRODUCIR EN UN MENU, OTRO MENU.
   //CREAMOS EL MENU QUE SERVIRA DE SUBMENU EN NUESTRO PROGRAMA
  
   //CREAMOS EL CONSTRUCTOR DE NUESTRA CLASE
   public meenu(){
      super("Menu Principal"); //LE DAMOS UN NOMBRE A NUESTRA VENTANA
      this.setSize(350, 350); //ESTABLECEMOS EL TAMAÑO DE LA VENTANA

      //SELECCIONAMOS LA BARRA DE MENUS
      setMenuBar(barra);

      //A LA BARRA LE AGREGAMOS LOS MENUS.
      barra.add(logistica);
      barra.add(clientes);
      barra.add(sucursal1);
      barra.add(sucursal2);
      barra.add(salir);
      
      //AHORA A LOS MENUS LE AGREGAMOS LAS OPCIONES Y EL SUBMENU
      
      //PARA AGREGAR UN SEPARADOR ENTRE VARIAS OPCIONES DEL MENU, 
      //HACEMOS LO SIGUIENTE
     

      //AGREGAMOS UNA ULTIMA OPCION A NUESTRO MENU programa
     

      //AHORA VAMOS A AGREGARLE OPCIONES AL MENU DE AYUDA
      logistica.add("Prendas");
      clientes.add("Facturas");
      clientes.add("Pedidos");
      sucursal1.add("Prendas");
      sucursal1.add("Cuentas");
      sucursal1.add("Ventas");
      sucursal2.add("Prendas");
      sucursal2.add("Cuentas");
      sucursal2.add("Ventas");
   }//FIN DEL CONSTRUCTOR DE LA CLASE Ventana

   //PROCEDIMIENTO PRINCIPAL DEL PROGRAMA
   public static void main(String g[]){
      meenu prog = new meenu();//Instanciamos la clase que creamos
      prog.show();//Mostramos esa ventana
   }//FIN DEL PROCEDIMIENTO PRINCIPAL

   //PARA PODER CERRAR LA VENTANA
   public boolean handleEvent(Event evt){
      if (evt.id == Event.WINDOW_DESTROY)
         System.exit(0);
         return super.handleEvent(evt);
   }
}//FIN DE LA CLASE Ventana
//FIN

