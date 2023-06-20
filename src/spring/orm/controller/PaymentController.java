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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.dao.SpecializationDao;
import spring.orm.model.Appointmentmodel;
import spring.orm.model.DiagnosticBillModel;
import spring.orm.services.UserServices;
import spring.orm.util.MailSend;

@Controller
public class PaymentController {
	@Autowired
	UserServices us;
	@Autowired
	private SpecializationDao specdao;

	//
	@RequestMapping("/admin/adminpay")
	public String viewDatewisePayments(Model model) {
		model.addAttribute("specs", specdao.getAllSpec());
		model.addAttribute("docs", us.getdocspecdetails());

		return "admin/adminpaymentspage";

	}

	@RequestMapping("/dcadmin/dcpay")
	public String viewDCPayments(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<DiagnosticBillModel> dbm = us.getdbilldetails();
		Gson gson = new Gson();
		String json3 = gson.toJson(dbm);
		model.addAttribute("dbills", json3);
		System.out.println("Inside testdetails");
		return "dcadmin/dcadminpayments";

	}

	// @RequestMapping(value="/admin/getspecwisepay",produces = MediaType.APPLICATION_JSON_VALUE, method =
	// RequestMethod.POST)
	// public ResponseEntity<String> getspecwisepay(@RequestParam String spec) {
	// List<Appointmentmodel> am=us.getspecwisepay(spec);
	// //model.addAttribute("specpay",am);
	//
	// Gson gson = new Gson();
	// String json3 = gson.toJson(am);
	// System.out.println(json3);
	// return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(am));
	//
	//
	// }
	@RequestMapping(value = "/admin/getspecdatewisepay", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getspecdatewisepay(@RequestParam String spec, @RequestParam String dat,
			@RequestParam String date) {

		List<Appointmentmodel> am = us.getspecdatewisepay(spec, dat, date);
		// model.addAttribute("specpay",am);

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(am));
		// return ResponseEntity.status(HttpStatus.OK).body("success");
		// return "admin/adminpayments";

	}

	@RequestMapping(value = "/admin/getdatewisepay", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getdatewisepay(@RequestParam String dat, @RequestParam String date) {
		List<Appointmentmodel> am = us.getdatewisepay(dat, date);

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(am));

	}

	@RequestMapping(value = "/admin/getdocwisepay", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getdocwisepay(@RequestParam int doc) {
		List<Appointmentmodel> am = us.getdocwisepay(doc);
		// model.addAttribute("specpay",am);

		Gson gson = new Gson();
		String json3 = gson.toJson(am);
		System.out.println(json3);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(am));

	}

	@RequestMapping(value = "/admin/getdocdatewisepay", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getdocdatewisepay(@RequestParam int doc, @RequestParam String dat,
			@RequestParam String date) {
		List<Appointmentmodel> am = us.getdocdatewisepay(doc, dat, date);
		// model.addAttribute("specpay",am);

		Gson gson = new Gson();
		String json3 = gson.toJson(am);
		System.out.println(json3);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(am));

	}

	@PostMapping("/admin/refundPayment")
	public String viewdatebillwisePayments(@RequestParam String patientId, @RequestParam String amount,
			@RequestParam String email) {
		System.out.println("refund");
		MailSend m = new MailSend();
		m.sendrefundMail(email, amount);
		return "Refund processed successfully";

	}

	@GetMapping("/adminrefund")
	public String refundPayments(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getapppaymnets();
		Gson gson = new Gson();
		String json3 = gson.toJson(tm);
		model.addAttribute("tests", json3);
		System.out.println("Inside testdetails");
		return "appointmentspage";

	}

	@PostMapping("/generatebill")
	public String generatebill(int test_id, int pat_id) {
		return "dcadminpaymentspage";

	}

	@RequestMapping("user/patientpay")
	public String viewPatientPayments(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getapppaymnets();
		Gson gson = new Gson();
		String json3 = gson.toJson(tm);
		model.addAttribute("tests", json3);
		System.out.println("Inside testdetails");
		return "patients/patientspaymentspage";

	}

	@RequestMapping(value = "admin/revenueSplit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> RevenueSplit(@RequestParam String spec, Model model) {
		List<Appointmentmodel> tm = (List<Appointmentmodel>) us.getspecPayments(spec);
		Gson gson = new Gson();
		String json3 = gson.toJson(tm);
		System.out.println(json3);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(tm));

	}

}