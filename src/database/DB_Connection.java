package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

    public  static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketmanagementsystemjava", "root", "");
            if (connection != null) {
                System.out.println("Status: DB " + "connected");
            }

        } catch (Exception e) {

        }
        return connection;
    }

    public  static  void  main(String [] args){
        getConnection();
    }
}

