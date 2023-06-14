package spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tests")
public class testModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private int test_id;
	@Column(name = "test_name")
	private String test_name;
	@Column(name = "test_category")
	private String test_category;
	@Column(name = "test_price")
	private int test_price;
	@Column(name = "test_method")
	private String test_method;
	@Column(name = "test_fromrange")
	private String test_fromrange;
	@Column(name = "test_torange")
	private String test_torange;
	@Column(name = "test_status")
	private String test_status;

	public testModel(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status) {

		this.test_id = test_id;
		this.test_name = test_name;
		this.test_category = test_category;
		this.test_price = test_price;
		this.test_method = test_method;
		this.test_fromrange = test_fromrange;
		this.test_torange = test_torange;
		this.test_status = test_status;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getTest_category() {
		return test_category;
	}

	public void setTest_category(String test_category) {
		this.test_category = test_category;
	}

	public int getTest_price() {
		return test_price;
	}

	public void setTest_price(int test_price) {
		this.test_price = test_price;
	}

	public String getTest_method() {
		return test_method;
	}

	public void setTest_method(String test_method) {
		this.test_method = test_method;
	}

	public String getTest_fromrange() {
		return test_fromrange;
	}

	public void setTest_fromrange(String test_fromrange) {
		this.test_fromrange = test_fromrange;
	}

	public String getTest_torange() {
		return test_torange;
	}

	public void setTest_torange(String test_torange) {
		this.test_torange = test_torange;
	}

	public String getTest_status() {
		return test_status;
	}

	public void setTest_status(String test_torange) {
		this.test_status = test_status;
	}

	public testModel() {
		super();
	}

}
