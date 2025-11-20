package Day16_DB;

import java.sql.*;

public class JDBCPreparedStatement {
    public static void main(String[] args) throws Exception{
        int id=106;
        String name="Divya";
        String dept="Marketing";
        double salary=45000.00;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/payrolldb";
        String username="root";
        String password="India@2010";
        Connection con=DriverManager.getConnection(url,username,password);
        String query="INSERT INTO employees values (?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,dept);
        pst.setDouble(4,salary);

        int result=pst.executeUpdate();
        System.out.println(result+" rows is/are affected");

        con.close();

    }
}
