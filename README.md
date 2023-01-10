# Customer Rewards App

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

Make up a data set to best demonstrate your solution
Check solution into GitHub and share the URL(Make it Public)
Solution should be built using ReactJS or Spring(Spring Boot)
Instructions for running the solution should be uploaded in ReadMe file on GitHub


# Getting Started
* Required JDK is 11
* Clone git
* This app uses in memory HSQLDB
* In Case if you need to check the data from HSQLDB you may need to run the below queries against hsqldb jar
  java -cp hsqldb-x.x.x.jar org.hsqldb.Server -database.0 mem:testdb -dbname.0 testdb
  java -cp hsqldb-x.x.x.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost:9001/testdb --user sa
* RUN mvn clean package
* RUN below command from project folder 
  * java -jar target/customer-rewards-app-0.0.1-SNAPSHOT.jar

#Run with Docker
* docker build -t customer-rewards
* docker run -p 8080:8083 customer-rewards

#Swagger Access
Once server is up, swagger is accessible from 
http://localhost:8083/swagger-ui/index.html

# URL Information
By default the server is running under 8083 port. You can change port using application.properties file
Use below api to get the rewards information. It is a GET Request
'1' is the customer id. For now data has only one customer.
You may need to update the data to give the correct resulst

http://localhost:8083/customers/1/rewards