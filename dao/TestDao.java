package spring.orm.dao;

import java.util.List;

import spring.orm.model.testModel;

public interface TestDao {

	testModel gettestbyid(int id);

	List<testModel> gettests();

	void savetest(testModel s);

	void updatetest(int test_id, String test_name, String test_category, int test_price, String test_method,
			String test_fromrange, String test_torange);

	void deltest(int test_id);

	// void updatetest(testModel t);
}
