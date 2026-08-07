package com.qap4.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Opens PostgreSQL JDBC connections for the repository layer. */
public final class DatabaseConnection {
    private DatabaseConnection() {
    }

    public static Connection open() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException exception) {
            throw new SQLException(
                    "PostgreSQL JDBC driver was not found. Run the project with Maven so the dependency is loaded.",
                    exception
            );
        }

        return DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUser(),
                DatabaseConfig.getPassword()
        );
    }
}
