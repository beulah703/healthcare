package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.model.testModel;
import spring.orm.services.UserServices;

@Controller
public class testCRUDController {
	@Autowired
	UserServices us;

	@RequestMapping(value="/gettestdetails", method=RequestMethod.GET)
	public String testdetails(Model model) {
		System.out.println("Inside testdetails");
		List<testModel> tm = us.gettests();
		System.out.println("Inside testdetails");

		model.addAttribute("tests", tm);
		return "testspage";

	}

	@PostMapping("/savetest")

	public String savetest(@RequestParam String test_name, @RequestParam String test_category,
			@RequestParam int test_price, @RequestParam String test_method, @RequestParam String test_fromrange,
			@RequestParam String test_torange, @RequestParam String test_status, Model model) {

		us.savetest(test_name, test_category, test_price, test_method, test_fromrange, test_torange, test_status);
		List<testModel> tm = us.gettests();
		System.out.println("Inside testdetails");

		model.addAttribute("tests", tm);

		return "testspage";
	}

	@PostMapping("/updatetest")

	public String updatetest(@RequestParam int test_id, @RequestParam String test_name,
			@RequestParam String test_category, @RequestParam int test_price, @RequestParam String test_method,
			@RequestParam String test_fromrange, @RequestParam String test_torange, Model model) {

		us.updatetest(test_id, test_name, test_category, test_price, test_method, test_fromrange, test_torange);
		List<testModel> tm = us.gettests();
		System.out.println("Inside testdetails");

		model.addAttribute("tests", tm);

		return "testspage";
	}

	@PostMapping("/deltest")

	public String deltest(@RequestParam int test_id, Model model) {

		us.deltest(test_id);
		List<testModel> tm = us.gettests();
		System.out.println("Inside testdetails");

		model.addAttribute("tests", tm);

		return "testspage";
	}

	@RequestMapping(value = "/getspec", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getspec(@RequestParam int id) {
		System.out.println("Entered");
		testModel s = us.gettestbyid(id);

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(s));
	}

}
