package spring.orm.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.orm.dao.SpecializationDao;
import spring.orm.services.DoctorServices;

@Controller

public class DoctorController {

	@Autowired
	private DoctorServices ds;
	@Autowired
	private SpecializationDao specdao;


	@RequestMapping(value = "admin/doctors", method = RequestMethod.GET)
	public String getDoctorpage(Model m) {

		m.addAttribute("speclist",specdao.getAllSpec());
		return "admin/doctor";
	}
	
	
	@RequestMapping(value="admin/savedoc" ,method=RequestMethod.POST)
	public String insertdoc(@RequestParam String docname, @RequestParam String docspec, @RequestParam String docqual,
			@RequestParam String docexp, @RequestParam CommonsMultipartFile docphoto, @RequestParam String days,
			@RequestParam String docfrom, @RequestParam String docto, @RequestParam String docavgtime,
			@RequestParam String docfee,HttpSession s) throws IllegalStateException, IOException

	{
		String uploadpath=s.getServletContext().getRealPath("/")+"admin/dochotos/";
		File dir= new File(uploadpath);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		String filePath = uploadpath+docphoto.getOriginalFilename();
		File dest = new File(filePath);
		docphoto.transferTo(dest);
		System.out.println(docphoto.getOriginalFilename()+ filePath);
		System.out.println(dest.getAbsolutePath());

//		ds.storedata(docname, docspec, docqual, docexp, docphoto.getOriginalFilename(), days, docfrom, docto, docavgtime, docfee);
		return "doctors";
	}

}
