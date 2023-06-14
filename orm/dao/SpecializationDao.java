package spring.orm.dao;

import java.util.List;

import spring.orm.model.Specialization;

public interface SpecializationDao {

	public Specialization getSpecialization(String Id);

	public List<Specialization> getAllSpec();

	public void delSpec(String id);

	public void addSpec(Specialization s);
}
