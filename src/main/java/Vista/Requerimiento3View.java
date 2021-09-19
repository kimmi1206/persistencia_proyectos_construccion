package Vista;

import java.util.ArrayList;
import java.sql.SQLException;

import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_3;

public class Requerimiento3View {

    public Requerimiento3View() throws SQLException {
    }

    public String[][] obtenerRegistros3() throws SQLException {
        //se obtiene lista de objetos del requerimiento 3
        ArrayList<Requerimiento_3> lista = VistaRequerimientos.controlador.consultarRequerimiento3();

        // se recorre la lista de objetos del requerimiento y 
        // se llena una matriz con cadenas de texto que se agregaran a la tabla
        String matriz[][] = new String [lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getProveedor();
            matriz[i][1] = lista.get(i).getPagado();
            matriz[i][2] = lista.get(i).getConstructora();
        }
        return matriz;
    }

    public static void requerimiento3Consola(){
        try {
           //Mostrar las compras No pagadas al proveedor JUMBO por constructoras
           ArrayList<Requerimiento_3> lista3 = (new ElControladorDeRequerimientos()).consultarRequerimiento3();
           for (Requerimiento_3 requery3 : lista3) {
               System.out.printf("%s %s %s %n", 
               requery3.getProveedor(),
               requery3.getPagado(),
               requery3.getConstructora());
           }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

}
