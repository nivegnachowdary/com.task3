package net.javaguides.hibernate.dao;

import java.util.List;

import net.javaguides.hibernate.model.Patient;

public interface IPatientDao {

	void savePatient(Patient patient);

	void updatePatient(Patient patient);

	Patient getPatientById(long id);

	List<Patient> getAllPatients();

	void deletePatient(long id);

}