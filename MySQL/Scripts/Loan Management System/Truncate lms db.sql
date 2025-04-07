use loan_management_db;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE admin;
TRUNCATE TABLE customer;
TRUNCATE TABLE loan_officer;
TRUNCATE TABLE loan_payments;
TRUNCATE TABLE loan_schemes;
TRUNCATE TABLE loans;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;
