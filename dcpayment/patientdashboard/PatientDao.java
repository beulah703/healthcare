package spring.orm.dao;

import java.util.List;

import spring.orm.model.PatientProfileUpdate;
import spring.orm.model.outputModel.PatientMedicalProfile;
import spring.orm.model.outputModel.patientPrescriptionOutputmodel;


public interface PatientDao {
	public List<Object> getapptestcards();

	public List<PatientMedicalProfile> getParaGroup();

	public List<patientPrescriptionOutputmodel> getPrescription();
}
