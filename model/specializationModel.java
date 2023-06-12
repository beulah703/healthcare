package spring.mail.orm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class specializationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specId")
    private int specId;
	@Column(name = "specTitle")
    private String specTitle;
	@Column(name = "specDesc")
    private String specDesc;

    public specializationModel() {
        // Default constructor
    }
    public specializationModel(int specId,String specTitle) {
    	
       this.specId=specId;
       this.specTitle=specTitle;
    }

    // Getter and setter methods for specId, specTitle, and specDesc

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecTitle() {
        return specTitle;
    }

    public void setSpecTitle(String specTitle) {
        this.specTitle = specTitle;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }
}
