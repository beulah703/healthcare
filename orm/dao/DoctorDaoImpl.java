package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.orm.model.Doctor;

@Component
public class DoctorDaoImpl implements DoctorsDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		List<Doctor> d = em.createQuery("select d from Doctor d").getResultList();
		return d;
	}

	@Override
	public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String days,
			String docfrom, String docto, String docavgtime, String docfee) {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = em.createStoredProcedureQuery("insert_doctors");
		System.out.println("called");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);

		query.setParameter(1, docname);
		query.setParameter(2, docqual);
		query.setParameter(3, docspec);
		query.setParameter(4, docexp);
		query.setParameter(5, docphoto);
		query.setParameter(6, docfee);

		query.execute();
		System.out.println("inserted");

		StoredProcedureQuery query2 = em.createStoredProcedureQuery("insert_doctorSchedule");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

		query.setParameter(1, days);
		query.setParameter(2, docfrom);
		query.setParameter(3, docto);
		query.setParameter(4, docavgtime);
	}

}
