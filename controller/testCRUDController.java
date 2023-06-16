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

import spring.orm.dao.TestDao;
import spring.orm.model.testModel;

@Controller
public class testCRUDController {

	@Autowired
	private TestDao testdao;

	@RequestMapping(value = "dcadmin/gettestdetails", method = RequestMethod.GET)
	public String testdetails(Model model) {
		System.out.println("Inside testdetails...........");
		List<testModel> tm = testdao.gettests();
		System.out.println("Inside testdetailssssss" + tm);

		model.addAttribute("tests", tm);
		System.out.println(tm);
		return "dcadmin/testspage";

	}

	// @PostMapping("/savetest")
	@RequestMapping(value = "dcadmin/savetest", method = RequestMethod.POST)
	public String savetest(@ModelAttribute testModel t, Model model) {
		testdao.savetest(t);
		List<testModel> tm = testdao.gettests();
		System.out.println("Inside testdetails1");

		model.addAttribute("tests", tm);

		return "dcadmin/testspage";
	}

	// @PostMapping("/updatetest")
	@RequestMapping(value = "dcadmin/updatetest", method = RequestMethod.POST)
	public String updatetest(@ModelAttribute testModel t, Model model) {

		// testdao.updatetest(test_id, test_name, test_category, test_price, test_method, test_fromrange, test_torange);
		List<testModel> tm = testdao.gettests();
		System.out.println("Inside testdetails2");

		model.addAttribute("tests", tm);

		return "testspage";
	}

	// @PostMapping("/deltest")
	@RequestMapping(value = "/deltest", method = RequestMethod.POST)
	public String deltest(@RequestParam int test_id, Model model) {

		testdao.deltest(test_id);
		List<testModel> tm = testdao.gettests();
		System.out.println("Inside testdetails3");

		model.addAttribute("tests", tm);

		return "testspage";
	}

	@RequestMapping(value = "dcadmin/gettest", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getspec(@RequestParam int id) {
		System.out.println("Entered");
		testModel s = testdao.gettestbyid(id);

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(s));
	}

}
