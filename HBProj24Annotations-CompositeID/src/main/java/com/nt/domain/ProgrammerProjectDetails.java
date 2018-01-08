package com.nt.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nt.cid.PrgmrProjId;

@Entity
@Table(name="Programmers_projects")
public class ProgrammerProjectDetails {
	@EmbeddedId
	private PrgmrProjId  id;
	private String prgmrName;
	private String projName;

	public PrgmrProjId getId() {
		return id;
	}

	public void setId(PrgmrProjId id) {
		this.id = id;
	}

	public String getPrgmrName() {
		return prgmrName;
	}

	public void setPrgmrName(String prgmrName) {
		this.prgmrName = prgmrName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectDetails [id=" + id + ", prgmrName=" + prgmrName + ", projName=" + projName + "]";
	}

	
}
