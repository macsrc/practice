package com.boraji.tutorial.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "CACDLG_TB")
public class Cacdlg {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "CDLG_GRP_CODE")
	@Size(max = 20, min = 3, message = "{cacdlg.CDLG_GRP_CODE.invalid}")
	private String CDLG_GRP_CODE;

	@Column(name = "CDLG_CODE")
	@Size(max = 40, min = 2, message = "{cacdlg.CDLG_CODE.invalid}")
	private String CDLG_CODE;

	@Column(name = "CDLG_CODE_NAME")
	@Size(max = 40, min = 2, message = "{cacdlg.CDLG_CODE_NAME.invalid}")
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
