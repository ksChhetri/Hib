package com.nt.cid;

import java.io.Serializable;

public class PrgmrProjId implements Serializable {
	private int prgmrId,projId;

	public int getPrgmrId() {
		return prgmrId;
	}

	public void setPrgmrId(int prgmrId) {
		this.prgmrId = prgmrId;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	@Override
	public String toString() {
		return "PrgmrProjId [prgmrId=" + prgmrId + ", projId=" + projId + "]";
	}
	
}
