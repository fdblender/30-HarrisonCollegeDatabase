package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HSTUDENTS database table.
 * 
 */
@Entity
@Table(name="HSTUDENTS")
@NamedQuery(name="Hstudent.findAll", query="SELECT h FROM Hstudent h")
public class Hstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long studentid;

	private String entryyear;

	private String major;

	//bi-directional many-to-one association to Henrollment
	@OneToMany(mappedBy="hstudent")
	private List<Henrollment> henrollments;

	//bi-directional one-to-one association to Hperson
	@OneToOne(mappedBy="hstudent")
	private Hperson hperson;

	public Hstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getEntryyear() {
		return this.entryyear;
	}

	public void setEntryyear(String entryyear) {
		this.entryyear = entryyear;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Henrollment> getHenrollments() {
		return this.henrollments;
	}

	public void setHenrollments(List<Henrollment> henrollments) {
		this.henrollments = henrollments;
	}

	public Henrollment addHenrollment(Henrollment henrollment) {
		getHenrollments().add(henrollment);
		henrollment.setHstudent(this);

		return henrollment;
	}

	public Henrollment removeHenrollment(Henrollment henrollment) {
		getHenrollments().remove(henrollment);
		henrollment.setHstudent(null);

		return henrollment;
	}

	public Hperson getHperson() {
		return this.hperson;
	}

	public void setHperson(Hperson hperson) {
		this.hperson = hperson;
	}

}