package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.IPatientDao;
import net.javaguides.hibernate.dao.PatientDao;
import net.javaguides.hibernate.model.Patient;

public class App {

	public static void main(String[] args) {

		IPatientDao patientDao = new PatientDao();

		Patient patient = new Patient("Ram", "Orthopedics", "ram@gmail.com");
		patientDao.savePatient(patient);

		Patient patient1 = new Patient("Ashdin", "Pediatrics", "latha@gmail.com");
		patientDao.savePatient(patient1);

	}
}