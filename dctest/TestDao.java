package spring.orm.dao;

import java.util.List;

import spring.orm.model.testModel;

public interface TestDao {
	public void savetest(String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange, String test_status);

	public List<testModel> gettests();

	public testModel gettestbyid(int id);

	public void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange);

	public void deltest(int test_id);

	public List<testModel> getcat();

	public List<testModel> gettestbycat(String cat);

	public List<String> getTestCat();

	public Object gettestprice(int tests);

	public List<Object> getviewtests(int testid);

}
