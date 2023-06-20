package spring.orm.dao;

import java.util.List;

import spring.orm.model.PatientMedicalProfile;
import spring.orm.model.output.patientPrescriptionOutputmodel;

public interface PatientDao {
	public List<Object> getapptestcards();

	public List<PatientMedicalProfile> getParaGroup();

	public List<patientPrescriptionOutputmodel> getPrescription();
}
