package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hinstructor")
	private List<Hclass> hclasses;

	//bi-directional one-to-one association to Hperson
	@OneToOne(mappedBy="hinstructor")
	private Hperson hperson;

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

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHinstructor(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHinstructor(null);

		return hclass;
	}

	public Hperson getHperson() {
		return this.hperson;
	}

	public void setHperson(Hperson hperson) {
		this.hperson = hperson;
	}

}