package spring.orm.dao;

import java.util.List;

import spring.orm.model.Doctor;
import spring.orm.model.output.DoctorOutPutModel;

public interface DoctorsDao {
	public List<Doctor> findAll();

	public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String days,
			String docfrom, String docto, String docavgtime, String docfee);

	Doctor getdoc(String Id);

	void adddoc(Doctor s);

	void updatedoc(Doctor s);

	Doctor getdoc(int Id);

	List<Doctor> getAllDoc();


	List<DoctorOutPutModel> getallDocSchedule();

	List<DoctorOutPutModel> getallDocScheduleBySpec(String spec);

	public DoctorOutPutModel getDocById(int id);

}
