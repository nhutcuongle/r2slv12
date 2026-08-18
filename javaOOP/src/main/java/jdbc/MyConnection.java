package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "123456");

            if (conn != null) {
                System.out.println("Successful");
            } else {
                System.out.println("Unsuccessful");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
    }
}