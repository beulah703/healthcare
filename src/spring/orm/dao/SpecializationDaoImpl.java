package spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import spring.orm.model.Specialization;

@Component
public class SpecializationDaoImpl implements SpecializationDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public Specialization getSpecialization(String Id) {
		// TODO Auto-generated method stub

		return em.find(Specialization.class, Id);
	}

	@Override
	public List<Specialization> getAllSpec() {
		// TODO Auto-generated method stub
		return em.createQuery("select s from Specialization s", Specialization.class).getResultList();
	}

	@Transactional
	@Override
	public void delSpec(String id) {

		em.remove(em.find(Specialization.class, id));
	}

	@Transactional
	@Override
	public void addSpec(Specialization s) {
		// TODO Auto-generated method stub

		em.persist(s);
	}

	@Transactional
	@Override
	public void updateSpec(Specialization s) {
		// TODO Auto-generated method stub

		System.out.println("In Update Spec");
		em.merge(s);

	}

}
