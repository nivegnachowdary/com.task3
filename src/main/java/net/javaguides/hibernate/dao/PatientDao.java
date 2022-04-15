package net.javaguides.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.Patient;
import net.javaguides.hibernate.util.HibernateUtil;

public class PatientDao implements IPatientDao {

	// save Patient
	// getAll Patients
	// get Patient By Id
	// Update Patient
	// Delete Patient

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.javaguides.hibernate.dao.IPatientDao#savePatient(net.javaguides.hibernate
	 * .model.Patient)
	 */
	@Override
	public void savePatient(Patient patient) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save patient object
			session.save(patient);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.javaguides.hibernate.dao.IPatientDao#updatePatient(net.javaguides.
	 * hibernate.model.Patient)
	 */
	@Override
	public void updatePatient(Patient patient) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save patient object
			session.saveOrUpdate(patient);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.javaguides.hibernate.dao.IPatientDao#getPatientById(long)
	 */
	@Override
	public Patient getPatientById(long id) {
		Transaction transaction = null;
		Patient patient = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get patient object
			patient = session.get(Patient.class, id);
			// patient = session.load(Patient.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return patient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.javaguides.hibernate.dao.IPatientDao#getAllPatients()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {
		Transaction transaction = null;
		List<Patient> patients = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get patients
			patients = session.createQuery("from Patient").list();
			// patient = session.load(Patient.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return patients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.javaguides.hibernate.dao.IPatientDao#deletePatient(long)
	 */
	@Override
	public void deletePatient(long id) {
		Transaction transaction = null;
		Patient patient = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			patient = session.get(Patient.class, id);
			// get patient object
			session.delete(patient);
			// patient = session.load(Patient.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}