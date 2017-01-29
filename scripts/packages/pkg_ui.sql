create or replace package pkg_ui
is
function f_is_object_exists (pv_object_name VARCHAR2, pv_object_type VARCHAR2, pv_object_owner VARCHAR2 DEFAULT 'DBO') RETURN CHAR;
end;
/
CREATE OR REPLACE PACKAGE BODY PKG_UI
AS
  function f_is_object_exists (pv_object_name VARCHAR2, pv_object_type VARCHAR2, pv_object_owner VARCHAR2 DEFAULT 'DBO') RETURN CHAR
  AS
  
    -- TODO: Implementation required for function PKG_UI.f_is_object_exists
   v_dummy CHAR(1);
  ln_cnt Number :=0; --SM01
BEGIN
    if pv_object_owner = 'DBO' then
	  SELECT DECODE(COUNT(9), 0,'N', 'Y') INTO v_dummy
	    FROM all_objects
	--   WHERE owner = pv_object_owner
	   WHERE owner in ('DBO', 'WORKFLOW')
	     AND object_name = UPPER(pv_object_name)
	     AND object_type = DECODE(upper(pv_object_type), 'T','TABLE'
                            , 'I','INDEX'
                            , 'F','FUNCTION'
                            , 'P','PROCEDURE'
                          	, 'D','DATABASE LINK'
                            , 'PH','PACKAGE'
                            , 'PB','PACKAGE BODY'
                            , 'S','SEQUENCE'
                            , 'V','VIEW'
                            , 'TR','TRIGGER'
                            , 'IP','INDEX PARTITION'
                            ,	'SY','SYNONYM'
                            , 'TP','TABLE PARTITION'
                            , 'TY','TYPE'
                            , 'TB','TYPE BODY'
                            ,NULL);
                                        
   else
	  SELECT DECODE(COUNT(9), 0,'N', 'Y') INTO v_dummy
	    FROM all_objects
	   WHERE owner = pv_object_owner
	--   WHERE owner in ('DBO', 'WORKFLOW')
	     AND object_name = UPPER(pv_object_name)
	     AND object_type = DECODE(upper(pv_object_type), 'T','TABLE'
                            , 'I','INDEX'
                            , 'F','FUNCTION'
                            , 'P','PROCEDURE'
                          	, 'D','DATABASE LINK'
                            , 'PH','PACKAGE'
                            , 'PB','PACKAGE BODY'
                            , 'S','SEQUENCE'
                            , 'V','VIEW'
                            , 'TR','TRIGGER'
                            , 'IP','INDEX PARTITION'
                            ,	'SY','SYNONYM'
                            , 'TP','TABLE PARTITION'
                            , 'TY','TYPE'
                            , 'TB','TYPE BODY'
                            ,NULL);
   end if;
  RETURN v_dummy;

END f_is_object_exists;
end pkg_ui;
/

