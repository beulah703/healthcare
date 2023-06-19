package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.dao.DiagnosticBillDao;
import spring.orm.dao.TestDao;
import spring.orm.model.testModel;
import spring.orm.model.inputmodel.BillInputModel;
import spring.orm.services.TestServices;
import spring.orm.services.UserServices;

@Controller
public class TestBillGenController {
	@Autowired
	UserServices us;
	TestServices ts;
	@Autowired
	DiagnosticBillDao dbs;
	@Autowired
	TestDao td;

	@RequestMapping("/dcadmin/booktest")
	public String GetCat(Model model) {

		List<testModel> lc = td.gettests();

		System.out.println("*********************" + lc);
		Gson gson = new Gson();
		String json = gson.toJson(lc);
		model.addAttribute("cats", json);

		return "dcadmin/booktest";

	}

	@RequestMapping(value = "/dcadmin/gettestbycat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> GettestbyCat(@RequestParam String cat, Model model) {

		List<testModel> test = td.gettestbycat(cat);
		// System.out.println(test.get(1));

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(test));

	}

	@RequestMapping(value = "/dcadmin/bookdctest", method = RequestMethod.POST)
	public void booktestt(Model model, @ModelAttribute BillInputModel bi) {
		System.out.println("in book");
		dbs.booktestt(bi);

		System.out.println("Inside testdetails");
		//return "dcadmin/booktest";

	}

	@RequestMapping(value = "/dcadmin/gettestprice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> Gettestprice(@RequestParam int test, Model model) {
		System.out.println("inside  price testcat");
		Object price = td.gettestprice(test);
		// System.out.println(test.get(1));

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(price));

	}
	
	@RequestMapping(value = "/dcadmin/totalbills", method = RequestMethod.GET)
	public ResponseEntity<String> totalbills(@RequestParam String contact,Model model) {
		System.out.println("in book");
		List<Object> lb=dbs.gettotalbills(contact);

		System.out.println("Inside total testdetails");
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(lb));

	}

}
