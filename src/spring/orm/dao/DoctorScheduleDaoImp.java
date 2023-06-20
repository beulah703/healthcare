package spring.orm.dao;

import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.orm.model.DoctorSchedule;
import spring.orm.model.input.DoctorInput;
import spring.orm.util.UtilManager;

@Component
public class DoctorScheduleDaoImp implements DoctorScheduleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void addDoctorSchedule(DoctorInput d, int id) {
		// TODO Auto-generated method stub
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm");
		DoctorSchedule sch = new DoctorSchedule(id, UtilManager.converWeekdays(d.getWeekday()),
				d.getDocfrom().format(format), d.getDocto().format(format), d.getDocavgtime());
		em.persist(sch);

	}

}
