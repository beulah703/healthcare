package spring.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import spring.orm.dao.SpecializationDao;
import spring.orm.model.Specialization;

@Controller
public class MasterEntryController {

	@Autowired
	private SpecializationDao specdao;

	@RequestMapping(value = "/admin/getspec", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> getspec(@RequestParam String id) {
		System.out.println("Entered");
		Specialization s = specdao.getSpecialization(id);

		return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(s));
	}

	@RequestMapping(value = "/admin/delspec", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delspec(@RequestParam String id) {

		specdao.delSpec(id);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

}
