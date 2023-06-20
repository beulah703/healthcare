package spring.orm.dao;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import spring.orm.model.DiagnosticBillModel;
import spring.orm.model.DiagnosticBillModelId;
import spring.orm.model.Diagnostictestbill;
import spring.orm.model.input.BillInputModel;
import spring.orm.model.output.BookedTestIDs;

@Repository
public class DiagnosticBillDaoImpl implements DiagnosticBillDao {

	@PersistenceContext
	private EntityManager em;

	public List<DiagnosticBillModel> getdbilldetails() {
		return em.createQuery("SELECT d FROM diagnosticBillModel d", DiagnosticBillModel.class).getResultList();
	}

	Object d;
	Object p11;
	LocalDate currentDate = LocalDate.now();
	String c = currentDate.toString();
	ArrayList<Object> al = new ArrayList();
	ArrayList<Object> al3 = new ArrayList();
	
	List<Integer> testi = new ArrayList<>();
	String con;
	BookedTestIDs btid = new BookedTestIDs(testi, con);

	@Transactional
	public void booktestt(BillInputModel bi) {

		System.out.println("inside ne");

		int test = bi.getTest();
		String contact = bi.getContact();
		String type = bi.getType();

		System.out.println(test);
		testi.add(test);
		System.out.println(testi);
		System.out.println("Length" + "" + testi.size());

		btid.setTestids(testi);
		btid.setContact(contact);
		btid.setType(type);

	}

	
	@Transactional
	public List<Object> gettotalbills(String contact) {

		List<Object> tests1 = new ArrayList<>();
		List<Object> tests2 = new ArrayList<>();
		int amt = 0;
		if (btid.getContact().equals(contact) && (btid.getStatus() == (null)) && btid.getTestids()!=null ) {
			List<Integer> testh = btid.getTestids();
			System.out.println("length here" + testh.size());
			for (int i = 0; i < testh.size(); i++) {
				int j = (int) testh.get(i);
				tests1 = em
						.createQuery(
								"select t.test_name ,t.test_method,t.test_price from testModel t where t.test_id=:j ")
						.setParameter("j", j).getResultList();
				int testsprice = (int) em.createQuery("select t.test_price from testModel t where t.test_id=:j ")
						.setParameter("j", j).getSingleResult();

				amt = amt + testsprice;
				System.out.println(amt);
				tests2.add(tests1);
				btid.setAmt(amt);
			}
		}
		System.out.println("inside total bill");

		tests2.add(amt);
		
		
		return tests2;

	}

	@Transactional
	public void storedb(String contact) {
		// TODO Auto-generated method stub

		if (btid.getContact().equals(contact) && (btid.getStatus() == (null))) {
			Object patn_id = em.createQuery("select p.patn_id from patientsModel p where p.patn_contact=:contact")
					.setParameter("contact", contact).getSingleResult();
			System.out.println(patn_id);
			System.out.println("in 1");
			int price = btid.getAmt();
			String type = btid.getType();
			List<Integer> t1 = btid.getTestids();
			List<Diagnostictestbill> lb = new ArrayList<>();
			DiagnosticBillModel d1 = new DiagnosticBillModel((Integer) patn_id, c, price, type);
			System.out.println("in 2");
			em.persist(d1);

			for (int i = 0; i < t1.size(); i++) {

				int price2 = (int) em.createQuery("select t.test_price from testModel t where t.test_id=:j ")
						.setParameter("j", t1.get(i)).getSingleResult();
				DiagnosticBillModelId id = new DiagnosticBillModelId((Integer) d1.getDgbl_id(), t1.get(i));
				System.out.println("in 3");
				Diagnostictestbill  d2 = new Diagnostictestbill(id, price2);
				System.out.println("in 4");
				em.persist(d2);

				// s1.save(new Diagnostictestbill((Integer) d1.getDgbl_id(), t1.get(i), price2));
				btid.setStatus("paid");
				btid.setTestids(null);
			}
			

		}

	}
	@Transactional
	public void savedb(Diagnostictestbill d2) {
		
	}
	
}
