package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCOURSES database table.
 * 
 */
@Entity
@Table(name="HCOURSES")
@NamedQuery(name="Hcours.findAll", query="SELECT h FROM Hcours h")
public class Hcours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long courseid;

	private String coursename;

	private String coursenumber;

	private BigDecimal credits;

	private String department;

	private String subject;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hcours")
	private List<Hclass> hclasses;

	public Hcours() {
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursenumber() {
		return this.coursenumber;
	}

	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHcours(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHcours(null);

		return hclass;
	}

}