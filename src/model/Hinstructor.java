package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HINSTRUCTORS database table.
 * 
 */
@Entity
@Table(name="HINSTRUCTORS")
@NamedQuery(name="Hinstructor.findAll", query="SELECT h FROM Hinstructor h")
public class Hinstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long instructorid;

	private String department;

	private String officenumber;

	//bi-directional one-to-one association to Huser
	@OneToOne(mappedBy="hinstructor")
	private Huser huser;

	public Hinstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(String officenumber) {
		this.officenumber = officenumber;
	}

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

}