package spring.orm.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.orm.dao.DocScheduleDao;
import spring.orm.dao.DoctorsDao;
import spring.orm.dao.SpecializationDao;
import spring.orm.model.DoctorSchedule;
import spring.orm.model.Specialization;
import spring.orm.model.entity.DoctorTemp;
import spring.orm.model.input.DoctorInput;
import spring.orm.model.output.DoctorOutPutModel;

@Service
public class DoctorOutputService {

	@Autowired
	private DocScheduleDao docschedao;

	@Autowired
	private SpecializationDao specdao;

	@Autowired
	private DoctorsDao docdao;

	public List<DoctorOutPutModel> getAllDocBySpec(String spec) {
		// System.out.println(spec);
		return docdao.getallDocScheduleBySpec(spec);
	}

	public List<DoctorOutPutModel> getAllDocBySpecDate(String specialization, Date appointmentDated) {
		// TODO Auto-generated method stub
		List<DoctorOutPutModel> docspec = new ArrayList<>();
		System.out.println("function called" + specialization + appointmentDated + docspec);
		for (DoctorOutPutModel d : docdao.getallDocScheduleBySpec(specialization)) {
			if (isDocAvailOnTheDay(d.getWeekday(), appointmentDated)) {
				System.out.println(d);
				docspec.add(d);
			}
		}

		return docspec;
	}

	private boolean isDocAvailOnTheDay(String sdays, Date appointmentDated) {
		// TODO Auto-generated method stub
		// DoctorSchedule sc = docschdao.getDocSchedulebyId(i);
		// String sdays = sc.getWeekday();
		if (sdays.equals("ALL")) {
			return true;
		} else {
			return isAvailDay(sdays, appointmentDated.getDay());
		}

		// return false;
	}

	public boolean isAvailDay(String days, int i) {
		Map<String, Integer> daymap = new HashMap<>();
		daymap.put("MON", 1);
		daymap.put("TUE", 2);
		daymap.put("WED", 3);
		daymap.put("THU", 4);
		daymap.put("WED", 5);
		daymap.put("FRI", 5);
		daymap.put("SAT", 6);
		daymap.put("SUN", 0);
		daymap.put("M", 1);
		daymap.put("T", 2);
		daymap.put("W", 3);
		daymap.put("H", 4);
		daymap.put("F", 5);
		daymap.put("S", 6);
		daymap.put("U", 0);

		if (daymap.containsKey(days)) {
			if (daymap.get(days) == i)
				return true;
			return false;

		} else {
			boolean temp = false;
			for (char c : days.toCharArray()) {
				System.out.println(days + " " + c);
				if (daymap.get(String.valueOf(c)) == i) {
					temp = true;
				}
			}
			return temp;
		}
		// return false;
	}

	public DoctorOutPutModel getDocbyID(int id) {
		// TODO Auto-generated method stub
		return docdao.getDocById(id);
	}

	public List<String> getDocTimeSlots(int id) {
		DoctorSchedule s = docschedao.getSchedulebyId(id);
		return generateTimeSlots(s.getTimeFrom(), s.getTimeTo(), s.getAverageAppointmentTime());
	}

	public List<String> generateTimeSlots(String fromTime, String toTime, int avgTime) {
		List<String> timeSlots = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
		DateTimeFormatter outformat = DateTimeFormatter.ofPattern("hh:mm a");
		LocalTime startTime = LocalTime.parse(fromTime, formatter);
		LocalTime endTime = LocalTime.parse(toTime, formatter);

		while (startTime.isBefore(endTime)) {
			timeSlots.add(startTime.format(outformat));
			startTime = startTime.plusMinutes(avgTime);
		}

		return timeSlots;
	}

	public int addDoc(DoctorInput d, CommonsMultipartFile pic) {
		DoctorTemp dt = new DoctorTemp();
		Specialization s = specdao.getSpecialization(d.getDocspec());
		dt.setDoctCfee(d.getDocfee());
		dt.setDoctExp(d.getDocexp());
		dt.setDoctPhoto(pic.getBytes());
		dt.setDoctQual(d.getDocqual());
		dt.setDoctName(d.getDocname());
		dt.setSpecialization(s);

		return dt.getDoctId();

	}

}
