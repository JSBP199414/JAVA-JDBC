package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?user=root&password=admin&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "admin";
    
    //Pool de conexiones
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Tamaño de conexiones
            dataSource.setInitialSize(5);
        }
        return dataSource;
    }
    //Metodo Connection (Conexion a la base de datos)
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    //Metodos para cerrar los objetos.
    //Metodo ResultSet para mostrar el resultado de Statement.
    public static void close(ResultSet rs) throws SQLException{
    rs.close();
    }
    //Metodo Statemnet instrucciones de la interface de la base de datos que queremos ejecutar.
    public static void close(Statement stmt) throws SQLException{
    stmt.close();
    }
    //Metodo PreparedStatemnet instrucciones de la interface de la base de datos que queremos ejecutar.
    public static void close(PreparedStatement stmt) throws SQLException{
    stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
    conn.close();
    }
}
