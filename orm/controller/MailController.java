package spring.orm.controller;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.orm.model.UserPass;
import spring.orm.services.UserServices;
import spring.orm.util.MailSend;

@Controller

public class MailController {
	boolean isExpired;
	@Autowired
	UserServices us;
	String otp;

	@PersistenceContext
	private EntityManager em;

	@GetMapping("/home")
	public String loginPage() {
		return "home";
	}

	@GetMapping("/docform")
	public String docPage() {
		return "DoctorForm";
	}

	@GetMapping("/specform")
	public String specPage() {
		return "specform";
	}

	@GetMapping("/booking")
	public String booking() {
		return "booktest";
	}

	@GetMapping("/dcpatients")
	public String dcpatPage() {
		return "DCPatients";
	}

	// @GetMapping("/Tests")
	// public String testPage() {
	// return "testspage";
	// }

	@GetMapping("/DCReports")
	public String dcreports() {
		return "dcreportspage";
	}

	@GetMapping("/dcscreen")
	public String dcscreen() {
		return "dcscreen";
	}
	//
	// public String otpWindow(@RequestParam String uname) {
	// UserPass up = us.getUser(uname);
	//
	// return "otp";
	// }

	@Autowired
	private UserServices userServices;

	@PostMapping("/login")
	public String loginValidate(@RequestParam String uname, @RequestParam String pass, Model model,
			@RequestParam String role) {
		UserPass user = userServices.getUser(uname);

		if (user != null && user.getPassword().equals(pass) && user.getrole().equals(role)) {

			return "dcscreen";
		}
		return pass;

	}

	@GetMapping("/forget")
	public String getForgetPage() {
		return "forgetPage";
	}

	// @GetMapping("/gettestdetails")
	// public String getdetails() {
	// return "testspage";
	// }

	@GetMapping("/change")
	public String getchangePage() {
		return "changepass";
	}

	@GetMapping("/register")
	public String getregisterPage() {
		return "registerPage";
	}

	@Autowired
	private UserServices userService;

	@PostMapping("/forgetVal")

	public String sendMail(@RequestParam String uname) {
		System.out.println("hello");
		MailSend m = new MailSend();
		UserPass user = userService.getUser(uname);
		String umail = user.getMail();
		System.out.println(umail);
		otp = m.OTPGen();
		m.sendOTPMail(umail, otp);

		LocalTime currentTime = LocalTime.now();

		Timestamp otpTimestamp = Timestamp.valueOf(java.time.LocalDate.now() + " " + currentTime);
		String ottps = (otpTimestamp).toString();

		user.setOtp(otp);
		System.out.println(ottps);

		isExpired = userService.saveUser(ottps, 3);

		System.out.println("added");
		System.out.println(isExpired);

		return "reset";
	}

	@PostMapping("/passwordset")

	public String otpValidate(@RequestParam String lcpass, @RequestParam String lotp, @RequestParam String uname) {

		UserPass up = us.getUser(uname);
		System.out.println(otp);
		System.out.println(lotp);
		if (isExpired && lotp.equals(otp)) {
			userService.updateUser(lcpass, uname);
			up.setPassword(lcpass);

			System.out.println(up.getPassword());
			return "success";
		} else {
			System.out.println("OTP Expired");

		}
		return "";
	}

	@PostMapping("/passwordchange")

	public String passwordchange(@RequestParam String lcpass, @RequestParam String opass, @RequestParam String uname) {

		UserPass up = us.getUser(uname);
		if (up.getPassword().equals(opass)) {
			up.setPassword(lcpass);
			userService.changeUser(lcpass, uname);

			return "success";
		} else {
			System.out.println("Wrong Old Password");

		}
		return "";
	}

	@PostMapping("/saveregister")

	public String saveregister(@RequestParam String name, @RequestParam String mail, @RequestParam String pass,
			@RequestParam String role) {

		us.registeruser(name, pass, mail, role);
		System.out.println(role);

		return "success";
	}

	public String savedoc(@RequestParam String doc_name, @RequestParam String doc_qual, @RequestParam int spec_id,
			@RequestParam String doc_exp, byte[] doc_photo, int doc_cfee) {

		us.savedoc(doc_name, doc_qual, spec_id, doc_exp, doc_photo, doc_cfee);

		return "success";
	}

	@GetMapping("/docspecdetails")

	public String getdocspecdetails() {

		us.getdocspecdetails();
		System.out.println(us.getdocspecdetails());

		return "success";
	}

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

		return "billpage";
	}

	// @GetMapping("/gettestdetails")
	// public String testdetails(Model model) {
	// System.out.println("Inside testdetails");
	// List<testModel> tm = userServices.gettests();
	// System.out.println("Inside testdetails");
	//
	// model.addAttribute("tests", tm);
	//
	// return "testspage";
	//
	// }

}
