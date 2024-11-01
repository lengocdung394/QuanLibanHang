
package connectBD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

    public static Connection con = null;
    private static final ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=BreezeStore";
        String user = "sa";
        String password = "D124321394#khoi";
        con = DriverManager.getConnection(url, user, password);

    }

    

    public static Connection getCon() {
        return con;
    }

}
