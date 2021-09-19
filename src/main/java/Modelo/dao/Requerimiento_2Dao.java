package Modelo.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;

//Clase para conexión
import Util.JDBCUtilities;

import Modelo.vo.Requerimiento_2;

public class Requerimiento_2Dao {
    //Obtener los los lideres ellido con cargo de asesor o coordinador, y con salario menor o igual a 310000
    public ArrayList<Requerimiento_2> requerimiento2()  throws SQLException {

        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();
        Connection conexion = JDBCUtilities.getConnection();
        try {
            String consulta = "SELECT Nombre, Primer_Apellido, Ciudad_Residencia, Cargo, Salario "+
            "FROM Lider "+
            "WHERE (Cargo = 'Asesor' OR Cargo = 'Coordinador')"+
            "AND  Salario <= 310000 ";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Requerimiento_2 requerimiento_2 = new Requerimiento_2();

                requerimiento_2.setNombre(resultSet.getString("Nombre"));
                requerimiento_2.setPrimer_Apellido(resultSet.getString("Primer_Apellido"));
                requerimiento_2.setCiudad_Residencia(resultSet.getString("Ciudad_Residencia"));     
                requerimiento_2.setCargo(resultSet.getString("Cargo"));
                requerimiento_2.setSalario(resultSet.getInt("Salario"));

                respuesta.add(requerimiento_2);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error consultando: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        return respuesta;
    }

}
