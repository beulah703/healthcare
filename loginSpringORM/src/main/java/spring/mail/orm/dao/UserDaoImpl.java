package spring.mail.orm.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import spring.mail.orm.model.UserPass;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;
	public UserPass getUserDetails(String uname) {
	    try {
	        String sql = "SELECT u FROM UserPass u WHERE u.username = :uname";
	        TypedQuery<UserPass> query = em.createQuery(sql, UserPass.class)
	                .setParameter("uname", uname);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	
	public boolean saveUser(String ottps,int time) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("is_otp_expired");
	     // Register the input parameters
	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
	       
	        // Set the input parameters
	        query.setParameter(1, ottps);
	        query.setParameter(2,3);
	     query.execute();

	     boolean isExpired = (boolean) query.getSingleResult();
	     return isExpired;
    }

	public void updateUser(String lcpass,String uname) {
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
	public void changeUser(String lcpass,String uname) {
		 StoredProcedureQuery query = em.createStoredProcedureQuery("update_ma_mail_user");
		    query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		    System.out.println("Expired");
		    query.setParameter(1, lcpass);
		    query.setParameter(2, uname);
		    System.out.println("ed");
		 query.execute();
		
		
	}
}