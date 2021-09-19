package reto4y5;

import java.sql.SQLException;

import Vista.*;

/**
 * Esta clase solo se debe usar para hacer pruebas locales,
 * no se debe subir en iMaster
 */
public class Principal {
    //se instancia Clase para llamar metodos no estáticos
    private static VistaRequerimientos requerimientos = new VistaRequerimientos();

    public static void main(String[] args) throws SQLException {

        //Interfaz Gráfica
        requerimientos.requerimientosVentana();

        //Consola
        /*
        System.out.println("Requerimiento 1");
        VistaRequerimientos.requerimiento1Consola();

        System.out.println("\nRequerimiento 2");
        VistaRequerimientos.requerimiento2Consola();

        System.out.println("\nRequerimiento 3");
        VistaRequerimientos.requerimiento3Consola();
        */
    }
}
