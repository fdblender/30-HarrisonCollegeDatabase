package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASSES database table.
 * 
 */
@Entity
@Table(name="HCLASSES")
@NamedQuery(name="Hclass.findAll", query="SELECT h FROM Hclass h")
public class Hclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long classid;

	private String crn;

	private String description;

	//bi-directional many-to-one association to Hclassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private Hclassroom hclassroom;

	//bi-directional many-to-one association to Hcours
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Hcours hcours;

	//bi-directional many-to-one association to Hinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hinstructor hinstructor;

	//bi-directional many-to-one association to Henrollment
	@OneToMany(mappedBy="hclass")
	private List<Henrollment> henrollments;

	public Hclass() {
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Hclassroom getHclassroom() {
		return this.hclassroom;
	}

	public void setHclassroom(Hclassroom hclassroom) {
		this.hclassroom = hclassroom;
	}

	public Hcours getHcours() {
		return this.hcours;
	}

	public void setHcours(Hcours hcours) {
		this.hcours = hcours;
	}

	public Hinstructor getHinstructor() {
		return this.hinstructor;
	}

	public void setHinstructor(Hinstructor hinstructor) {
		this.hinstructor = hinstructor;
	}

	public List<Henrollment> getHenrollments() {
		return this.henrollments;
	}

	public void setHenrollments(List<Henrollment> henrollments) {
		this.henrollments = henrollments;
	}

	public Henrollment addHenrollment(Henrollment henrollment) {
		getHenrollments().add(henrollment);
		henrollment.setHclass(this);

		return henrollment;
	}

	public Henrollment removeHenrollment(Henrollment henrollment) {
		getHenrollments().remove(henrollment);
		henrollment.setHclass(null);

		return henrollment;
	}

}