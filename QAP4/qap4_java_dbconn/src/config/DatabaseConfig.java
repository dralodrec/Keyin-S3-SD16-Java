package com.qap4.config;

/** PostgreSQL connection settings, configurable with environment variables. */
public final class DatabaseConfig {
    private DatabaseConfig() {
    }

    public static String getUrl() {
        return System.getenv().getOrDefault(
                "QAP4_DB_URL",
                "jdbc:postgresql://localhost:5432/qap4_healthcare"
        );
    }

    public static String getUser() {
        return System.getenv().getOrDefault("QAP4_DB_USER", "postgres");
    }

    public static String getPassword() {
        return System.getenv().getOrDefault("QAP4_DB_PASSWORD", "postgres");
    }
}
