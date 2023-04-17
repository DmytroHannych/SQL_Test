package org.example;

import org.h2.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class H2Repo implements AutoCloseable {

    private final Driver driver = new Driver();
    private Connection connection;
    private Statement statement;

    public H2Repo(String url, String admin, String password) throws SQLException {
     DriverManager.deregisterDriver(driver);
     connection = DriverManager.getConnection(url, admin, password);
     statement = connection.createStatement();
    }




    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }

    public boolean execute(String sql) throws SQLException {
        return statement.execute(sql);
    }
}
