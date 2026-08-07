package com.qap4.repository;

import com.qap4.config.DatabaseConnection;
import com.qap4.model.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Uses JDBC to insert and retrieve Patient objects from PostgreSQL. */
public class PatientRepository {
    private static final String INSERT_SQL = """
            INSERT INTO patients
                (patient_id, patient_first_name, patient_last_name, patient_dob)
            VALUES (?, ?, ?, ?)
            """;

    private static final String SELECT_ALL_SQL = """
            SELECT patient_id, patient_first_name, patient_last_name, patient_dob
            FROM patients
            ORDER BY patient_id
            """;

    public void save(Patient patient) throws SQLException {
        try (Connection connection = DatabaseConnection.open();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setInt(1, patient.getPatientId());
            statement.setString(2, patient.getPatientFirstName());
            statement.setString(3, patient.getPatientLastName());
            statement.setDate(4, Date.valueOf(patient.getPatientDOB()));
            statement.executeUpdate();
        }
    }

    public List<Patient> findAll() throws SQLException {
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = DatabaseConnection.open();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                patients.add(new Patient(
                        resultSet.getInt("patient_id"),
                        resultSet.getString("patient_first_name"),
                        resultSet.getString("patient_last_name"),
                        resultSet.getDate("patient_dob").toLocalDate()
                ));
            }
        }

        return patients;
    }
}
