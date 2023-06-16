package spring.orm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.model.testModel;
import spring.orm.services.UserServices;

@Controller
public class TestBillGenController {
	@Autowired
	UserServices us;

	@RequestMapping("/dcadmin/booktest")
	public String GetCat(Model model) {

		List<testModel> lc = us.gettests();

		System.out.println("*********************" + lc);
		Gson gson = new Gson();
		String json = gson.toJson(lc);
		model.addAttribute("cats", json);

		return "dcadmin/booktest";

	}

	@RequestMapping(value = "/dcadmin/gettestbycat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> GettestbyCat(@RequestParam String cat, Model model) {
		System.out.println("inside testcat");
		List<testModel> test = us.gettestbycat(cat);
		// System.out.println(test.get(1));

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(test));

	}

	@RequestMapping("/dcadmin/billgen")
	public String TestBillGenerator(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String id) {

		us.bookTest(id);

		System.out.println("Inside testdetails");
		return "dcadmin/booktest";

	}

	@RequestMapping(value = "/dcadmin/gettestprice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> Gettestprice(@RequestParam String test, Model model) {
		System.out.println("inside testcat");
		Integer price = us.gettestprice(test);
		// System.out.println(test.get(1));

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(price));

	}

	// @GetMapping("/fetchData")
	// public FormData fetchData(@RequestParam("option") String selectedOption) {
	// // Query the database based on the selected option
	// // Replace the following code with your database query logic
	// String field1Value = ""; // Retrieve field1 value from the database
	// // String field2Value = ""; // Retrieve field2 value from the database
	//
	// // Create a FormData object with the retrieved field values
	// FormData formData = new FormData(field1Value);
	// return formData;
	// }
	//
	// public static class FormData {
	// private String field1;
	// // private String field2;
	//
	// public FormData(String field1) {
	// this.field1 = field1;
	// // this.field2 = field2;
	// }
	//
	// // Add getters and setters for field1 and field2
	// public String getField1() {
	// return field1;
	// }
	//
	// public void setField1(String field1) {
	// this.field1 = field1;
	// }
	//
	// }

}
