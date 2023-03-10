DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS TRANSACTIONS;
CREATE TABLE IF NOT EXISTS CUSTOMER (CUSTOMER_ID int, CUSTOMER_NAME VARCHAR(25), EMAIL VARCHAR(50) );
CREATE TABLE IF NOT EXISTS TRANSACTIONS (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL) values (1,'Cust1','CUST1@GMAIL.COM');
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111111,1,'2022-11-24',120);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111112,1,'2022-11-12',10);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111113,1,'2022-11-09',70);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111114,1,'2022-12-23',140);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111115,1,'2022-12-27',260);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111116,1,'2022-12-28',315);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111117,1,'2023-01-05',90);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111118,1,'2023-01-03',565);
INSERT INTO TRANSACTIONS(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (111119,1,'2023-01-07',150);
COMMIT;