CREATE USER dbo
  IDENTIFIED BY dbo;
GRANT create session TO dbo;
GRANT create table TO dbo;
GRANT create view TO dbo;
GRANT create any trigger TO dbo;
GRANT create any procedure TO dbo;
GRANT create sequence TO dbo;
GRANT create synonym TO dbo;
alter user dbo quota unlimited on users;
 -- DEFAULT TABLESPACE tbs_perm_01
--  TEMPORARY TABLESPACE tbs_temp_01
  --QUOTA 20M on tbs_perm_01;
