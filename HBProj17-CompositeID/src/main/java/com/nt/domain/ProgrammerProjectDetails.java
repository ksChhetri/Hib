package com.nt.domain;

import com.nt.cid.PrgmrProjId;

public class ProgrammerProjectDetails {
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
