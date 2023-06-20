package spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "das_users")
public class UserPass {

	@Id
	@Column(name = "uname")
	private String username;
	@Column(name = "pass")
	private String Password;
	@Column(name = "mail")
	private String mail;
	@Column(name = "otp")
	private String otp;
	@Column(name = "status")
	private String status;
	@Column(name = "otptime")
	private Date otptime;
	@Column(name = "role")
	private String role;

	public UserPass(String username, String password, String mail, String role) {

		this.username = username;
		Password = password;
		this.mail = mail;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public Date getotptime() {
		return otptime;
	}

	public void setotptime(Date otpTimestamp) {
		this.otptime = otpTimestamp;
	}

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return username + " " + Password + " " + mail + " " + otp + " " + status + " " + otptime + " " + role;
	}

	public UserPass() {
		super();
	}

}