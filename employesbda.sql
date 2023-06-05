/* 
    this script is made by zedone for creating user EmployesBDA that has certain privileges
    SELECT,INSERT,UPDATE ON EMPLOYE
    SELECT ON INTERVENTIONS
    SELECT ON INTERVENANTS
*/

connect SYSTEM/root 
/*change root with your password */

create user EmployesBDA IDENTIFIED BY root 
/*change root here too*/

/* Let Create a role !*/
create role EMPLOYE_ADMIN;
grant SELECT,INSERT,UPDATE ON EMPLOYE to EMPLOYE_ADMIN;
grant SELECT on INTERVENANTS to EMPLOYE_ADMIN;
grant SELECT on INTERVENTIONS  to EMPLOYE_ADMIN;
grant create session to EMPLOYE_ADMIN;
grant create SYNONYM to EMPLOYE_ADMIN

grant EMPLOYE_ADMIN to EmployesBDA;
connect EmployesBDA/root 
/*change password*/

/*SET SYNONYM TO WORKS WITH MY DATABASE*/

create SYNONYM EMPLOYE FOR SYSTEM.EMPLOYE;
create SYNONYM INTERVENTIONS FOR SYSTEM.INTERVENTIONS;
create SYNONYM INTERVENANTS FOR SYSTEM.INTERVENANTS;

