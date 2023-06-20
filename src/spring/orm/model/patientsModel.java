package spring.orm.model;

// package spring.orm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class patientsModel {

	@Id
	@Column(name = "patn_id")
	private int patn_id;
	@Column(name = "patn_name")
	private String patn_name;
	@Column(name = "patn_age")
	private int patn_age;
	@Column(name = "patn_gender")
	private char patn_gender;
	@Column(name = "patn_bgroup")
	private char patn_bgroup;
	@Column(name = "patn_rdate")
	private LocalDate patn_rdate;
	@Column(name = "patn_lastvisit")
	private LocalDate patn_lastvisit;
	@Column(name = "patn_lastapp_id")
	private int patn_lastapp_id;
	@Column(name = "patn_contact")
	private String patn_contact;

	public patientsModel(int patn_id, String patn_name, int patn_age, char patn_gender, char patn_bgroup,
			LocalDate patn_rdate, LocalDate patn_lastvisit, int patn_lastapp_id, String patn_contact) {
		super();
		this.patn_id = patn_id;
		this.patn_name = patn_name;
		this.patn_age = patn_age;
		this.patn_gender = patn_gender;
		this.patn_bgroup = patn_bgroup;
		this.patn_rdate = patn_rdate;
		this.patn_lastvisit = patn_lastvisit;
		this.patn_lastapp_id = patn_lastapp_id;
		this.patn_contact = patn_contact;
	}

	public String getPatn_contact() {
		return patn_contact;
	}

	public void setPatn_contact(String patn_contact) {
		this.patn_contact = patn_contact;
	}

	public int getPatn_id() {
		return patn_id;
	}

	public void setPatn_id(int patn_id) {
		this.patn_id = patn_id;
	}

	public String getPatn_name() {
		return patn_name;
	}

	public void setPatn_name(String patn_name) {
		this.patn_name = patn_name;
	}

	public int getPatn_age() {
		return patn_age;
	}

	public void setPatn_age(int patn_age) {
		this.patn_age = patn_age;
	}

	public char getPatn_gender() {
		return patn_gender;
	}

	public void setPatn_gender(char patn_gender) {
		this.patn_gender = patn_gender;
	}

	public char getPatn_bgroup() {
		return patn_bgroup;
	}

	public void setPatn_bgroup(char patn_bgroup) {
		this.patn_bgroup = patn_bgroup;
	}

	public LocalDate getPatn_rdate() {
		return patn_rdate;
	}

	public void setPatn_rdate(LocalDate patn_rdate) {
		this.patn_rdate = patn_rdate;
	}

	public LocalDate getPatn_lastvisit() {
		return patn_lastvisit;
	}

	public void setPatn_lastvisit(LocalDate patn_lastvisit) {
		this.patn_lastvisit = patn_lastvisit;
	}

	public int getPatn_lastapp_id() {
		return patn_lastapp_id;
	}

	public void setPatn_lastapp_id(int patn_lastapp_id) {
		this.patn_lastapp_id = patn_lastapp_id;
	}

}
