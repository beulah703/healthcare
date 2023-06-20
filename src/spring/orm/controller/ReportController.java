package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.orm.services.ReportServices;

@Controller
@RequestMapping("/dcadmin")
public class ReportController {

	@Autowired
	ReportServices rs;

	@RequestMapping(value = "/upload")
	public String dcreports(Model model) {
		List<Object[]> tdata = rs.getTestData();
		model.addAttribute("tdata", tdata);
		return "dcadmin/dcreportspage";
	}

	@RequestMapping(value = "/DCReports", method = RequestMethod.GET)
	public String reports() {

		return "dcadmin/DCReport";

	}

	@RequestMapping(value = "/uploaddata", method = RequestMethod.GET)
	public String upreports() {

		return "dcadmin/ReportData";

	}
	@RequestMapping(value="/testprofitdata",method = RequestMethod.GET)
	public String TestProfitData() {
		System.out.println("hello");
		return "dcadmin/TestProfitData";
	}
	
	@RequestMapping(value="/testDateWiseProfitdata",method = RequestMethod.GET)
	public String TestDateWiseProfitData() {
		System.out.println("hello");
		return "dcadmin/TestProfitDateWiseData";
	}

}