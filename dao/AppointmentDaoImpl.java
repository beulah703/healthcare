package spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.entity.AppointmentEntity;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	private SessionFactory sF;

	@Override
	@Transactional
	public List<AppointmentEntity> getAllAppointments() {
		// TODO Auto-generated method stub
		return sF.getCurrentSession().createQuery("select a from AppointmentEntity a", AppointmentEntity.class)
				.getResultList();
	}

}
