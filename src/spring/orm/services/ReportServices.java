package spring.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.orm.dao.DCDao;

@Component
public class ReportServices {
	@Autowired
	DCDao dc;

	public List<Object[]> getTestData() {
		List<Object[]> TestData = dc.fetchTestData();

		return TestData;
	}

	public void controlNoDate(String name, String category, String method) {

		if (category.equals("select") && method.equals("select")) {

		} else if (name.equals("select") && method.equals("select")) {

		} else if (name.equals("select") && category.equals("select")) {

		} else if (method.equals("select")) {

		} else if (category.equals("select")) {

		} else if (name.equals("select")) {

		}

	}

	public void controlWithDate(String from, String to, String name, String category, String method) {
		if (category.equals("select") && method.equals("select")) {

		} else if (name.equals("select") && method.equals("select")) {

		} else if (name.equals("select") && category.equals("select")) {

		} else if (method.equals("select")) {

		} else if (category.equals("select")) {

		} else if (name.equals("select")) {

		}

	}

}
