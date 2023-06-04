package spring.mail.orm.services;

import org.springframework.beans.factory.annotation.Autowired;

import spring.mail.orm.dao.UserDao;
import spring.mail.orm.model.UserPass;

public class UserServices {
	@Autowired
	private UserDao udao;

	public UserPass getUser(String uname) {
		return udao.getUserDetails(uname);
	}
	public boolean saveUser(String ottps,int time) {
        return udao.saveUser(ottps,time);
    }
	public void updateUser(String lcpass,String uname) {
		udao.updateUser(lcpass, uname);
	}
	public void changeUser(String lcpass,String uname) {
		udao.changeUser(lcpass, uname);
	}

}