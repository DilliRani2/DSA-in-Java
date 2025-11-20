package Day16_DB;

import java.sql.*;

/*  JDBC Using Statement and executeQuery()
1. Import the packages
2. Load and Register the driver
3. Create the connection
4. Create the statement
5. Execute the query
6. Process the result
7. Close the connection
 */

public class JDBC {
    public static void main(String[] args)throws ClassNotFoundException, SQLException{
        //2. Register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3. Create the connection
        String url="jdbc:mysql://localhost:3306/ payrolldb";
        String username="root";
        String password="Mysql@123";
        Connection con=DriverManager.getConnection(url,username,password);
        //4. Create the statement => Statement, PreparedStatement
        Statement stmt=con.createStatement();
        //5. Execute the Query => execute(),executeQuery(),executeUpdate()
        String query="select * from employees";
        ResultSet rs=stmt.executeQuery(query);

        //6. Process the result
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "->" + rs.getString(2) + "->" + rs.getString(3) + "->" + rs.getDouble(4));
        }
        //7. Close the connection
        con.close();

    }
}
