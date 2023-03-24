import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection connection;
    private static final String url="jdbc:mysql://localhost:3306/javacrud";
    private static final String user="root";
    private static final String password="";

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("Success");
        }
        catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(){
        try {
            if (connection != null) {
                connection.close();

            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
