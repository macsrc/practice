SELECT * FROM petclinic.cacdlg_tb;

SELECT * -- cdlg_code, cdlg_code_name
 FROM petclinic.cacdlg_tb where cdlg_grp_code = 'CORE'
 order by cdlg_code;

insert into petclinic.cacdlg_tb values ('CORE', 'WF', 'Web Framework', curdate(), curdate() );

SELECT distinct cdlg_grp_code FROM petclinic.cacdlg_tb;

SELECT * FROM petclinic.cacdlg_tb where cdlg_grp_code = 'CN';

/**
CM	Common
GN	Gender
JV	Java Skills
NM	Number
PT	Parts
SL	Sales
SV	Service
WF	Web Framework
*/

INSERT INTO `petclinic`.`cacdlg_tb`
(`CDLG_GRP_CODE`,
`CDLG_CODE`,
`CDLG_CODE_NAME`,
`CDLG_CRTE_DTIME`,
`CDLG_UPDT_DTIME`)
VALUES
('WF', 'WF06', 'Apache Wicket', curdate(), curdate() );

