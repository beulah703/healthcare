package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.orm.model.entity.AppointmentEntity;

@Component
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	EntityManager em;

	@Override
	@Transactional
	public List<Object[]> fetchUpcomingAppointmentData() {

		String hql = "SELECT a.appn_id, d.name, p.patn_name, a.appn_sch_date " + "FROM Appointmentmodel a "
				+ "JOIN a.doctor d " + "JOIN a.pm p " + "WHERE a.appn_sch_date > :date";

		Query q = em.createQuery(hql);

		q.setParameter("date", "2023-06-05");

		List<Object[]> data = q.getResultList();

		for (Object[] x : data) {
			for (Object y : x) {
				System.out.println(y + " ");
			}
			System.out.println();
		}

		return data;
	}

	public List<Object[]> fetchBADDateWise(String from, String to) {
		String hql = "select a.appn_id, d.name, p.patn_name, a.appn_sch_date, a.appn_status "
				+ "from Appointmentmodel a " + "join a.doctor d" + "join a.pm p"
				+ "where date_trunc('day', a.appn_sch_date) between :startDate and :endDate";

		Query q = em.createQuery(hql);

		q.setParameter("startDate", "2023-06-05");

		q.setParameter("endDate", "2023-06-14");

		List<Object[]> data = q.getResultList();

		for (Object[] obj : data) {

			for (Object x : obj) {
				System.out.println(x + " ");
			}
			System.out.println(" ");
		}

		return null;
	}

	public List<Object[]> fetchBADDateSpecWise(String from, String to, String spec) {
		return null;
	}

	public List<Object[]> fetchBADDateSpecActWise(String from, String to, String spec, String act) {
		return null;

	}

	public List<Object[]> fetchBADDateSpecActDocWise(String from, String to, String spec, String act, String doc) {
		return null;

	}

	@Override
	@Transactional
	public List<AppointmentEntity> getAllAppointments() {
		// TODO Auto-generated method stub
		return em.createQuery("select a from AppointmentEntity a", AppointmentEntity.class).getResultList();
	}

}