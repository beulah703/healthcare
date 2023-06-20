package spring.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.orm.dao.DiagnosticBillDao;
import spring.orm.model.DiagnosticBillModel;

public class DiagnosticBillServices {

	@Autowired
	private DiagnosticBillDao dbdao;

	public List<DiagnosticBillModel> getdbilldetails() {
		// TODO Auto-generated method stub
		return dbdao.getdbilldetails();
	}

	// public void booktestt(String name, String cat, int test, int price, String contact, String type) {
	// // TODO Auto-generated method stub
	// dbdao.booktestt(name, cat, test, price, contact, type);
	// }

}