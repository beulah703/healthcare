package spring.orm.model.outputModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PatientMedicalProfile")
public class PatientMedicalProfile {
	@Id
	@Column(name = "patn_id")
    private int patn_id;
	@Column(name = "patn_appn_id")
    private int patn_appn_id;
	@Column(name = "patn_parameter")
    private String patn_parameter;
	@Column(name = "patn_pargroup")
    private String patnParGroup;
	@Column(name = "patn_value")
    private String patn_value;

    public PatientMedicalProfile() {
        super();
    }

    public PatientMedicalProfile(int patnId, int patnAppnId, String patnParameter, String patnParGroup, String patnValue) {
        this.patn_id = patnId;
        this.patn_appn_id = patnAppnId;
        this.patn_parameter = patnParameter;
        this.patnParGroup = patnParGroup;
        this.patn_value = patnValue;
    }

    public int getPatnId() {
        return patn_id;
    }

    public void setPatnId(int patnId) {
        this.patn_id = patnId;
    }

    public int getPatnAppnId() {
        return patn_appn_id;
    }

    public void setPatnAppnId(int patnAppnId) {
        this.patn_appn_id = patnAppnId;
    }

    public String getPatnParameter() {
        return patn_parameter;
    }

    public void setPatnParameter(String patnParameter) {
        this.patn_parameter = patnParameter;
    }

    public String getPatnParGroup() {
        return patnParGroup;
    }

    public void setPatnParGroup(String patnParGroup) {
        this.patnParGroup = patnParGroup;
    }

    public String getPatnValue() {
        return patn_value;
    }

    public void setPatnValue(String patnValue) {
        this.patn_value = patnValue;
    }
}

