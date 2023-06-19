package spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.Appointmentmodel;
import spring.orm.model.testModel;
@Repository
public class PatientDaoImpl implements PatientDao{
	@Autowired

	private SessionFactory sF;
	@Override
	@Transactional
	public List<Object> getapptestcards() {
		Session s = sF.getCurrentSession();

		//LocalDate currentDate = LocalDate.now();
		//String d = currentDate.toString();
		String d="2023-06-16";

		List<Appointmentmodel> lm = s
				.createQuery("select a from Appointmentmodel a where a.appn_sch_date =:d", Appointmentmodel.class)
				.setParameter("d", d).getResultList();
		// return s.get(Specialization.class, Id);
		int app = lm.size();
		System.out.println(app);
		List<testModel> tm = s.createQuery("select t from testModel t ", testModel.class).getResultList();
		int tests = tm.size();
		System.out.println(tests);
		List<Object> ls = new ArrayList<>();

		List<Object> lm2 = s.createQuery(
				"select a.appn_id,d.name,a.appn_sch_date,a.appn_status from Appointmentmodel a ,Doctor d JOIN a.doctor d ")
				.getResultList();
		List<Object> lm3 = s.createQuery(
				"select d.dgbl_test_id,t.test_name from diagnostictestbill d , testModel t,diagnosticBillModel d1 where d.dgbl_id=d1.dgbl_id and d.dgbl_test_id=t.test_id and d1.dgbl_date=:d ")
				.setParameter("d", d).getResultList();

		ls.add(app);
		ls.add(tests);
		ls.add(lm2.get(0));
		ls.add(lm2.get(1));
		ls.add(lm2.get(2));
		ls.add(lm2.get(3));
		ls.add(lm3.get(0));
		ls.add(lm3.get(1));

		return ls;
	}

}
