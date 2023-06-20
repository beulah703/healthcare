package spring.orm.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.dao.AppointmentDao;
import spring.orm.model.entity.AppointmentEntity;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao apdao;

	public List<AppointmentEntity> getAllAppointments() {
		List<AppointmentEntity> alist = apdao.getAllAppointments();
		for (AppointmentEntity a : alist) {
			// Format date
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			a.setDateFormetted(dateFormat.format(a.getAppn_sch_date()));

			// Format time
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
			a.setTimeFormetted(timeFormat.format(a.getAppn_sch_date()));
		}
		return alist;
	}
}
