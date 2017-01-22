/*
Project: Expeses APP
Submitted Date: 21/01/2017
Submitted By: N. Narendra
Description: Script to query all values from Dept table
*/
declare
ln_count number;
begin
select count(1) into ln_count from DEPT;
commit;
end;