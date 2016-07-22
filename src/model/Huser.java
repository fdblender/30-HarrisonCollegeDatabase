package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HUSERS database table.
 * 
 */
@Entity
@Table(name="HUSERS")
@NamedQuery(name="Huser.findAll", query="SELECT h FROM Huser h")
public class Huser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String firstname;

	private String hashedpassword;

	private BigDecimal isinstructor;

	private String lastname;

	private String salt;

	private String useremail;

	//bi-directional many-to-one association to Henrollment
	@OneToMany(mappedBy="huser")
	private List<Henrollment> henrollments;

	//bi-directional one-to-one association to Hstudent
	@OneToOne
	@JoinColumn(name="STUDENTID")
	private Hstudent hstudent;

	//bi-directional one-to-one association to Hinstructor
	@OneToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hinstructor hinstructor;

	public Huser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHashedpassword() {
		return this.hashedpassword;
	}

	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}

	public BigDecimal getIsinstructor() {
		return this.isinstructor;
	}

	public void setIsinstructor(BigDecimal isinstructor) {
		this.isinstructor = isinstructor;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public List<Henrollment> getHenrollments() {
		return this.henrollments;
	}

	public void setHenrollments(List<Henrollment> henrollments) {
		this.henrollments = henrollments;
	}

	public Henrollment addHenrollment(Henrollment henrollment) {
		getHenrollments().add(henrollment);
		henrollment.setHuser(this);

		return henrollment;
	}

	public Henrollment removeHenrollment(Henrollment henrollment) {
		getHenrollments().remove(henrollment);
		henrollment.setHuser(null);

		return henrollment;
	}

	public Hstudent getHstudent() {
		return this.hstudent;
	}

	public void setHstudent(Hstudent hstudent) {
		this.hstudent = hstudent;
	}

	public Hinstructor getHinstructor() {
		return this.hinstructor;
	}

	public void setHinstructor(Hinstructor hinstructor) {
		this.hinstructor = hinstructor;
	}

}