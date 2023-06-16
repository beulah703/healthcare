package spring.orm.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import spring.orm.dao.DocScheduleDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.model.Specialization;
import spring.orm.model.entity.AppointmentEntity;
import spring.orm.model.output.DoctorOutPutModel;
import spring.orm.services.AppointmentService;
import spring.orm.services.DoctorOutputService;

@Controller
@RequestMapping
public class AppointmentController {

	@Autowired
	private SpecializationDao specdao;
	@Autowired
	private DoctorOutputService docserv;
	@Autowired
	private DocScheduleDao docschdao;

	@Autowired
	private AppointmentService appdao;

	@RequestMapping(value = { "admin/appointments" })
	public String getBookedApp(Model m) {
		List<AppointmentEntity> aplist = appdao.getAllAppointments();
		System.out.println(aplist);
		m.addAttribute("aplist", aplist);
		return "admin/bookedapp";
	}

	@RequestMapping(value = "admin/newappointment")
	public String getnewApp(Model m) {
		List<Specialization> aplist = specdao.getAllSpec();
		System.out.println(aplist);
		m.addAttribute("speclist", aplist);
		return "admin/appointment";
	}

	@RequestMapping(value = { "patient/newappointment" })
	public String getnewPatApp(Model m) {
		List<Specialization> aplist = specdao.getAllSpec();
		System.out.println(aplist);
		m.addAttribute("speclist", aplist);
		return "patient/appointment";
	}

	@RequestMapping(value = "patient/appointments")
	public String getPatBookedApp(Model m) {
		List<AppointmentEntity> aplist = appdao.getAllAppointments();
		System.out.println(aplist);
		m.addAttribute("aplist", aplist);
		return "patient/bookedapp";
	}

	@RequestMapping(value = { "admin/fetchBySpecialization",
			"patient/fetchBySpecialization" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchBySpecialization(@RequestParam String specialization,
			@RequestParam String appointmentDate) {
		Date appointmentDated = Date.valueOf(appointmentDate);
		System.out.println("hello");
		List<DoctorOutPutModel> dlist = docserv.getAllDocBySpecDate(specialization, appointmentDated);

		System.out.println(appointmentDated + " " + appointmentDated.getDay());

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(dlist));

	}

	@RequestMapping(value = { "admin/fetchdoctor",
			"patient/fetchdoctor" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fetchDoctor(@RequestParam int id) {
		DoctorOutPutModel d = docserv.getDocbyID(id);
		System.out.println(d);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(d));
	}

	@RequestMapping(value = { "admin/fetchtimeSlots",
			"patient/fetchtimeSlots" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fetchTimeSlots(@RequestParam int id) {
		List<String> d = docserv.getDocTimeSlots(id);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(d));
	}

	@RequestMapping(value = { "admin/newappointment/create",
			"patient/newappointment/create" }, method = RequestMethod.POST)
	public @ResponseBody String newAppointmentBooking(@RequestParam int doctor, @RequestParam Date appointmentDate,
			@RequestParam String slots, @RequestParam String bookingType,
			@RequestParam(value = "param", required = false) String familyMembers) {

		System.out.println(familyMembers + bookingType + slots + appointmentDate + doctor);
		return "success";

	}

}