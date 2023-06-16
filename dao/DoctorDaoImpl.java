package spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.Doctor;
import spring.orm.model.output.DoctorOutPutModel;

@Repository
public class DoctorDaoImpl implements DoctorsDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private SessionFactory sF;

	@Autowired
	private DocScheduleDao docschedule;

	@Override
	@Transactional
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		List<Doctor> d = sF.getCurrentSession().createQuery("select d from Doctor d").getResultList();
		return d;
	}

	@Transactional
	public List<Doctor> getAllDoc() {
		// TODO Auto-generated method stub

		return em.createQuery("select d from Doctor d", Doctor.class).getResultList();
	}

	@Transactional
	public List<Doctor> getAllDocSpec(String Spec) {
		// TODO Auto-generated method stub

		return sF.getCurrentSession()
				.createQuery("select d from Doctor d where d.specialization.id=: spec", Doctor.class)
				.setParameter("spec", Spec).getResultList();

	}

	@Transactional
	public Doctor getdoc(int Id) {
		// TODO Auto-generated method stub
		Session s = sF.getCurrentSession();
		return s.get(Doctor.class, Id);
	}

	@Transactional
	public void adddoc(Doctor s) {
		// TODO Auto-generated method stub
		Session se = sF.getCurrentSession();
		se.save(s);
	}

	@Transactional
	public void updatedoc(Doctor s) {
		// TODO Auto-generated method stub
		Session se = sF.getCurrentSession();
		System.out.println("In Update Spec");
		se.update(s);

	}

	@Override
	public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String days,
			String docfrom, String docto, String docavgtime, String docfee) {
		// TODO Auto-generated method stub

	}

	@Override
	public Doctor getdoc(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorOutPutModel> getallDocSchedule() {
		// TODO Auto-generated method stub
		List<DoctorOutPutModel> dout = new ArrayList<>();
		for (Doctor d : getAllDoc()) {
			dout.add(new DoctorOutPutModel(d, docschedule.getSchedulebyId(d.getId())));
		}
		return dout;

	}

	@Transactional
	@Override
	public List<DoctorOutPutModel> getallDocScheduleBySpec(String spec) {
		// TODO Auto-generated method stub
		List<DoctorOutPutModel> dout = new ArrayList<>();
		for (Doctor d : getAllDocSpec(spec)) {
			dout.add(new DoctorOutPutModel(d, docschedule.getSchedulebyId(d.getId())));
		}
		return dout;
	}

	@Override
	@Transactional
	public DoctorOutPutModel getDocById(int id) {
		// TODO Auto-generated method stub
		DoctorOutPutModel d = new DoctorOutPutModel();
		d.setD(getdoc(id));
		d.setDocsche(docschedule.getSchedulebyId(d.getD().getId()));

		return d;
	}

	// public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String
	// days,
	// String docfrom, String docto, String docavgtime, String docfee) {
	// // TODO Auto-generated method stub
	// StoredProcedureQuery query = em.createStoredProcedureQuery("insert_doctors");
	// System.out.println("called");
	// query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
	//
	// query.setParameter(1, docname);
	// query.setParameter(2, docqual);
	// query.setParameter(3, docspec);
	// query.setParameter(4, docexp);
	// query.setParameter(5, docphoto);
	// query.setParameter(6, docfee);
	//
	// query.execute();
	// System.out.println("inserted");
	//
	// StoredProcedureQuery query2 = em.createStoredProcedureQuery("insert_doctorSchedule");
	// query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	// query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
	//
	// query.setParameter(1, days);
	// query.setParameter(2, docfrom);
	// query.setParameter(3, docto);
	// query.setParameter(4, docavgtime);
	//
	// }

}
