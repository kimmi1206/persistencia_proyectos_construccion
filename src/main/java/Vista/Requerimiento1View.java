package Vista;

import java.util.ArrayList;
import java.sql.SQLException;

import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_1;

public class Requerimiento1View {

    public Requerimiento1View() {
        
    }

    public String[][] obtenerRegistros1() throws SQLException {
        //se obtiene lista de objetos del requerimiento 1
        ArrayList<Requerimiento_1> lista = VistaRequerimientos.controlador.consultarRequerimiento1();
        
        // se recorre la lista de objetos del requerimiento y 
        // se llena una matriz de cadenas de texto que se agregaran a la tabla
        String matriz[][] = new String [lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = String.valueOf(lista.get(i).getID_Proyecto());
            matriz[i][1] = lista.get(i).getCiudad();
            matriz[i][2] = lista.get(i).getBanco_Vinculado();
            matriz[i][3] = lista.get(i).getConstructora();
        }
        return matriz;
    }
  
    public static void requerimiento1Consola(){
        
        try {
            //Mostrar los proyectos realizado en la ciudad de Bogota
            ArrayList<Requerimiento_1> lista = (new ElControladorDeRequerimientos()).consultarRequerimiento1();
            for (Requerimiento_1 requery1 : lista) {
                System.out.printf("%d %s %s %s %n", 
                requery1.getID_Proyecto(),
                requery1.getCiudad(),
                requery1.getBanco_Vinculado(),
                requery1.getConstructora());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }
}
