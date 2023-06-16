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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import spring.orm.dao.DoctorsDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.model.Doctor;
import spring.orm.services.DoctorServices;

@Controller

public class DoctorController {

	@Autowired
	private DoctorServices ds;
	@Autowired
	private DoctorsDao docdao;

	@Autowired
	private SpecializationDao specdao;

	@RequestMapping(value = "admin/savedoc", method = RequestMethod.POST)
	public String savespec(@ModelAttribute Doctor d, @RequestParam CommonsMultipartFile docphoto, Model model) {

		// Doctor s = new Doctor(id, docname, docspec, docqual, docexp, docphoto, days,
		// docfrom, docto, docavgtime,
		// docfee);
		System.out.println("entered savespec");
		docdao.adddoc(d);
		List<Doctor> tm = docdao.getAllDoc();

		model.addAttribute("slist", tm);
		model.addAttribute("speclist", specdao.getAllSpec());

		return "redirect:/admin/doctor";
	}

	@RequestMapping(value = "admin/doctors", method = RequestMethod.GET)
	public String getDoctorpage(Model m) {

		m.addAttribute("docsche", docdao.getallDocSchedule());
		m.addAttribute("speclist", specdao.getAllSpec());

		return "admin/doctor";
	}

	@RequestMapping(value = "admin/updatedoc", method = RequestMethod.POST)
	public String updatedoc(@ModelAttribute Doctor d, @RequestParam CommonsMultipartFile docphoto, Model model) {
		// Doctor s = new Doctor(id, docname, docspec, docqual, docexp, docphoto, days,
		// docfrom, docto, docavgtime,
		// docfee);
		d.setDocphoto(docphoto.getOriginalFilename());
		docdao.updatedoc(d);
		List<Doctor> tm = docdao.getAllDoc();
		System.out.println("Inside testdetails");

		model.addAttribute("slist", tm);
		model.addAttribute("speclist", specdao.getAllSpec());

		return "redirect:/admin/doctor";
	}

	// @RequestMapping(value = "admin/savedoc", method = RequestMethod.POST)
	// public String insertdoc(@RequestParam String docname, @RequestParam String
	// docspec, @RequestParam String docqual,
	// @RequestParam String docexp, @RequestParam CommonsMultipartFile docphoto,
	// @RequestParam String days,
	// @RequestParam String docfrom, @RequestParam String docto, @RequestParam
	// String docavgtime,
	// @RequestParam String docfee, HttpSession s) throws IllegalStateException,
	// IOException
	//
	// {
	// String uploadpath = s.getServletContext().getRealPath("/") +
	// "admin/dochotos/";
	// File dir = new File(uploadpath);
	// if (!dir.exists()) {
	// dir.mkdirs();
	// }
	// String filePath = uploadpath + docphoto.getOriginalFilename();
	// File dest = new File(filePath);
	// docphoto.transferTo(dest);
	// System.out.println(docphoto.getOriginalFilename() + filePath);
	// System.out.println(dest.getAbsolutePath());
	//
	// // ds.storedata(docname, docspec, docqual, docexp,
	// docphoto.getOriginalFilename(), days, docfrom, docto,
	// // docavgtime, docfee);
	// return "doctors";
	// }

	@RequestMapping(value = "admin/getdoc", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getdoc(@RequestParam("id") int id) {
		System.out.println("Entered");
		Doctor s = docdao.getdoc(id);

		Gson gson = new Gson();
		String json = gson.toJson(s);

		return ResponseEntity.ok(json);
	}

}
