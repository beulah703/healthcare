package spring.orm.dao;

import java.util.List;

import spring.orm.model.entity.AppointmentEntity;

public interface AppointmentDao {
	public List<AppointmentEntity> getAllAppointments();

}
