package spring.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.dao.UserDao;
import spring.orm.model.Appointmentmodel;
import spring.orm.model.DiagnosticBillModel;
import spring.orm.model.Doctor;
import spring.orm.model.Specialization;
import spring.orm.model.UserPass;
import spring.orm.model.testModel;

@Service
public class UserServices {
	@Autowired
	private UserDao udao;

	public UserPass getUser(String uname) {
		return udao.getUserDetails(uname);
	}

	public List<testModel> gettests() {
		return udao.gettests();
	}

	public boolean saveUser(String ottps, int time) {
		return udao.saveUser(ottps, time);
	}

	public void savetest(String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status) {
		udao.savetest(test_name, test_category, test_price, test_method, test_fromrange, test_torange, test_status);
	}

	public void updateUser(String lcpass, String uname) {
		udao.updateUser(lcpass, uname);
	}

	public void changeUser(String lcpass, String uname) {
		udao.changeUser(lcpass, uname);
	}

	public void registeruser(String name, String pass, String mail, String role) {
		udao.registeruser(name, pass, mail, role);

	}

	public List<Doctor> getdocspecdetails() {
		return udao.getdocspecdetails();

	}

	public List<Specialization> getpecdetails() {
		return udao.getpecdetails();

	}

	public void savedoc(String doc_name, String doc_qual, int spec_id, String doc_exp, byte[] doc_photo, int doc_cfee) {
		udao.savedoc(doc_name, doc_qual, spec_id, doc_exp, doc_photo, doc_cfee);
	}

	public List<DiagnosticBillModel> getdbilldetails() {
		// TODO Auto-generated method stub
		return udao.getdbilldetails();
	}

	public List<Appointmentmodel> getapppaymnets() {
		// TODO Auto-generated method stub
		return udao.getapppaymnets();
	}

	public testModel gettestbyid(int id) {
		return udao.gettestbyid(id);
	}

	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange) {
		udao.updatetest(test_id, test_name, test_category, test_price, test_method, test_fromrange, test_torange);

	}

	public void deltest(int test_id) {
		// TODO Auto-generated method stub
		udao.deltest(test_id);

	}



	

	public List<String> getTestCat() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer gettestprice(String test) {
		// TODO Auto-generated method stub
		return udao.gettestprice(test);
	}

	// public List<String> getTestCat() {
	// return udao.getTestCat();
	// }


	public List<Appointmentmodel> getspecPayments(String spec) {
		// TODO Auto-generated method stub
		return udao.getspecPayments(spec);

	}

	public List<Appointmentmodel> getspecdatewisepay(String spec, String dat, String date) {
		// TODO Auto-generated method stub
		return udao.getspecdatewisepay(spec, dat, date);
	}

	public List<Appointmentmodel> getdatewisepay(String dat, String date) {
		// TODO Auto-generated methsod stub
		return udao.getdatewisepay(dat, date);
	}

	public List<Appointmentmodel> getdocwisepay(int doc) {
		// TODO Auto-generated method stub
		return udao.getdocwisepay(doc);
	}

	public List<Appointmentmodel> getdocdatewisepay(int doc, String dat, String date) {
		// TODO Auto-generated method stub
		return udao.getdocdatewisepay(doc, dat, date);
	}


	public void bookTest(String id) {
		// TODO Auto-generated method stub
		udao.booktest(id);
	}

	public List<testModel> getcat() {
		// TODO Auto-generated method stub
		return udao.getcat();
	}

	public List<testModel> gettestbycat(String cat) {
		// TODO Auto-generated method stub
		return udao.gettestbycat(cat);
	}

}