package spring.mail.orm.dao;

import spring.mail.orm.model.UserPass;

public interface UserDao {
	public UserPass getUserDetails(String s);
	
	public boolean saveUser(String ottps,int time);
	public void updateUser(String lcpass,String uname);
	public void changeUser(String lcpass,String uname);
}