package spring.orm.dao;

import java.util.List;
import java.util.Map;

import spring.orm.model.diagnosticBillModel;
import spring.orm.model.inputmodel.BillInputModel;

public interface DiagnosticBillDao {
	public List<diagnosticBillModel> getdbilldetails();

	//public void booktestt(String cat, String cat2, int test, int price, String contact, String type);

	public Map<String, Integer> previewtest();

	public void booktestt(BillInputModel bi);

	public List<Object> gettotalbills(String contact);

}
