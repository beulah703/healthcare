package spring.orm.controller;

import java.sql.Timestamp;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.orm.model.UserPass;
import spring.orm.services.UserServices;
import spring.orm.util.MailSend;

@Controller

public class LoginController {
	boolean isExpired;
	String otp;

	@Autowired
	private UserServices userService;

	@RequestMapping(value = "/")
	public String dcscreen() {
		return "login/home";
	}

	public String otpWindow(@RequestParam String uname) {
		UserPass up = userService.getUser(uname);
		return "otp";
	}

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public String getForgetPage() {
		return "login/forgetPage";
	}

	@RequestMapping(value = { "admin/change", "dcadmin/change", "patient/change" }, method = RequestMethod.GET)
	public String getchangePage() {
		return "login/changepass";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getregisterPage() {
		return "login/registerPage";
	}

	@RequestMapping(value = "/forgetVal", method = RequestMethod.POST)
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

		return "login/reset";
	}

	@RequestMapping(value = "/passwordset", method = RequestMethod.POST)
	public String otpValidate(@RequestParam String lcpass, @RequestParam String lotp, @RequestParam String uname) {

		UserPass up = userService.getUser(uname);
		System.out.println(otp);
		System.out.println(lotp);
		if (isExpired && lotp.equals(otp)) {
			userService.updateUser(lcpass, uname);
			up.setPassword(lcpass);

			System.out.println(up.getPassword());
			return "login/success";
		} else {
			System.out.println("OTP Expired");

		}
		return "";
	}

	@RequestMapping(value = "/passwordchange", method = RequestMethod.POST)
	public String passwordchange(@RequestParam String lcpass, @RequestParam String opass, @RequestParam String uname) {

		UserPass up = userService.getUser(uname);
		if (up.getPassword().equals(opass)) {
			up.setPassword(lcpass);
			userService.changeUser(lcpass, uname);
			return "login/success";
		} else {
			System.out.println("Wrong Old Password");
			return "login/changepass";

		}
	}

	@RequestMapping(value = "/saveregister", method = RequestMethod.POST)
	public String saveregister(@RequestParam String name, @RequestParam String mail, @RequestParam String pass,
			@RequestParam String role) {

		userService.registeruser(name, pass, mail, role);
		System.out.println(role);

		return "login/success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String redirectToDashboard(@RequestParam("uname") String uname, @RequestParam("pass") String pass,
			Model model) {
		UserPass user = userService.getUser(uname);
		System.out.println(user);
		if (user != null && user.getPassword().equals(pass)) {
			String role = user.getrole();
			if (role.equals("administrator")) {

				return "redirect:/admin/";
			} else if (role.equals("Patient")) {

				return "redirect:/patient/";
			} else if (role.equals("diagnosticcenter")) {

				return "redirect:/dcadmin/";
			}
		}
		model.addAttribute("error", "Incorrect username or password");
		return "login/home";
	}

}