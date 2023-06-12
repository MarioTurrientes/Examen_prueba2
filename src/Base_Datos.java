import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author mturr
 */
public class Base_Datos {
    
    //O. Para el objeto de la lista autoras:
    private Creardor c1;
    
    //O. Constructor con el objeto de la lista:
    public Base_Datos(Creardor c1) {
        this.c1 = c1;
    }
    
    //1. almacenará la conexión establecida con la base de datos.
    private Connection conn;
    
    
    //2. Constructor:
    Base_Datos() {
        
    }
    
    
    //----------------------------------------------------------------------------------------------------------------------------------
    
    
    //3. creamos un metodo para la conexion con la db:
    public Connection getConnection() {
        
        String url = "jdbc:mysql://192.168.1.58:3306/Autoras?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "";
        
        try {
            conn = DriverManager.getConnection(url,"root","");     // establecer la conexión 
            System.out.println("Conexión exitosa a la base de datos");
            
            // Obtener los datos de las autoras y agregarlos a la lista de Autora
            obtenerDatosAutoras();
            
        
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conn;  // 3.1. se retorna la conexión establecida y asi poder ser utilizada para otras partes del codigo.
        
    }
    
    
    //----------------------------------------------------------------------------------------------------------------------------------
    
    
    //4. Metodo para recoger los datos de la tabla:
    public void obtenerDatosAutoras() throws SQLException {
        
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM Autoras";
        ResultSet resultSet = statement.executeQuery(sql);
        

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String alias = resultSet.getString("alias");
            String fecha = resultSet.getString("fecha_nacimiento");
            int premios = resultSet.getInt("premios_recibidos");
            String pais = resultSet.getString("pais_residencia");
            String areaTrabajo = resultSet.getString("area_trabajo");

            Autora autora = new Autora(id, nombre, apellidos, alias, fecha, premios, pais, areaTrabajo);
            
            //en la lista la relleno con los objetos autoras:
            c1.rellenar_lista(autora);
            
        }
        
        // Imprimimos la lista de autoras
        c1.muestra_lista();

        //cerramos el statement y el resulset:
        resultSet.close();
        statement.close();
    }
}
