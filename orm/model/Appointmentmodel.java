package spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointmentmodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appn_id")
	private int appn_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doct_spec_id")
	private Doctor doctor;
	@Column(name = "appn_patn_id")
	private int appn_patn_id;
	@Column(name = "appn_booked_Date")
	private String appn_booked_Date;
	@Column(name = "appn_sch_Date")
	private String appn_sch_date;
	@Column(name = "appn_paymode")
	private String appn_paymode;
	@Column(name = "appn_payreference")
	private String appn_payreference;
	@Column(name = "appn_payamount")
	private double appn_payamount;
	@Column(name = "appn_status")
	private String appn_status;
	@Column(name = "appn_email")
	private String appn_email;

	public Appointmentmodel() {
		super();
	}

	public int getAppn_id() {
		return appn_id;
	}

	public void setAppn_id(int appn_id) {
		this.appn_id = appn_id;
	}

//	public int getAppn_doct_id() {
//		return appn_doct_id;
//	}
//
//	public void setAppn_doct_id(int appn_doct_id) {
//		this.appn_doct_id = appn_doct_id;
//	}

	public int getAppn_patn_id() {
		return appn_patn_id;
	}

	public void setAppn_patn_id(int appn_patn_id) {
		this.appn_patn_id = appn_patn_id;
	}

	public String getAppn_booked_Date() {
		return appn_booked_Date;
	}

	public void setAppn_booked_Date(String appn_booked_Date) {
		this.appn_booked_Date = appn_booked_Date;
	}

	public String getAppn_sch_date() {
		return appn_sch_date;
	}

	public void setAppn_sch_date(String appn_sch_date) {
		this.appn_sch_date = appn_sch_date;
	}

	public String getAppn_paymode() {
		return appn_paymode;
	}

	public void setAppn_paymode(String appn_paymode) {
		this.appn_paymode = appn_paymode;
	}

	public String getAppn_payreference() {
		return appn_payreference;
	}

	public void setAppn_payreference(String appn_payreference) {
		this.appn_payreference = appn_payreference;
	}

	public double getAppn_payamount() {
		return appn_payamount;
	}

	public void setAppn_payamount(double appn_payamount) {
		this.appn_payamount = appn_payamount;
	}

	public String getAppn_status() {
		return appn_status;
	}

	public void setAppn_status(String appn_status) {
		this.appn_status = appn_status;
	}

	public String getAppn_email() {
		return appn_email;
	}

	public void setAppn_email(String appn_email) {
		this.appn_email = appn_email;
	}
}
