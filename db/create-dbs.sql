/* DELETE 'easyBooking' database*/
DROP SCHEMA easyBooking;
/* DELETE USER 'easyBooking_user1' AT LOCAL SERVER*/
DROP USER 'easyBooking_user1'@'%';

/* CREATE 'easyBooking' DATABASE */
CREATE SCHEMA easyBooking;
/* CREATE THE USER 'easyBooking_user1' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'easyBooking_user1'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'easyBooking_user1' AT LOCAL SERVER*/
GRANT ALL ON easyBooking.* TO 'easyBooking_user1'@'%';