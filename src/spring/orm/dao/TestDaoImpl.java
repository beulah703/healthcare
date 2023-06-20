package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import spring.orm.model.testModel;

@Repository
public class TestDaoImpl implements TestDao {

	@PersistenceContext
	private EntityManager em;

	public void savetest(String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("insert_test");
		System.out.println("called");
		// query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);

		query.setParameter(1, test_name);
		query.setParameter(2, test_category);
		query.setParameter(3, test_price);
		query.setParameter(4, test_method);
		query.setParameter(5, test_fromrange);
		query.setParameter(6, test_torange);
		query.setParameter(7, test_status);

		query.execute();
		System.out.println("inserted");
	}

	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("update_test");
		System.out.println("called");
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.setParameter(1, test_id);
		query.setParameter(2, test_name);
		query.setParameter(3, test_category);
		query.setParameter(4, test_price);
		query.setParameter(5, test_method);
		query.setParameter(6, test_fromrange);
		query.setParameter(7, test_torange);

		query.execute();
		System.out.println("inserted");
	}

	public void deltest(int test_id) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("delete_test");
		System.out.println("called");
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);

		query.setParameter(1, test_id);

		query.execute();
		System.out.println("inserted");
	}

	public List<testModel> gettests() {
		System.out.println("getests");
		return em.createQuery("SELECT t FROM testModel t", testModel.class).getResultList();
	}

	public testModel gettestbyid(int id) {
		// TODO Auto-generated method stub
		//
		// System.out.println(
		// em.createQuery("select t from testModel t where t.test_id=id", testModel.class).getSingleResult());
		// return em.createQuery("select t from testModel t where t.test_id=id", testModel.class).getResultList();
		// // TODO Auto-generated method stub
		return em.createQuery("select t from testModel t where t.test_id=:id", testModel.class).setParameter("id", id)
				.getSingleResult();

	}

	public List<testModel> gettestbycat(String cat) {
		// TODO Auto-generated method stub return
		System.out.println(cat);
		return em.createQuery("select t from testModel t where t.test_category=:cat", testModel.class)
				.setParameter("cat", cat).getResultList();
	}

	public Object gettestprice(int test) {
		// TODO Auto-generated method stub return
		// System.out.println(cat);
		System.out.println(test);
		return em.createQuery("select t.test_price from testModel t where t.test_id=:test").setParameter("test", test)
				.getSingleResult();
	}

	public List<testModel> getcat() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getTestCat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getviewtests(int testid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savetest(testModel t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatetest(testModel t) {
		// TODO Auto-generated method stub

	}

}
