package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class DCImpDAO implements DCDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Object[]> fetchTestData() {
		String hql = "select test_name,test_category,test_method from testModel";

		return em.createQuery(hql).getResultList();
	}

	public List<Object[]> fetchTestNameWiseData(String name) {

		String hql = "";

		return null;

	}

}
