package spring.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.dao.DoctorsDao;
import spring.orm.model.Doctor;

@Service
public class DoctorServices {
	@Autowired
	private DoctorsDao docdao;

	public List<Doctor> getallDoc() {
		return docdao.findAll();
	}

	public void storedata(String docname, String docspec, String docqual, String docexp, String docphoto, String days,
			String docfrom, String docto, String docavgtime, String docfee) {
		// TODO Auto-generated method stub
		docdao.storedata(docname, docspec, docqual, docexp, docphoto, days, docfrom, docto, docavgtime, docfee);
	}

}
