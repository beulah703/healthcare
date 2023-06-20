package spring.orm.model.input;

import java.sql.Date;

public class AppointmentForm {
	private String specialization;
	private Date appointmentDate;
	private String doctor;
	private String slots;
	private String bookingType;
	private String familyMembers;

	// Getters and Setters

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = Date.valueOf(appointmentDate);
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getFamilyMembers() {
		return familyMembers;
	}

	@Override
	public String toString() {
		return "AppointmentForm [specialization=" + specialization + ", appointmentDate=" + appointmentDate
				+ ", doctor=" + doctor + ", slots=" + slots + ", bookingType=" + bookingType + ", familyMembers="
				+ familyMembers + "]";
	}

	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}
}
