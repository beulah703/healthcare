package spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dtestbill")
public class diagnostictestbill {
	@Id
	@Column(name = "dgbl_id")
	private int dgbl_id;
	@Column(name = "dgbl_test_id")
	private int dgbl_test_id;

	@Column(name = "dgbl_test_price")
	private int dgbl_test_price;

	public diagnostictestbill() {
		super();
	}

	public diagnostictestbill(int dgbl_id, int dgbl_test_id, int dgbl_test_price) {
		this.dgbl_id = dgbl_id;
		this.dgbl_test_id = dgbl_test_id;
		this.dgbl_test_price = dgbl_test_price;
	}

	public int getDgbl_id() {
		return dgbl_id;
	}

	public void setDgbl_id(int dgbl_id) {
		this.dgbl_id = dgbl_id;
	}

	public int getDgbl_test_id() {
		return dgbl_test_id;
	}

	public void setDgbl_test_id(int dgbl_test_id) {
		this.dgbl_test_id = dgbl_test_id;
	}

	public int getDgbl_test_price() {
		return dgbl_test_price;
	}

	public void setDgbl_test_price(int dgbl_test_price) {
		this.dgbl_test_price = dgbl_test_price;
	}

}
