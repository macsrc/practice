package com.mkyong.form.model;

import java.util.Date;

public class Cacdlg {

	private Long id;
	private String CDLG_GRP_CODE;
	private String CDLG_CODE;
	private String CDLG_CODE_NAME;
	private Date CDLG_CRTE_DTIME;
	private Date CDLG_UPDT_DTIME;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCDLG_GRP_CODE() {
		return CDLG_GRP_CODE;
	}

	public void setCDLG_GRP_CODE(String cDLG_GRP_CODE) {
		CDLG_GRP_CODE = cDLG_GRP_CODE;
	}

	public String getCDLG_CODE() {
		return CDLG_CODE;
	}

	public void setCDLG_CODE(String cDLG_CODE) {
		CDLG_CODE = cDLG_CODE;
	}

	public String getCDLG_CODE_NAME() {
		return CDLG_CODE_NAME;
	}

	public void setCDLG_CODE_NAME(String cDLG_CODE_NAME) {
		CDLG_CODE_NAME = cDLG_CODE_NAME;
	}

	public Date getCDLG_CRTE_DTIME() {
		return CDLG_CRTE_DTIME;
	}

	public void setCDLG_CRTE_DTIME(Date cDLG_CRTE_DTIME) {
		CDLG_CRTE_DTIME = cDLG_CRTE_DTIME;
	}

	public Date getCDLG_UPDT_DTIME() {
		return CDLG_UPDT_DTIME;
	}

	public void setCDLG_UPDT_DTIME(Date cDLG_UPDT_DTIME) {
		CDLG_UPDT_DTIME = cDLG_UPDT_DTIME;
	}

}
