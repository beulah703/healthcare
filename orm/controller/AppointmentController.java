package spring.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.orm.services.DoctorServices;

@Controller
public class AppointmentController {
	@Autowired
	private DoctorServices dsc;

	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String nothing(Model m) {

		return "common/appointment";
	}
}
