-- QAP 4: PostgreSQL database and table setup. 

-- STEP 1:
-- Creating a database named qap4_healthcare first, then connect to it
-- and execute this script SEPARATELY to create database and table.
-- CREATE DATABASE qap4_healthcare;

-- Optional: if you need to delete the database, you can use the following command:
-- DROP DATABASE IF EXISTS qap4_healthcare;

-- Connect to the qap4_healthcare database before running the following table creation script.
CREATE TABLE IF NOT EXISTS patients (
    patient_id INTEGER PRIMARY KEY,
    patient_first_name VARCHAR(100) NOT NULL,
    patient_last_name VARCHAR(100) NOT NULL,
    patient_dob DATE NOT NULL
);

-- -- Optional verification query:
SELECT patient_id, patient_first_name, patient_last_name, patient_dob
FROM patients
ORDER BY patient_id;

