package spring.orm.dao;

import java.util.List;

import spring.orm.model.Appointmentmodel;
import spring.orm.model.Doctor;
import spring.orm.model.Specialization;
import spring.orm.model.UserPass;
import spring.orm.model.diagnosticBillModel;
import spring.orm.model.testModel;

public interface UserDao {
	public UserPass getUserDetails(String s);

	public boolean saveUser(String ottps, int time);

	public void updateUser(String lcpass, String uname);

	public void changeUser(String lcpass, String uname);

	public void registeruser(String name, String pass, String mail, String role);

	public List<Doctor> getdocspecdetails();

	public void savedoc(String doc_name, String doc_qual, int spec_id, String doc_exp, byte[] doc_photo, int doc_cfee);

	public void savetest(String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status);

	public List<testModel> gettests();

	public List<Appointmentmodel> getapppaymnets();

	public List<Specialization> getpecdetails();

	public List<diagnosticBillModel> getdbilldetails();

	public testModel gettestbyid(int id);

	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange);

	public void deltest(int test_id);


	public void booktest(String id);

	public List<testModel> getcat();

	public List<testModel> gettestbycat(String cat);

	public List<String> getTestCat();

	public Integer gettestprice(String test);

	public List<Appointmentmodel> getspecPayments(String spec);

	public List<Appointmentmodel> getspecdatewisepay(String spec, String date, String date1);

	public List<Appointmentmodel> getdatewisepay(String date, String date2);

	public List<Appointmentmodel> getdocwisepay(int doc);

	public List<Appointmentmodel> getdocdatewisepay(int doc, String dat, String date);

	//public List<Integer> getapptestcards();

	public List<Object> getapptestcards();

	


}