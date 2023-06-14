package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.orm.model.Specialization;

@Component
public class SpecializationDaoImpl implements SpecializationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Specialization getSpecialization(String Id) {
		// TODO Auto-generated method stub
		return em.createQuery("select s from Specialization s where s.id= :id", Specialization.class)
				.setParameter("id", Id).getSingleResult();
	}

	@Override
	public List<Specialization> getAllSpec() {
		// TODO Auto-generated method stub
		return em.createQuery("select s from Specialization s", Specialization.class).getResultList();
	}

	@Transactional
	@Override
	public void delSpec(String id) {
		// TODO Auto-generated method stub
		System.out.println("daoLayer");
		Query q = em.createQuery("delete  from Specialization s where s.id=:id");
		q.setParameter("id", id);
		System.out.println(q.executeUpdate());
	}

	@Override
	public void addSpec(Specialization s) {
		// TODO Auto-generated method stub

	}

}
