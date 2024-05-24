package br.maua.virustd.telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    String host, port, dbName, username, password;
    public ConnectDB() {
        host = "mysql-2fcbc876-towerdefense.k.aivencloud.com";
        port = "10284";
        dbName = "mydb";
        username = "avnadmin";
    }

    private void fetch() {
        // // JDBC allows to have nullable username and password
        // if (host == null || port == null || databaseName == null) {
        //   System.out.println("Host, port, database information is required");
        //   return;
        // }
        // Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            final Connection connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?sslmode=require", username, password);
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT version() AS version")) {
    
          while (resultSet.next()) {
            System.out.println("Version: " + resultSet.getString("version"));
          }
        } catch (SQLException e) {
          System.out.println("Connection failure.");
          e.printStackTrace();
        }
    }
}
