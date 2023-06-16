package spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.orm.model.testModel;

@Component
public class TestDaoImpl implements TestDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public TestDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void savetest(testModel s) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Inside savetest");
		session.save(s);
	}

	@Transactional
	public List<testModel> gettests() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("1");
		List<testModel> t = session.createQuery("SELECT t FROM testModel t", testModel.class).getResultList();
		System.out.println("Hello" + t);
		return t;
	}

	@Transactional
	public testModel gettestbyid(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(testModel.class, id);
	}

	@Transactional
	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange) {
		Session session = sessionFactory.getCurrentSession();
		testModel s = session.get(testModel.class, test_id);
		// Update the properties of the testModel object

		session.update(s);
	}

	@Transactional
	public void deltest(int test_id) {
		Session session = sessionFactory.getCurrentSession();
		testModel s = session.get(testModel.class, test_id);
		session.delete(s);
	}

}
