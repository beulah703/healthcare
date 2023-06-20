package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.dao.DocScheduleDao;
import spring.orm.dao.DoctorsDao;
import spring.orm.dao.PatientDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.dao.TestDao;
import spring.orm.dao.UserDao;
import spring.orm.model.Specialization;
import spring.orm.services.DoctorOutputService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private SpecializationDao specdao;

	@Autowired
	private DoctorsDao docdao;
	@Autowired
	private PatientDao pdao;

	@Autowired
	private UserDao udao;
	@Autowired
	private TestDao tdao;
	@Autowired

	private DoctorOutputService docserv;
	@Autowired
	private DocScheduleDao docschdao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String basePage() {
		return "patient/patient";
	}

	@RequestMapping(value = "/personal", method = RequestMethod.GET)
	public String PersonalData() {
		System.out.println("personal");
		return "patient/Personal"; // form has to be created
	}

	@RequestMapping(value = "/editpersonal", method = RequestMethod.GET)
	public String editPersonalForm() {
		System.out.println("personal");
		return "patient/EditPersonal";
	}

	@RequestMapping(value = "/editfamily", method = RequestMethod.GET)
	public String editFamilyForm() {
		System.out.println("personal");
		return "patient/EditFamily";
	}

	@RequestMapping(value = "/upcoming", method = RequestMethod.GET)
	public String UpcomingAppointments() {
		System.out.println("upcoming");
		return "patient/upcoming";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewProfile() {

		return "patient/MyProfile";
	}

	@RequestMapping(value = "/myfamily", method = RequestMethod.GET)
	public String viewMyFamily() {

		return "patient/Family";
	}

	@RequestMapping(value = "/patienttest", method = RequestMethod.GET)
	public String ptest() {

		return "patient/patienttest";
	}

	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String getappPage(Model m) {
		List<Specialization> speclist = specdao.getAllSpec();
		m.addAttribute("speclist", speclist);

		return "patient/appointment";
	}

	@RequestMapping(value = "/testsconducted", method = RequestMethod.GET)
	public String viewTestsConducted() {

		return "patient/TestConducted";
	}

	@RequestMapping(value = "/bookedappointments", method = RequestMethod.GET)
	public String viewBookedAppointments() {
		System.out.println("book app called?");
		return "patient/upcoming";
	}

	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String viewMyprofile() {
		return "patient/myprofile";
	}

	@RequestMapping(value = "/getapptestcards", method = RequestMethod.GET)
	public ResponseEntity<String> getapptestcards() {
		List<Object> lo = pdao.getapptestcards();
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(lo));
		// return "patient/myprofile";
	}

	@RequestMapping(value = "/getTestDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> getTestDetails(@RequestParam int testid) {
		List<Object> lo = tdao.getviewtests(testid);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(lo));

	}

}