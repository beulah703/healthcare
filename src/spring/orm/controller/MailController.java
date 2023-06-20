package spring.orm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.orm.model.UserPass;
import spring.orm.model.testModel;
import spring.orm.services.UserServices;

@Controller
@RequestMapping("/dcadmin")
public class MailController {
	boolean isExpired;
	@Autowired
	UserServices us;
	String otp;

	@PersistenceContext
	private EntityManager em;

	// @GetMapping("/dcpatients")
//	@RequestMapping(value = "/dcpatients")
//	public String dcpatPage() {
//		return "dcadmin/DCPatients";
//	}

	// @GetMapping("/Tests")
	// public String testPage() {
	// return "testspage";
	// }

	// @GetMapping("/DCReports")
	/*
	 * @RequestMapping(value = "/DCReports") public String dcreports() {
	 * 
	 * return "dcadmin/dcreportspage"; }
	 */

	@RequestMapping(value = "/")
	public String dcscreen() {
		return "dcadmin/dcscreen";
	}
	//
	// public String otpWindow(@RequestParam String uname) {
	// UserPass up = us.getUser(uname);
	//
	// return "otp";
	// }

	@Autowired
	private UserServices userServices;



	@RequestMapping(value = "/billpage")
	public String getBillpage() {
		return "dcadmin/billpage";
	}

	// @GetMapping("/gettestdetails")
	// public String getdetails() {
	// return "testspage";
	// }

	@PostMapping("/generateBill")

	public String billgenerate(@RequestParam String test_name, @RequestParam String pname, @RequestParam String page,
			@RequestParam String gender, @RequestParam String contact, @RequestParam String email, Model model) {
		int bill = 0;
		System.out.println("bill");
		// us.registeruser(name, pass, mail, role);
		if (test_name.equals("test1")) {
			bill = 200;
		} else if (test_name.equals("test2")) {
			bill = 300;
		} else if (test_name.equals("test3")) {
			bill = 500;
		}
		List<String> billreport = new ArrayList<>();
		billreport.add(test_name);
		billreport.add(pname);
		billreport.add(page);
		billreport.add(gender);
		billreport.add(contact);
		billreport.add(email);
		billreport.add(("bill"));

		model.addAttribute("billreport", billreport);
		// System.out.println(role);

		return "dcadmin/billpage";
	}

//	@RequestMapping("/gettestdetails")
//	public String testdetails(Model model) {
//		System.out.println("Inside testdetails");
//		List<testModel> tm = userServices.gettests();
//		System.out.println("Inside testdetails");
//
//		model.addAttribute("tests", tm);
//
//		return "dcadmin/testspage";
//
//	}
	
	@RequestMapping(value = "/dcpatients")
	public String dcpatPage() {
		return "dcadmin/DCPatients";
	}


}