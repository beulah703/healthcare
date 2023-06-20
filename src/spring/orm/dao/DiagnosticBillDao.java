package spring.orm.dao;

import java.util.List;
import java.util.Map;

import spring.orm.model.DiagnosticBillModel;
import spring.orm.model.input.BillInputModel;

public interface DiagnosticBillDao {
	public List<DiagnosticBillModel> getdbilldetails();

	// public void booktestt(String cat, String cat2, int test, int price, String contact, String type);

	

	public void booktestt(BillInputModel bi);

	public List<Object> gettotalbills(String contact);

	public void storedb(String contact);

}
