package spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doct_id")
	private Long id;

	@Column(name = "doct_name")
	private String name;

	@Column(name = "doct_qual")
	private String qualification;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doct_spec_id")
	private Specialization specialization;

	@Column(name = "doct_photo")
	private String docphoto;
	@Column(name = "doct_exp")
	private int docexperience;

	@Column(name = "doct_cfee")
	private long comfee;

	public Doctor(Long id, String name, String qualification, Specialization specialization, String docphoto,
			int docexperience, long comfee) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.specialization = specialization;
		this.docphoto = docphoto;
		this.docexperience = docexperience;

		this.comfee = comfee;
	}

	public String getDocphoto() {
		return docphoto;
	}

	public void setDocphoto(String docphoto) {
		this.docphoto = docphoto;
	}

	public int getDocexperience() {
		return docexperience;
	}

	public void setDocexperience(int docexperience) {
		this.docexperience = docexperience;
	}

	public long getComfee() {
		return comfee;
	}

	public void setComfee(long comfee) {
		this.comfee = comfee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Doctor() {
//		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", qualification=" + qualification + ", specialization="
				+ specialization + ", docphoto=" + docphoto + ", docexperience=" + docexperience + ", comfee=" + comfee
				+ "]";
	}
}
