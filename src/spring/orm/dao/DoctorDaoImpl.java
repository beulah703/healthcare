package spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.orm.model.Doctor;
import spring.orm.model.entity.DoctorTemp;
import spring.orm.model.input.DoctorInput;
import spring.orm.model.output.DoctorOutPutModel;

@Repository
public class DoctorDaoImpl implements DoctorsDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private DocScheduleDao docschedule;

	@Override
	@Transactional
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		List<Doctor> d = em.createQuery("select d from Doctor d").getResultList();
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

		return em.createQuery("select d from Doctor d where d.specialization.id=: spec", Doctor.class)
				.setParameter("spec", Spec).getResultList();

	}

	@Transactional
	public Doctor getdoc(int Id) {
		// TODO Auto-generated method stub

		return em.find(Doctor.class, Id);
	}

	@Transactional
	public void adddoc(Doctor s) {
		// TODO Auto-generated method stub

		em.persist(s);
	}

	@Transactional
	public void updatedoc(Doctor s) {
		// TODO Auto-generated method stub

		System.out.println("In Update Spec");
		em.merge(s);

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
	@Transactional
	public List<DoctorOutPutModel> getallDocSchedule() {
		// TODO Auto-generated method stub
		List<DoctorOutPutModel> dout = new ArrayList<>();
		for (DoctorTemp d : em.createQuery("select d from DoctorTemp d", DoctorTemp.class).getResultList()) {
			dout.add(new DoctorOutPutModel(d, docschedule.getSchedulebyId(d.getDoctId())));
		}
		return dout;

	}

	@Transactional
	@Override
	public List<DoctorOutPutModel> getallDocScheduleBySpec(String spec) {
		// TODO Auto-generated method stub
		List<DoctorOutPutModel> dout = new ArrayList<>();
		for (DoctorTemp d : em.createQuery("select d from DoctorTemp d", DoctorTemp.class).getResultList()) {
			System.out.println(d);
			System.out.println(docschedule.getSchedulebyId(d.getDoctId()));
			dout.add(new DoctorOutPutModel(d, docschedule.getSchedulebyId(d.getDoctId())));
		}
		return dout;
	}

	@Override
	@Transactional
	public DoctorOutPutModel getDocById(int id) {
		// TODO Auto-generated method stub
		DoctorOutPutModel d = new DoctorOutPutModel();
		d.setD(em.find(DoctorTemp.class, id));
		d.setDocsche(docschedule.getSchedulebyId(d.getDoctId()));

		return d;
	}

	@Override
	@Transactional
	public void updatedoc(DoctorInput d, CommonsMultipartFile docphoto) {
		// TODO Auto-generated method stub

	}

}
