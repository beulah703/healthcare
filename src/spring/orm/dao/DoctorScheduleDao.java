package spring.orm.dao;

import spring.orm.model.input.DoctorInput;

public interface DoctorScheduleDao {
	
	public void addDoctorSchedule(DoctorInput d,int docid);

}
