package spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dbiils")
public class diagnosticBillModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dgbl_id")
	private int dgbl_id;
	@Column(name = "dgbl_patn_id")
	private int dgbl_patn_id;
	@Column(name = "dgbl_date")
	private String dgbl_date;
	@Column(name = "dgbl_amount")
	private double dgbl_amount;
	@Column(name = "dgbl_patn_type")
	private String dgbl_patn_type;

	public diagnosticBillModel() {
	}

	public int getDgbl_id() {
		return dgbl_id;
	}

	public void setDgbl_id(int dgbl_id) {
		this.dgbl_id = dgbl_id;
	}

	public int getDgbl_patn_id() {
		return dgbl_patn_id;
	}

	public void setDgbl_patn_id(int dgbl_patn_id) {
		this.dgbl_patn_id = dgbl_patn_id;
	}

	public String getDgbl_date() {
		return dgbl_date;
	}

	public void setDgbl_date(String dgbl_date) {
		this.dgbl_date = dgbl_date;
	}

	public double getDgbl_amount() {
		return dgbl_amount;
	}

	public void setDgbl_amount(double dgbl_amount) {
		this.dgbl_amount = dgbl_amount;
	}

	public String getDgbl_patn_type() {
		return dgbl_patn_type;
	}

	public void setDgbl_patn_type(String dgbl_patn_type) {
		this.dgbl_patn_type = dgbl_patn_type;
	}
}
