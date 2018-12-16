
--------------- TABLE dEFINIITON --------------------------
Table : CACDLG_TB Table
	Primary Key : CDLG_GRP_CODE, CDLG_CODE, CDLG_LANG_CODE, 
	Table Fields 
		CDLG_GRP_CODE:varchar2(7):\n - dropdown label/field
		CDLG_CODE:varchar2(7):\n     - dropdown options code/id
		CDLG_LANG_CODE:varchar2(3):\n
		CDLG_CODE_NAME:varchar2(100):\n - dropdown option description as displayed
		CDLG_CRTE_EMP_NO:varchar2(10):\n
		CDLG_CRTE_DTIME:date:\n
		CDLG_UPDT_EMP_NO:varchar2(10):\n
		CDLG_UPDT_DTIME:date:\n

	
Table : CACODE_TB Table
	Primary Key : CODE_GRP_CODE, CODE_CODE, 
	Table Fields 
		CODE_GRP_CODE:varchar2(7):\n - dropdown label
		CODE_CODE:varchar2(7):\n
		CODE_APPLY_STRT_DATE:varchar2(8):\n
		CODE_APPLY_FNSH_DATE:varchar2(8):\n
		CODE_USED_YN:varchar2(1):\n
		CODE_SCTN_TYPE:varchar2(1):\n - section e.g. conservation acquisition, mitigation etc.
		CODE_DMS_YN:varchar2(1):\n
		CODE_PRIORITY:number(2):\n
		CODE_CRTE_EMP_NO:varchar2(10):\n
		CODE_CRTE_DTIME:date:\n
		CODE_UPDT_EMP_NO:varchar2(10):\n
		CODE_UPDT_DTIME:date:\n			

