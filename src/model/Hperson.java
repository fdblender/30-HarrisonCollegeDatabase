package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HPERSONS database table.
 * 
 */
@Entity
@Table(name="HPERSONS")
@NamedQuery(name="Hperson.findAll", query="SELECT h FROM Hperson h")
public class Hperson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long personid;

	private String email;

	private String firstname;
	
	private String hashedpassword;

	private String lastname;

	private String salt;

	//bi-directional one-to-one association to Hinstructor
	@OneToOne
	@PrimaryKeyJoinColumn(name="PERSONID", referencedColumnName="PERSONID")
	private Hinstructor hinstructor;

	//bi-directional one-to-one association to Hstudent
	@OneToOne
	@PrimaryKeyJoinColumn(name="PERSONID", referencedColumnName="PERSONID")
	private Hstudent hstudent;

	public Hperson() {
	}

	public long getPersonid() {
		return this.personid;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Hinstructor getHinstructor() {
		return this.hinstructor;
	}

	public void setHinstructor(Hinstructor hinstructor) {
		this.hinstructor = hinstructor;
	}

	public Hstudent getHstudent() {
		return this.hstudent;
	}

	public void setHstudent(Hstudent hstudent) {
		this.hstudent = hstudent;
	}

}