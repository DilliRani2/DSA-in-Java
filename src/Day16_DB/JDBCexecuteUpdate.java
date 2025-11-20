package Day16_DB;

//JDBC using Statement and executeUpdate()

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCexecuteUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//2. Register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3. Create the connection
        String url = "jdbc:mysql://localhost:3306/payrolldb";
        String username = "root";
        String password = "India@2010";
        Connection con = DriverManager.getConnection(url, username, password);
        //4. Create the statement => Statement, PreparedStatement
        Statement stmt = con.createStatement();
        //5. Execute the Query => execute(),executeQuery(),executeUpdate()
        String query = "insert into employees values (103,\"Abilash\",\"Sales\",37500.00)";
        int result = stmt.executeUpdate(query);
        //6. Process the result
        System.out.println(result + " row's is/are affected");
        //7. Close the connection
        con.close();
    }

}
