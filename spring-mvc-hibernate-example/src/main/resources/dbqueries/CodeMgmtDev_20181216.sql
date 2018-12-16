SELECT * FROM petclinic.cacdlg_tb;

SELECT cdlg_code, cdlg_code_name
 FROM petclinic.cacdlg_tb where cdlg_grp_code = 'CN'
 order by cdlg_code;



insert into petclinic.cacdlg_tb values ('CORE', 'C', 'Common', curdate(), curdate() );

SELECT * FROM petclinic.cacdlg_tb where cdlg_grp_code = 'CN';

SELECT * FROM petclinic.cacdlg_tb where cdlg_grp_code = 'CN';


INSERT INTO `petclinic`.`cacdlg_tb`
(`CDLG_GRP_CODE`,
`CDLG_CODE`,
`CDLG_CODE_NAME`,
`CDLG_CRTE_DTIME`,
`CDLG_UPDT_DTIME`)
VALUES
('CN', 'SP', 'Singapore', curdate(), curdate() );

