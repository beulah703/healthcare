package spring.orm.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import tempObjects.Service.DoctorService;
import tempObjects.dao.DocScheduleDao;
import tempObjects.dao.SpecializationDao;
import tempObjects.model.Doctor;
import tempObjects.model.Specialization;

@Controller
@RequestMapping(value = { "/temp", "/admin" })
public class TempObjecController {

	private SpecializationDao specdao;
	private DoctorService docserv;
	private DocScheduleDao docschdao;

	public TempObjecController() {
		specdao = new SpecializationDao();
		docserv = new DoctorService();
		docschdao = new DocScheduleDao();

	}

	@RequestMapping(value = "/getnewbookapp", method = RequestMethod.GET)
	public String getappPage(Model m) {
		List<Specialization> speclist = specdao.getAllSpec();
		m.addAttribute("speclist", speclist);

		return "common/appointment";
	}

	@RequestMapping(value = "/fetchBySpecialization", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchBySpecialization(@RequestParam String specialization,
			@RequestParam String appointmentDate) {
		Date appointmentDated = Date.valueOf(appointmentDate);
		List<Doctor> dlist = docserv.getAllDocBySpecDate(specialization, appointmentDated);

		System.out.println(appointmentDated + " " + appointmentDated.getDay());

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(dlist));

	}

	@RequestMapping(value = "/fetchdoctor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fetchDoctor(@RequestParam int id) {
		Doctor d = docserv.getDocbyID((long) id);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(d));
	}

	@RequestMapping(value = "/fetchtimeSlots", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fetchTimeSlots(@RequestParam int id) {
		List<String> d = docserv.getDocTimeSlots((long) id);
		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(d));
	}

}
