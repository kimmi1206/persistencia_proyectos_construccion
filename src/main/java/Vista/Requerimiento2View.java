package Vista;

import java.util.ArrayList;
import java.sql.SQLException;

import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_2;

public class Requerimiento2View {

    public Requerimiento2View() {
    }

    public String[][] obtenerRegistros2() throws SQLException {
        //se obtiene lista de objetos del requerimiento 2
        ArrayList<Requerimiento_2> lista = VistaRequerimientos.controlador.consultarRequerimiento2();

        // se recorre la lista de objetos del requerimiento y 
        // se llena una matriz con cadenas de texto que se agregaran a la tabla
        String matriz[][] = new String [lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getNombre();
            matriz[i][1] = lista.get(i).getPrimer_Apellido();
            matriz[i][2] = lista.get(i).getCiudad_Residencia();
            matriz[i][3] = lista.get(i).getCargo();
            matriz[i][4] = String.valueOf(lista.get(i).getSalario());
        }
        return matriz;
    }

    public static void requerimiento2Consola(){
        
        try {
            //Mostrar los los lideres ellido con cargo de asesor o coordinador, y con salario menor o igual a 310000
            ArrayList<Requerimiento_2> lista2 = (new ElControladorDeRequerimientos()).consultarRequerimiento2();
            for (Requerimiento_2 requery2 : lista2) {
                System.out.printf("%s %s %s %s %d %n", 
                requery2.getNombre(),
                requery2.getPrimer_Apellido(),
                requery2.getCiudad_Residencia(),
                requery2.getCargo(),
                requery2.getSalario());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

}
