package spring.orm.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import spring.orm.model.Appointmentmodel;
import spring.orm.model.PatientMedicalProfile;
import spring.orm.model.testModel;
import spring.orm.model.output.patientPrescriptionOutputmodel;

@Repository
public class PatientDaoImpl implements PatientDao {
	@PersistenceContext
	private EntityManager em;
	LocalDate currentDate = LocalDate.now();
	String d1 = currentDate.toString();

	@Override
	@Transactional
	public List<Object> getapptestcards() {

		List<Appointmentmodel> todayAppnCount = em
				.createQuery("select a from Appointmentmodel a where a.appn_sch_date =:d", Appointmentmodel.class)
				.setParameter("d", d1).getResultList();
		// return s.get(Specialization.class, Id);
		int app = todayAppnCount.size();

		List<testModel> tm = em.createQuery("select t from testModel t ", testModel.class).getResultList();
		int testsCount = tm.size();

		List<Object> patientDashboardCards = new ArrayList<>();

		List<Object> AppointTable = em.createQuery(
				"select a.appn_id,d.name,a.appn_sch_date,a.appn_status from Appointmentmodel a ,Doctor d JOIN a.doctor d where a.appn_patn_id=:p")
				.setParameter("p", 1).getResultList();
		List<Object> TodayTestsTable = em.createQuery(
				"select d.dgbl_test_id,t.test_name from Diagnostictestbill d , testModel t,DiagnosticBillModel d1 where d.dgbl_id=d1.dgbl_id and d.dgbl_test_id=t.test_id and d1.dgbl_date=:d ")
				.setParameter("d", d1).getResultList();

		patientDashboardCards.add(app);
		patientDashboardCards.add(testsCount);
		patientDashboardCards.add(AppointTable.get(0));
		patientDashboardCards.add(AppointTable.get(1));
		patientDashboardCards.add(AppointTable.get(2));
		patientDashboardCards.add(AppointTable.get(3));
		patientDashboardCards.add(TodayTestsTable.get(0));
		patientDashboardCards.add(TodayTestsTable.get(1));

		return patientDashboardCards;
	}

	@Override
	@Transactional
	public List<PatientMedicalProfile> getParaGroup() {

		List<PatientMedicalProfile> lp = em.createQuery("select pp.patn_value ,a.appn_sch_date "
				+ "from PatientMedicalProfile pp,Appointmentmodel a where pp.patn_id=a.appn_patn_id and pp.patn_id=:p ")
				.setParameter("p", 1)

				.getResultList();
		return lp;
	}

	@Transactional
	@Override
	public List<patientPrescriptionOutputmodel> getPrescription() {
		String d = "2023-06-05";

		// TODO Auto-generated method stub
		List<patientPrescriptionOutputmodel> lp = em.createQuery(
				"select pm.lastConsultationDate ,pm.prescriptionImage ,pm.nextAppointmentDate,d.name,d.comfee "
						+ "from PatientProfileUpdate pm,Doctor d,Appointmentmodel a where pm.patientId=a.appn_patn_id  and pm.lastConsultationDate=:d "
						+ "and a.doctor=d.id " + "and pm.patientId=:p ")
				.setParameter("d", d).setParameter("p", 1)

				.getResultList();
		return lp;
	}

}
