package spring.orm.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.DoctorSchedule;

@Repository
public class DocScheduleDaoImpl implements DocScheduleDao {

	@Autowired
	private SessionFactory sF;
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public DoctorSchedule getSchedulebyId(int id) {
		// TODO Auto-generated method stub
		// Session s = sF.getCurrentSession();
		return sF.getCurrentSession().find(DoctorSchedule.class, id);
	}


}
