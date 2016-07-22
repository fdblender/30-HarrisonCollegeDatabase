package model;

import java.io.Serializable;
import javax.persistence.*;


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

	//bi-directional one-to-one association to Huser
	@OneToOne(mappedBy="hstudent")
	private Huser huser;

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

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

}