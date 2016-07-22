package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HENROLLMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Henrollment.findAll", query="SELECT h FROM Henrollment h")
public class Henrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long enrollmentid;

	private String grade;

	//bi-directional many-to-one association to Huser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Huser huser;

	//bi-directional many-to-one association to Hclass
	@ManyToOne
	@JoinColumn(name="CLASSID")
	private Hclass hclass;

	public Henrollment() {
	}

	public long getEnrollmentid() {
		return this.enrollmentid;
	}

	public void setEnrollmentid(long enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

	public Hclass getHclass() {
		return this.hclass;
	}

	public void setHclass(Hclass hclass) {
		this.hclass = hclass;
	}

}