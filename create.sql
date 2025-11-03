
-- Dentists
DROP TABLE IF EXISTS Dentist;

CREATE TABLE Dentist (
    denSec INT AUTO_INCREMENT PRIMARY KEY,
    denRegistration INT NOT NULL,
    denName VARCHAR(100) NOT NULL,
    denLastName VARCHAR(100) NOT NULL
);

-- Address
DROP TABLE IF EXISTS Address;

CREATE TABLE Address (
    addSec INT AUTO_INCREMENT PRIMARY KEY,
    addStreet VARCHAR(100) NOT NULL,
    addNumber INT NOT NULL,
    addLocation VARCHAR(100) NOT NULL,
    addProvince VARCHAR(100) NOT NULL
);

-- Patients
DROP TABLE IF EXISTS Patient;

CREATE TABLE Patient (
    patSec INT AUTO_INCREMENT PRIMARY KEY,
    patName VARCHAR(100) NOT NULL,
    patLastName VARCHAR(100) NOT NULL,
    patIdentity INT NOT NULL,
    patAdmission DATE NOT NULL,
    patEmail VARCHAR(100) NULL,
    addSec INT NOT NULL
);

-- Insert DB temporal data

INSERT INTO Address(addStreet, addNumber, addLocation, addProvince)
VALUES('Real de Minas', 62, 'Manchester', 'England'),
        ('Mutis', 53, 'London', 'England');

INSERT INTO Patient(patName, patLastName, patIdentity, patAdmission, patEmail, addSec)
VALUES('Christopher', 'Diaz', 6354798, '2025-11-02', 'Chris@Oracle.dev', 1);

INSERT INTO Dentist(denRegistration, denName, denLastName)
VALUES(503680, 'Felipe', 'Gomez');