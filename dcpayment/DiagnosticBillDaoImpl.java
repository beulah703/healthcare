package spring.orm.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.diagnosticBillModel;
import spring.orm.model.diagnostictestbill;
import spring.orm.model.inputmodel.BillInputModel;

@Repository
public class DiagnosticBillDaoImpl implements DiagnosticBillDao {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SessionFactory sF;

	public List<diagnosticBillModel> getdbilldetails() {
		return em.createQuery("SELECT d FROM diagnosticBillModel d", diagnosticBillModel.class).getResultList();
	}

	

	Object d;
	Object p11;
	LocalDate currentDate = LocalDate.now();
	String c = currentDate.toString();
	ArrayList<Object> al = new ArrayList();
	ArrayList<Object> al3 = new ArrayList();
	Map<String, Integer> hashMap = new HashMap<>();

	String con;

	@Transactional
	public void booktestt(BillInputModel bi) {
		
		Session s = sF.getCurrentSession();
		System.out.println("inside ne");
		
		con = bi.getContact();
		int price=bi.getPrice();
		int p2=price;
		int test=bi.getTest();
	String type=bi.getType();
		Object patn_id = s.createQuery("select p.patn_id from patientsModel p where p.patn_contact=:contact")
				.setParameter("contact", con).getSingleResult();
		System.out.println(patn_id);
		try {

			d = s.createQuery(
					"select d.dgbl_id from diagnosticBillModel d where d.dgbl_patn_id=:patnid and d.dgbl_date=:d")
					.setParameter("patnid", patn_id).setParameter("d", c).getSingleResult();
			int d3 = (Integer) d;
			p11 = s.createQuery("select d.dgbl_amount from diagnosticBillModel d where d.dgbl_id=:d3")
					.setParameter("d3", d3).getSingleResult();
			price = (Integer) p11 + price;
			
			System.out.println((Integer) d);

			diagnosticBillModel d1 = new diagnosticBillModel(price, c, (Integer) patn_id, type, (Integer) d);
			System.out.println("In Update Spec");
			s.update(d1);
System.out.println(p2);
			diagnostictestbill d2 = new diagnostictestbill((Integer) d, test, p2);
			s.save(d2);

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Inside new dbill");

			diagnosticBillModel d1 = new diagnosticBillModel((Integer) patn_id, c, price, type);
			s.save(d1);
			diagnostictestbill d2 = new diagnostictestbill((Integer) d1.getDgbl_id(), test, price);
			s.save(d2);
		}
		// previewtest(name, price, contact, al);
	}

	@Transactional
	public Map<String, Integer> previewtest() {
		Session s = sF.getCurrentSession();
		Object patn_id = s.createQuery("select p.patn_id from patientsModel p where p.patn_contact=:contact")
				.setParameter("contact", con).getSingleResult();
		d = s.createQuery("select d.dgbl_id from diagnosticBillModel d where d.dgbl_patn_id=:patnid and d.dgbl_date=:d")
				.setParameter("patnid", patn_id).setParameter("d", c).getSingleResult();
		int d3 = (Integer) d;
		p11 = s.createQuery("select d.dgbl_amount from diagnosticBillModel d where d.dgbl_id=:d3")
				.setParameter("d3", d3).getSingleResult();
		ArrayList<Object> al2 = new ArrayList();
		hashMap.put("Total Bill", (Integer) p11);

		return hashMap;
	}

	@Transactional
	public List<Object> gettotalbills(String contact) {
		System.out.println("inside total bill");
		Session s = sF.getCurrentSession();
		List<Object> tests1=new ArrayList<>();
		List<Object> tests2=new ArrayList<>();
		// TODO Auto-generated method stub
		Object patn_id = s.createQuery("select p.patn_id from patientsModel p where p.patn_contact=:contact")
				.setParameter("contact", contact).getSingleResult();
		d = s.createQuery("select d.dgbl_id from diagnosticBillModel d where d.dgbl_patn_id=:patnid and d.dgbl_date=:d")
				.setParameter("patnid", patn_id).setParameter("d", c).getSingleResult();
		int d3 = (Integer) d;
		List tests=s.createQuery("select d.dgbl_test_id from diagnostictestbill d where d.dgbl_id=:d ")
				.setParameter("d",d).setParameter("d", d3).getResultList();
		System.out.println(tests.size());
		for(int i=0;i<tests.size();i++) {
			int j=(int) tests.get(i);
			 tests1=s.createQuery("select t.test_name ,t.test_method,t.test_price from testModel t where t.test_id=:j ")
					.setParameter("j",j).getResultList();
			 tests2.add(tests1);
			// System.out.println(tests1.get(i));
		}
		System.out.println(tests2.size());
//		for(int i=0;i<tests1.size();i++) {
//			System.out.println(tests1.get(i).toString());
//		}
		int amt=(int) s.createQuery("select d.dgbl_amount from diagnosticBillModel d where d.dgbl_patn_id=:patnid and d.dgbl_date=:d")
		.setParameter("patnid", patn_id).setParameter("d", c).getSingleResult();
//		
		tests2.add(d3);
		tests2.add(amt);
		return tests2;
		
		
	}
}