--------------- CACODE_TB --------------------------
cacdlg_tb - getUpdateSql(){
		
		query.append("UPDATE CACDLG_TB SET ")
		  
			.append("CDLG_UPDT_DTIME = SYSDATE" )
		
  			.append(",CDLG_CODE_NAME = ?")
		
  			.append(",CDLG_CRTE_EMP_NO = ?")
		
  			.append(",CDLG_CRTE_DTIME = ?")
		
  			.append(",CDLG_UPDT_EMP_NO = ?")
		
			.append(" WHERE 1=1 ")
		  		  
			.append(" AND CDLG_GRP_CODE = ? ")
		  
			.append(" AND CDLG_CODE = ? ")
		  
			.append(" AND CDLG_LANG_CODE = ? ")

cacdlg_tb - getDeleteSql(){
		
		.append("DELETE FROM CACDLG_TB WHERE  1=1")
		 
		.append(" AND CDLG_CMPN_NO = ? ")
		 
		.append(" AND CDLG_CORP_NO = ? ")
		 
		.append(" AND CDLG_GRP_CODE = ? ")
		 
		.append(" AND CDLG_CODE = ? ")
		 
		.append(" AND CDLG_LANG_CODE = ? ")
		
cacdlg_tb - getUpdateOnlySql(String[] fields)

		query.append("UPDATE  CACDLG_TB  SET " );
		for(int i=0 ; i < fields.length ; i++){
			if ( i > 0 )
				query.append(", ");
			query.append(fields[i]).append(" = ? ");
        } 
   		query.append( " WHERE  1=1 ");
		 		 
		query.append(" AND CDLG_GRP_CODE =  ? ");
		 
		query.append(" AND CDLG_CODE =  ? ");
		 
		query.append(" AND CDLG_LANG_CODE =  ? ");
		
--------------- CACODE_TB --------------------------		
			
cacode_tb - getUpdateSql
		
			.append("UPDATE CACODE_TB SET ")
		  
			.append("CODE_UPDT_DTIME = SYSDATE" )
		
  			.append(",CODE_APPLY_STRT_DATE = ?")
		
  			.append(",CODE_APPLY_FNSH_DATE = ?")
		
  			.append(",CODE_USED_YN = ?")
		
  			.append(",CODE_SCTN_TYPE = ?")
		
  			.append(",CODE_DMS_YN = ?")
		
  			.append(",CODE_PRIORITY = ?")
		
  			.append(",CODE_CRTE_EMP_NO = ?")
		
  			.append(",CODE_CRTE_DTIME = ?")
		
  			.append(",CODE_UPDT_EMP_NO = ?")
		
			.append(" WHERE 1=1 ")
		    
			.append(" AND CODE_GRP_CODE = ? ")
		  
			.append(" AND CODE_CODE = ? ")
		
cacode_tb: selectQuery
		query.append("SELECT CODE_GRP_CODE,CODE_CODE,CODE_APPLY_STRT_DATE,
		CODE_APPLY_FNSH_DATE,CODE_USED_YN,CODE_SCTN_TYPE,CODE_DMS_YN,CODE_PRIORITY,
		CODE_CRTE_EMP_NO,CODE_CRTE_DTIME,CODE_UPDT_EMP_NO,CODE_UPDT_DTIME  ")
		
		.append("FROM  CACODE_TB ")
		.append(" WHERE 1 = 1 ")
		 
		.append(" AND CODE_GRP_CODE = ? ")
		 
		.append(" AND CODE_CODE = ? ")
		 
		 
--------------- Code management Queries --------------------------

Code Management - select list of records for a tabular resultset
	selectSearch( SelectParameterObject param, String grpCd,String section, String made, String used, String lang )	

			.append("SELECT ")
			.append(" TCNT ")
			.append(" ,CODE_CODE AS C_C_CODE")
			.append(" ,C_C_SCTN")
			.append(" ,C_C_STRT AS C_C_STRT")
			.append(" ,C_C_FNSH AS C_C_FNSH")
			.append(", C_C_USED")
			.append(", GETCODENAME(CODE_GRP_CODE, CODE_CODE,'ENG') AS C_C_NAME ")
			.append(" FROM (SELECT * FROM ( SELECT ")
			.append(" COUNT(*) OVER() AS TCNT ") 
			.append(", CODE_CODE  ")
			.append(", DECODE(CODE_SCTN_TYPE , 'C','Common','S','Sale','R','Repair','P','Part') AS C_C_SCTN ") // Need to be updated for sections
			.append(", CODE_APPLY_STRT_DATE AS C_C_STRT ")
			.append(", CODE_APPLY_FNSH_DATE AS C_C_FNSH ")
			.append(", CODE_USED_YN AS C_C_USED ")
			.append(", CODE_GRP_CODE ")
			.append(", ROWNUM AS C_C_NO ")
			.append(" FROM ")
			.append(" CACODE_TB ")
			.append(" WHERE ")
			.append(" CODE_GRP_CODE = ? ");
			
		if ( section != null && !section.trim().equals("") ) {
			query.append(" AND CODE_SCTN_TYPE = ? ");
		} 
		
		if ( made != null && !made.trim().equals("" ) ) {
			query.append(" AND CODE_DMS_YN = ? ");	
		}	
		
		if ( used != null && !used.trim().equals("") ) {
			query.append(" AND CODE_USED_YN = ? ");
		} 

		query.append(" ) ")	// select table end
			.append(" WHERE C_C_NO BETWEEN (? - 1) * ? +1 AND ? * ? ) ");		 
			

-- Code Management - selectQuery to get code details			
	public RecordSet selectSearchCodes( SelectParameterObject param, String grpCd , String lang)throws HmcSQLException, HmcSystemException {

			.append(" SELECT ")
			.append("  CODE_GRP_CODE AS C_H_CGRP ")
			.append(", CODE_CODE AS C_H_CODE ")
			.append(" ,CODE_APPLY_STRT_DATE AS C_H_STRT")
			.append(" ,CODE_APPLY_FNSH_DATE AS C_H_FNSH")
			.append(", CODE_USED_YN AS C_H_USED ")
			.append(", CODE_PRIORITY AS C_H_PRTY ")
			.append(", CDLG_CODE_NAME AS C_H_NAME ")
			.append(" FROM ")
			.append(" CACODE_TB, CACDLG_TB ")
			.append(" WHERE ")
			.append(" CODE_GRP_CODE = ? ")		
			.append(" AND CODE_CMPN_NO = CDLG_CMPN_NO")
			.append(" AND CODE_CORP_NO = CDLG_CORP_NO")
			.append(" AND CODE_GRP_CODE = CDLG_GRP_CODE")
			.append(" AND CODE_CODE = CDLG_CODE")
			.append(" AND CDLG_LANG_CODE = ?");
			