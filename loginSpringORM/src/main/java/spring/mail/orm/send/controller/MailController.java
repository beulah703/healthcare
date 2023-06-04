package spring.mail.orm.send.controller;

import spring.mail.orm.send.MailSend;

import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.springframework.ui.Model;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.mail.orm.model.UserPass;

import spring.mail.orm.services.UserServices;

@Controller

public class MailController {
boolean isExpired;
	@Autowired
	UserServices us;
	
	@PersistenceContext
    private EntityManager em;


	@GetMapping("/home")
	public String loginPage() {
		return "home";
	}
//  
//	public String otpWindow(@RequestParam String uname) {
//		UserPass up = us.getUser(uname);
//
//		return "otp";
//	}

        @Autowired
        private UserServices userServices;

	@PostMapping("/login")
	public String loginValidate(@RequestParam String uname, @RequestParam String pass, Model model) {
		 UserPass user = userServices.getUser(uname);

		  if (user != null && user.getPassword().equals(pass)) {
        
        return "success"; 
}
		return pass;
		
	}

	@GetMapping("/forget")
	public String getForgetPage() {
		return "forgetPage";
	}
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
		 String umail=user.getMail();
		 System.out.println(umail);
		 m.sendOTPMail(umail);
		 String otp=m.OTPGen();
		 LocalTime currentTime = LocalTime.now();
		
         Timestamp otpTimestamp = Timestamp.valueOf(java.time.LocalDate.now() + " "+ currentTime);
         String ottps=(otpTimestamp).toString();
		UserPass up=new UserPass();	
	        up.setOtp(otp);
	        System.out.println(ottps);
	        
	        isExpired=userService.saveUser(ottps,3);

	         System.out.println("added");
	         System.out.println( isExpired);
		
		 return "reset";
	}
	@PostMapping("/passwordset")
	
	
	public String otpValidate(@RequestParam String lcpass,@RequestParam String lotp,@RequestParam String uname) {
		
		
		UserPass up = us.getUser(uname);
		if (isExpired && lotp.equals("124")) {
			userService.updateUser(lcpass,uname);
			up.setPassword(lcpass);

			System.out.println(up.getPassword());
			return "success";
		} else  {
			System.out.println("OTP Expired");
			
		}
		return "";
	}
@PostMapping("/passwordchange")
	
	
	public String passwordchange(@RequestParam String lcpass,@RequestParam String opass,@RequestParam String uname) {
		
		
		UserPass up = us.getUser(uname);
		if (up.getPassword().equals(opass)) {
			up.setPassword(lcpass);
			userService.changeUser(lcpass,uname);

			return "success";
		} else  {
			System.out.println("Wrong Old Password");
			
		}
		return "";
	}

}
