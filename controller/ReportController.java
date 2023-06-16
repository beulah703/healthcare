package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.orm.services.ReportServices;

@Controller
@RequestMapping("/dcadmin")
public class ReportController {
	@Autowired
	ReportServices rs;

	@RequestMapping(value = "/DCReports")
	public String dcreports(Model model) {

		List<Object[]> tdata = rs.getTestData();

		model.addAttribute("tdata", tdata);

		return "dcadmin/dcreportspage";
	}

	@RequestMapping(value = "/revenue", method = RequestMethod.POST)
	public String viewRevenue(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("TestName") String name, @RequestParam("TestCategory") String category,
			@RequestParam("TestMethod") String method) {

		System.out.println(from + " " + to + " " + name + " " + category + " " + method);

		if (from.equals("")) {

		} else {

		}

		return null;

	}

}