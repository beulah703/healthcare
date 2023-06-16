package spring.orm.dao;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.orm.model.Appointmentmodel;
import spring.orm.model.Doctor;
import spring.orm.model.Specialization;
import spring.orm.model.UserPass;
import spring.orm.model.diagnosticBillModel;
import spring.orm.model.testModel;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	@Autowired

	private SessionFactory sf;

	public UserPass getUserDetails(String uname) {
		try {
			String sql = "SELECT u FROM UserPass u WHERE u.username = :uname";
			TypedQuery<UserPass> query = em.createQuery(sql, UserPass.class).setParameter("uname", uname);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean saveUser(String ottps, int time) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("is_otp_expired");
		// Register the input parameters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);

		// Set the input parameters
		query.setParameter(1, ottps);
		query.setParameter(2, 3);
		query.execute();

		boolean isExpired = (boolean) query.getSingleResult();
		return isExpired;
	}

	public void updateUser(String lcpass, String uname) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("update_das_users");
		System.out.println("Ored");
		// Set the input parameters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		System.out.println("Expired");
		query.setParameter(1, lcpass);
		query.setParameter(2, uname);
		System.out.println("ed");
		// Execute the procedure
		query.execute();
	}

	public void changeUser(String lcpass, String uname) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("update_ma_mail_user");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		System.out.println("Expired");
		query.setParameter(1, lcpass);
		query.setParameter(2, uname);
		System.out.println("ed");
		query.execute();

	}

	@Transactional
	public void registeruser(String name, String pass, String mail, String role) {
		// StoredProcedureQuery query = em.createStoredProcedureQuery("insert_das_users");
		// System.out.println("called");
		// query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		// query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		//
		// query.setParameter(1, name);
		// query.setParameter(2, pass);
		// query.setParameter(3, mail);
		// query.setParameter(4, role);
		// query.execute();
		// System.out.println("inserted");

		UserPass user = new UserPass(name, pass, mail, role);
		sf.getCurrentSession().save(user);
		System.out.println("User registered successfully");
	}

	public List<Doctor> getdocspecdetails() {
		return em.createQuery("select d from Doctor d ", Doctor.class).getResultList();

	}

	public List<Specialization> getpecdetails() {
		return em.createQuery("SELECT s from Specialization s", Specialization.class).getResultList();

	}

	public List<diagnosticBillModel> getdbilldetails() {
		return em.createQuery("SELECT d FROM diagnosticBillModel d", diagnosticBillModel.class).getResultList();
	}

	public void savedoc(String doc_name, String doc_qual, int spec_id, String doc_exp, String doc_photo, int doc_cfee) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("insert_doc");
		System.out.println("called");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);

		query.setParameter(1, doc_name);
		query.setParameter(2, doc_qual);
		query.setParameter(3, spec_id);
		query.setParameter(4, doc_exp);
		query.setParameter(5, doc_photo);
		query.setParameter(6, doc_cfee);

		query.execute();
		System.out.println("inserted");
	}

	public void savedoctime(String weekday, String dcsc_timefrom, int scsc_avgat, String dcsc_timeto) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("insert_doctime");
		System.out.println("called2");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

		query.setParameter(1, weekday);
		query.setParameter(2, dcsc_timefrom);
		query.setParameter(3, scsc_avgat);
		query.setParameter(4, dcsc_timeto);

		query.execute();
	}

	
	public List<Appointmentmodel> getapppaymnets() {
		return em.createQuery("SELECT a FROM Appointmentmodel a ", Appointmentmodel.class).getResultList();
	}

	@Override
	public void savedoc(String doc_name, String doc_qual, int spec_id, String doc_exp, byte[] doc_photo, int doc_cfee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savetest(String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<testModel> gettests() {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public testModel gettestbyid(int id) {

		return em.createQuery("select t from testModel t where t.test_id=:id", testModel.class).setParameter("id", id)
				.getSingleResult();

	}

	@Override
	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange) {
		// TODO Auto-generated method stub

	}

	@Override

	public void deltest(int test_id) {
		// TODO Auto-generated method stub

	}


	public void booktest(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<testModel> getcat() {
		return em.createQuery("select t from testModel t", testModel.class).getResultList();
	}

	@Override
	public List<testModel> gettestbycat(String cat) {
		// TODO Auto-generated method stub
		return em.createQuery("select t from testModel t where t.test_category=:cat", testModel.class)
				.setParameter("cat", cat).getResultList();
	}

	@Override
	public Integer gettestprice(String test) {
		// TODO Auto-generated method stub return
		// System.out.println(cat);

		return em.createQuery("select t.test_price from testModel t where t.test_name=:test").setParameter("test", test)
				.getFirstResult();
	}

	@Override
	public List<String> getTestCat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Appointmentmodel> getspecPayments(String spec_id) {
		System.out.println("inside spec");
		if (spec_id.equals("null")) {
			return sf.getCurrentSession().createQuery("SELECT a FROM Appointmentmodel a ", Appointmentmodel.class)
					.getResultList();
		} else {
			System.out.println("in null");
			return sf.getCurrentSession().createQuery(
					"SELECT a From Appointmentmodel a JOIN a.doctor d JOIN d.specialization s WHERE s.id = :specid",
					Appointmentmodel.class).setParameter("specid", spec_id).getResultList();
		}
	}

	@Override
	@Transactional
	public List<Appointmentmodel> getspecdatewisepay(String spec, String date, String date2) {
		if (spec.equals("null")) {
			return sf.getCurrentSession().createQuery(
					"SELECT a FROM Appointmentmodel a JOIN a.doctor d  WHERE  a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
					Appointmentmodel.class).setParameter("date1", date).setParameter("date2", date2).getResultList();
		} else {
			return sf.getCurrentSession().createQuery(
					"SELECT a FROM Appointmentmodel a JOIN a.doctor d JOIN d.specialization s WHERE s.id =:specid and a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
					Appointmentmodel.class).setParameter("specid", spec).setParameter("date1", date)
					.setParameter("date2", date2).getResultList();
		}
	}

	@Override
	@Transactional
	public List<Appointmentmodel> getdatewisepay(String date, String date2) {
		// TODO Auto-generated method stub
		List<Appointmentmodel> lm = sf.getCurrentSession().createQuery(
				"SELECT a FROM Appointmentmodel a  WHERE a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
				Appointmentmodel.class).setParameter("date1", date).setParameter("date2", date2).getResultList();
		System.out.println("lm is" + "" + lm.get(0));

		return sf.getCurrentSession().createQuery(
				"SELECT a FROM Appointmentmodel a  WHERE a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
				Appointmentmodel.class)

				.setParameter("date1", date).setParameter("date2", date2).getResultList();

	}

	@Override
	@Transactional
	public List<Appointmentmodel> getdocwisepay(int doc) {
		System.out.println("inside do");
		if (doc == 0) {

			return sf.getCurrentSession().createQuery("SELECT a FROM Appointmentmodel a JOIN a.doctor d ")
					.getResultList();
		}

		else {
			return sf.getCurrentSession()
					.createQuery("SELECT a FROM Appointmentmodel a ,Doctor d  JOIN a.doctor d  WHERE d.id =:docid")
					.setParameter("docid", doc).getResultList();
		}
	}

	@Override
	public List<Appointmentmodel> getdocdatewisepay(int doc, String dat, String date) {
		System.out.println("in doc date");
		if (doc == 0) {
			return em.createQuery(
					"SELECT a FROM Appointmentmodel a JOIN a.doctor d  WHERE  a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
					Appointmentmodel.class).setParameter("docid", doc).setParameter("date1", dat)
					.setParameter("date2", date).getResultList();
		} else {
			return em.createQuery(
					"SELECT a FROM Appointmentmodel a JOIN a.doctor d  WHERE d.id =:docid and a.appn_booked_Date >=:date1 and a.appn_booked_Date <=:date2",
					Appointmentmodel.class).setParameter("docid", doc).setParameter("date1", dat)
					.setParameter("date2", date).getResultList();
		}
	}
	@Override
	@Transactional
	public List<Object> getapptestcards() {
		Session s = sf.getCurrentSession();
		 LocalDate currentDate = LocalDate.now();
		 String d = currentDate.toString();
		 
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

		List<Object> lm2 = s
				.createQuery("select a.appn_id,d.name,a.appn_sch_date,a.appn_status from Appointmentmodel a ,Doctor d JOIN a.doctor d ")
				.getResultList();
		List<Object> lm3 = s
				.createQuery("select d.dgbl_test_id,t.test_name from diagnostictestbill d , testModel t,diagnosticBillModel d1 where d.dgbl_id=d1.dgbl_id and d.dgbl_test_id=t.test_id and d1.dgbl_date=:d ")
				.setParameter("d", d)
				.getResultList();
		
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
