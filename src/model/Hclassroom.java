package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASSROOMS database table.
 * 
 */
@Entity
@Table(name="HCLASSROOMS")
@NamedQuery(name="Hclassroom.findAll", query="SELECT h FROM Hclassroom h")
public class Hclassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long classroomid;

	private String buildingname;

	private BigDecimal maxcapacity;

	private String roomnumber;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hclassroom")
	private List<Hclass> hclasses;

	public Hclassroom() {
	}

	public long getClassroomid() {
		return this.classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getBuildingname() {
		return this.buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public BigDecimal getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(BigDecimal maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public String getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHclassroom(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHclassroom(null);

		return hclass;
	}

}