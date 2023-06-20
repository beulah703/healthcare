package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import spring.orm.dao.DoctorScheduleDao;
import spring.orm.dao.DoctorsDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.model.Doctor;
import spring.orm.model.entity.DoctorTemp;
import spring.orm.model.input.DoctorInput;
import spring.orm.services.DoctorOutputService;
import spring.orm.services.DoctorServices;

@Controller

public class DoctorController {

	@Autowired
	private DoctorServices ds;
	@Autowired
	private DoctorsDao docdao;

	@Autowired
	private SpecializationDao specdao;

	@Autowired
	private DoctorOutputService docoutput;

	@Autowired
	private DoctorScheduleDao docschdao;


	@RequestMapping(value = "admin/savedoc", method = RequestMethod.POST)
	public @ResponseBody String savespec(@ModelAttribute DoctorInput d, @RequestParam CommonsMultipartFile docphoto,
			Model model) {

		System.out.println(d);
		int docid=docoutput.addDoc(d, docphoto);
//		docschdao.addDoctorSchedule(d, docid);
		return "redirect:/admin/doctors";
	}

	@RequestMapping(value = "admin/doctors", method = RequestMethod.GET)
	public String getDoctorpage(Model m) {

//		m.addAttribute("docsche", docdao.getallDocSchedule());
		m.addAttribute("speclist", specdao.getAllSpec());

		return "admin/doctor";
	}

	@RequestMapping(value = "admin/updatedoc", method = RequestMethod.POST)
	public String updatedoc(@ModelAttribute DoctorInput d, @RequestParam CommonsMultipartFile docphoto, Model model) {
		// Doctor s = new Doctor(id, docname, docspec, docqual, docexp, docphoto, days,
		// docfrom, docto, docavgtime,
		// docfee);
		
		docdao.updatedoc(d,docphoto);
		List<Doctor> tm = docdao.getAllDoc();
//		System.out.println("Inside testdetails");

		return "redirect:/admin/doctor";
	}


	@RequestMapping(value = "admin/getdoc", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getdoc(@RequestParam("id") int id) {
		System.out.println("Entered");
		Doctor s = docdao.getdoc(id);

		Gson gson = new Gson();
		String json = gson.toJson(s);

		return ResponseEntity.ok(json);
	}

}