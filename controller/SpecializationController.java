package spring.orm.controller;

// import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.dao.SpecializationDao;
// import antlr.collections.List;
import spring.orm.model.Specialization;
import spring.orm.services.DoctorServices;

@Controller
public class SpecializationController {
	@Autowired
	DoctorServices ds;

	@Autowired
	private SpecializationDao specdao;

	@GetMapping("/getspecdetails")
	public String specdetails(Model model) {
		System.out.println("Inside testdetails");
		List<Specialization> tm = specdao.getAllSpec();
		System.out.println("Inside testdetails");

		model.addAttribute("tests", tm);
		return "/admin/specialization";

	}

	@RequestMapping(value = "admin/savespec", method = RequestMethod.POST)
	public String savespec(@RequestParam String idInput, @RequestParam String titleInput,
			@RequestParam String descriptionInput, Model model) {

		Specialization s = new Specialization(idInput, titleInput, descriptionInput);
		System.out.println("entered savespec");
		specdao.addSpec(s);
		List<Specialization> tm = specdao.getAllSpec();
		System.out.println("Inside testdetails");

		model.addAttribute("slist", tm);

		return "redirect:/admin/specialization";
	}

	@RequestMapping(value = "admin/updatespec", method = RequestMethod.POST)
	public String updatespec(@RequestParam String idInput, @RequestParam String titleInput,
			@RequestParam String descriptionInput, Model model) {

		Specialization s = new Specialization(idInput, titleInput, descriptionInput);
		System.out.println("entered savespec");
		specdao.updateSpec(s);
		List<Specialization> tm = specdao.getAllSpec();
		System.out.println("Inside testdetails");

		model.addAttribute("slist", tm);

		return "redirect:/admin/specialization";
	}

	// @PostMapping("/updatetest")
	//
	// public String updatespec(@RequestParam String idInput, @RequestParam String titleInput,
	// @RequestParam String descriptionInput, Model model) {
	// ) {
	//
	// ds.updatespec(idInput,titleInput,descriptionInput);
	// List<specialization> tm = ds.getspec();
	// System.out.println("Inside testdetails");
	//
	// model.addAttribute("tests", tm);
	//
	// return "testspage";
	// }

	// @RequestMapping(value = "/getspec", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	// public ResponseEntity<String> getspec(@RequestParam String id) {
	// System.out.println("Entered");
	// Specialization s = ds.gettestbyid(id);
	//
	// return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(s));
	// }

	@RequestMapping(value = "admin/getspec", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getspec(@RequestParam("id") String id) {
		System.out.println("Entered");
		Specialization s = specdao.getSpecialization(id);

		Gson gson = new Gson();
		String json = gson.toJson(s);

		return ResponseEntity.ok(json);
	}

	@RequestMapping(value = "/admin/delspec", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delspec(@RequestParam String id) {

		specdao.delSpec(id);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

}
