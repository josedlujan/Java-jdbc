import java.awt.image.DirectColorModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    protected static final String MYSQL_DB = "jdbc:mysql://localhost:3306/myeddb";
    protected static final String MYSQL_USER = "jose";
    protected static final String MYSQL_PASSWORD = "null";

    protected static final String ORACLE_DB = "x";
    protected static final String ORACLE_USER = "x";
    protected static final String ORACLE_PASSWORD =  "x";

    protected static final String SQLSERVER_DB = "y";
    protected static final String SQLSERVER_USER = "y";
    protected static final String SQLSERVER_PASSWORD = "y";


    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType){
            case MYSQLDB:
                return DriverManager.getConnection(MYSQL_DB,MYSQL_USER,MYSQL_PASSWORD);
            case ORACLEDB:
                return DriverManager.getConnection(ORACLE_DB,ORACLE_USER,ORACLE_PASSWORD);
            case SQLSEVER:
                return DriverManager.getConnection(SQLSERVER_DB,SQLSERVER_USER,SQLSERVER_PASSWORD);
            default:
                return null;
        }

    }

    public static void processException(SQLException e){
        System.err.println("Error "+ e.getMessage());
        System.err.println("Code " + e.getErrorCode());
        System.err.println("SQL state" + e.getSQLState());
    }
}
