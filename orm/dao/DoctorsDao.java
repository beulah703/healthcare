package spring.orm.dao;

import java.util.List;

import spring.orm.model.Doctor;

public interface DoctorsDao {
	public List<Doctor> findAll();

	public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String days,
			String docfrom, String docto, String docavgtime, String docfee);
}
