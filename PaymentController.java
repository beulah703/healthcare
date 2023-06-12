package spring.mail.orm.send.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;


import spring.mail.orm.model.*;
import spring.mail.orm.send.MailSend;
import spring.mail.orm.send.services.UserServices;
@Controller
public class PaymentController {
	@Autowired
	UserServices us;
	@GetMapping("/adminpay")
	public String  viewDatewisePayments(Model model,HttpServletRequest request,HttpServletResponse response){

		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getapppaymnets();
		List<DoctorModel> dm=us.getdocspecdetails();
		  List<specializationModel>sm= us.getpecdetails();
		  
		Gson gson = new Gson();
	    String json = gson.toJson(tm);
	    String json1 = gson.toJson(dm);
	    String json2 = gson.toJson(sm);
	   
	    model.addAttribute("tests", json);
	    model.addAttribute("docs", json1);
	    model.addAttribute("specs", json2);
	   
	    System.out.println("Inside testdetails");
	    return "adminpaymentspage";
		
	}
	@GetMapping("/dcpay")
	public String  viewDCPayments(Model model,HttpServletRequest request,HttpServletResponse response){
		  List<diagnosticBillModel>dbm= us.getdbilldetails();
		Gson gson = new Gson();	   
	    String json3 = gson.toJson(dbm);
	    model.addAttribute("dbills", json3);
	    System.out.println("Inside testdetails");
	    return "dcadminpayments";
		
	}
//	
//	@PostMapping("/specwpay")
//	public String viewSpecializationwisePayments(int spec_id){
//		return "adminpaymentspage";
//		
//	}
//	@PostMapping("admin/datespecwpay")
//	public String viewDateSpecwisePayments(String date,int spec_id){
//		return "adminpaymentspage";
//		
//	}
//	@PostMapping("admin/docwpay")
//	public String viewDoctorwisePayments(int doc_id){
//		return "adminpaymentspage";
//		
//	}
//	@PostMapping("dcadmin/billwpay")
//	public String viewbillwisePayments(int dgbl_id){
//		return "dcadminpaymentspage";
//		
//	}
//	@PostMapping("dcadmin/datewpay")
//	public String viewdatewisePayments(String date){
//		return "dcadminpaymentspage";
//		
//	}
	@PostMapping("/refundPayment")
	public String viewdatebillwisePayments(@RequestParam String patientId,
			@RequestParam String amount,
			@RequestParam String email){
		System.out.println("refund");
		MailSend m = new MailSend();
		m.sendrefundMail(email, amount);
		return "Refund processed successfully";
		
	}
	@GetMapping("/adminrefund")
	public String refundPayments(Model model,HttpServletRequest request,HttpServletResponse response){
		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getapppaymnets();
		Gson gson = new Gson();	   
	    String json3 = gson.toJson(tm);
	    model.addAttribute("tests", json3);
	    System.out.println("Inside testdetails");
		return "appointmentspage";
		
	}
	@PostMapping("/generatebill")
	public String generatebill(int test_id,int pat_id){
		return "dcadminpaymentspage";
		
	}
	@GetMapping("/patientpay")
	public String  viewPatientPayments(Model model,HttpServletRequest request,HttpServletResponse response){
		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getapppaymnets();
		Gson gson = new Gson();	   
	    String json3 = gson.toJson(tm);
	    model.addAttribute("tests", json3);
	    System.out.println("Inside testdetails");
	    return "patientspaymentspage";
		
	}
	
	

}
