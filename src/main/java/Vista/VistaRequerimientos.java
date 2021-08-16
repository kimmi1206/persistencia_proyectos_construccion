package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import Controlador.ElControladorDeRequerimientos;

public class VistaRequerimientos extends JFrame {

    public static final ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();

    private static Requerimiento1View requerimient1Vista;
    private static Requerimiento2View requerimient2Vista;
    private static Requerimiento3View requerimient3Vista;

    private BorderLayout layout;
    // private JButton consultareq1, consultareq2, consultareq3;
    private JLabel MensajeReq, MensajeReq2, MensajeReq3, MensajeSeparador1, MensajeSeparador2, MensajeAutor;
    private String[] columnasRequerimiento;
    private String matriz[][];
    private JTable tabla1, tabla2, tabla3;
    private JScrollPane scrollReq1, scrollReq2, scrollReq3;
    private JPanel panel;
    private DefaultTableModel tableModel;

    public VistaRequerimientos(){
        
    }

    public static void requerimiento1Consola(){
        
        try {
            //Mostrar los proyectos realizado en la ciudad de Bogota
            Requerimiento1View.requerimiento1Consola();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public void requerimientosVentana() {
        initUI();
    }

    private void initUI(){
        
        try {

            // Se inicializan variables y objetos
            panel = new JPanel();
            layout = new BorderLayout();

            // Se crean etiquetas de texto para presentacion en ventana
            MensajeAutor = new JLabel("KHEINER IVAN MURILLO MOSQUERA  ----  Reto 5, GRUPO 31  ----  MisionTIC2022, CICLO 2");
            MensajeReq = new JLabel("                     REQUERIMIENTO 1                              ");
            MensajeReq2 = new JLabel("                    REQUERIMIENTO 2                                ");
            MensajeReq3 = new JLabel("                          REQUERIMIENTO 3                                        ");
            MensajeSeparador1 = new JLabel("..................................................................................");
            MensajeSeparador2 = new JLabel("..................................................................................");

            // Se define el diseño layout
            setLayout(layout);
       
            // Se crean y llenan las tablas
            tabla1 = new JTable();
            tabla2 = new JTable();
            tabla3 = new JTable();
            llenarTablas();

            // se agrega la tabla al panel de desplazamiento
            scrollReq1 = new JScrollPane(tabla1);
            scrollReq2 = new JScrollPane(tabla2);
            scrollReq3 = new JScrollPane(tabla3);

            // se agregan los elementos al panel principal
            panel.add(scrollReq1);
            panel.add(scrollReq2);
            panel.add(scrollReq3);
            panel.add(MensajeReq);
            panel.add(MensajeSeparador1);
            panel.add(MensajeReq2);
            panel.add(MensajeSeparador2);
            panel.add(MensajeReq3);
            panel.add(MensajeAutor);
        
            add(panel);

            // se habilita el JFrame para poder ser visualizado en la ventana
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1440, 900);
            setLocationRelativeTo(null); // ubica la ventana en el centro
            setVisible(true);

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public void llenarTablas() {
        try {
                //REQUERIMIENTO 1
                // Se obtiene la matriz con el resultado de la consulta
                requerimient1Vista = new Requerimiento1View();
                matriz = requerimient1Vista.obtenerRegistros1();

                // se obtiene el Modelo de la tabla para su modificacion
                tableModel = new DefaultTableModel();
                tableModel = (DefaultTableModel) tabla1.getModel();
                //tableModel.setRowCount(0);
                // Se generan las columnas de la tabla
                columnasRequerimiento = new String[] { "ID_Proyecto", "Ciudad", "Banco_Vinculado", "Constructora" };
                for (int i = 0; i < columnasRequerimiento.length; i++) {
                    tableModel.addColumn(columnasRequerimiento[i]);
                }

                // se agregan las filas a la tabla
                for (int i = 0; i < matriz.length; i++) {
                    // se recorre el arreglo multidimensional que contiene los registros del
                    // requerimiento y
                    // se agregan las filas a la tabla
                    tableModel.addRow(matriz[i]);
                }


                //REQUERIMIENTO 2
                System.err.println("boton2");
                // Se obtiene la matriz con el resultado de la consulta
                requerimient2Vista = new Requerimiento2View();
                matriz = requerimient2Vista.obtenerRegistros2();

                // se obtiene el Modelo de la tabla para su modificacion
                tableModel = new DefaultTableModel();
                tableModel = (DefaultTableModel)tabla2.getModel();

                // Se generan las columnas de la tabla
                columnasRequerimiento = new String[] { "Nombre", "Primer_Apellido", "Ciudad_Residencia", "Cargo", "Salario" };
                for (int i = 0; i < columnasRequerimiento.length; i++) {
                    tableModel.addColumn(columnasRequerimiento[i]);
                }

                // se agregan las filas a la tabla
                for (int i = 0; i < matriz.length; i++) {
                    // se recorre el arreglo multidimensional que contiene los registros del
                    // requerimiento y
                    // se agregan las filas a la tabla
                    tableModel.addRow(matriz[i]);
                }


                //REQUERIMIENTO 3
                // Se obtiene la matriz con el resultado de la consulta
                requerimient3Vista = new Requerimiento3View();
                matriz = requerimient3Vista.obtenerRegistros3();

                // se obtiene el Modelo de la tabla para su modificacion
                tableModel = new DefaultTableModel();
                tableModel = (DefaultTableModel)tabla3.getModel();

                // Se generan las columnas de la tabla
                columnasRequerimiento = new String[] {"Proveedor", "Pagado", "Constructora"};
                for (int i = 0; i < columnasRequerimiento.length; i++) {
                    tableModel.addColumn(columnasRequerimiento[i]);
                }

                // se agregan las filas a la tabla
                for (int i = 0; i < matriz.length; i++) {
                    // se recorre el arreglo multidimensional que contiene los registros del
                    // requerimiento y
                    // se agregan las filas a la tabla
                    tableModel.addRow(matriz[i]);
                }
            
        } catch (Exception e) {
            MensajeReq.setText(e.getMessage());
        }
    }
}
