package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.orm.dao.DoctorsDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.model.Specialization;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SpecializationDao specdao;

	@Autowired
	private DoctorsDao docdao;

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String basePage(Model m) {
		m.addAttribute("dcount", docdao.findAll().size());

		return "admin/dashboard";
	}

	@RequestMapping(value = "/specialization", method = RequestMethod.GET)
	public String getSpecialization(Model m) {
		System.out.println("special");
		List<Specialization> slist = specdao.getAllSpec();
		m.addAttribute("slist", slist);
		return "admin/specialization";
	}

	@RequestMapping(value = "/getbookapp")
	public String getBookedApp() {
		return "admin/bookedapp";
	}
	//
	// @RequestMapping(value = "/appointment")
	// public String getNewAppoint(Model m) {
	// m.addAttribute("speclist",specdao.getAllSpec());
	// return "admin/appointment";
	// }

	@RequestMapping(value = "/getpaymets")

	public String getPayments() {
		return "admin/payments";
	}



	@RequestMapping(value = "/getpatient")
	public String getPatient() {
		return "admin/patientprofile";
	}

	@RequestMapping(value = "/reschedule")
	public String reschedule() {
		return "admin/reschedule";
	}

	@RequestMapping(value = "/cancel")
	public String cancelappointment() {
		return "admin/cancel";
	}

	@RequestMapping(value = "/settings")
	public String settings() {
		return "admin/settings";
	}

}