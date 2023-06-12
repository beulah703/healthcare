package spring.mail.orm.dao;


import java.sql.SQLException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import org.postgresql.util.PGobject;

import spring.mail.orm.model.Appointmentmodel;
import spring.mail.orm.model.DoctorModel;
import spring.mail.orm.model.UserPass;
import spring.mail.orm.model.diagnosticBillModel;
import spring.mail.orm.model.specializationModel;
import spring.mail.orm.model.testModel;


public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

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
		StoredProcedureQuery query = em.createStoredProcedureQuery("update_ma_mail_user");
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

	public void registeruser(String name, String pass, String mail, String role) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("insert_ma_mail_user");
		System.out.println("called");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

		query.setParameter(1, name);
		query.setParameter(2, pass);
		query.setParameter(3, mail);
		query.setParameter(4, role);
		query.execute();
		System.out.println("inserted");

	}

	public  List<DoctorModel> getdocspecdetails() {
		 return em.createQuery("SELECT NEW spring.mail.orm.model.DoctorModel(d.doc_name, d.doc_id,d.spec_id) FROM spring.mail.orm.model.DoctorModel d", DoctorModel.class)
		            .getResultList();
		

	}
	public  List<specializationModel> getpecdetails() {
		 return em.createQuery("SELECT NEW spring.mail.orm.model.specializationModel(s.specId, s.specTitle) FROM spring.mail.orm.model.specializationModel s", specializationModel.class)
		            .getResultList();
		

	}
	public  List<diagnosticBillModel> getdbilldetails(){
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
		query.setParameter(5,doc_photo);
		query.setParameter(6, doc_cfee);

		query.execute();
		System.out.println("inserted");
	}
	public void savedoctime(String weekday,String dcsc_timefrom,int scsc_avgat, String dcsc_timeto) {
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
	


public List<testModel> gettests(String category) {
	
	return em.createQuery("SELECT t FROM testModel t", testModel.class).getResultList();
    }

@Override
public void savedoc(String doc_name, String doc_qual, int spec_id, String doc_exp, byte[] doc_photo, int doc_cfee) {
	// TODO Auto-generated method stub
	
}

@Override
public void savetest(String test_name, String test_category, int test_price, String test_method, String test_fromrange,
		String test_torange) {
	// TODO Auto-generated method stub
	
}

@Override
public List<testModel> gettests() {
	// TODO Auto-generated method stub
	return null;
}
public List<Appointmentmodel> getapppaymnets(){
	return em.createQuery("SELECT a FROM Appointmentmodel a ", Appointmentmodel.class).getResultList();
}

	
}

