package spring.mail.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DoctorSchedule")
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doct_id")
    private int doctorId;

    @Column(name = "weekday")
    private String weekday;

    @Column(name = "dcsc_timefrom")
    private String timeFrom;

    @Column(name = "dcsc_timeto")
    private String timeTo;

    @Column(name = "scsc_avgat")
    private int averageAppointmentTime;

    // Constructors, getters, and setters

    public DoctorSchedule() {
    }

    public DoctorSchedule(String weekday, String timeFrom, String timeTo, int averageAppointmentTime) {
        this.weekday = weekday;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.averageAppointmentTime = averageAppointmentTime;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public int getAverageAppointmentTime() {
        return averageAppointmentTime;
    }

    public void setAverageAppointmentTime(int averageAppointmentTime) {
        this.averageAppointmentTime = averageAppointmentTime;
    }
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return weekday+" "+timeFrom+" "+timeTo+" "+averageAppointmentTime;
	}
}
