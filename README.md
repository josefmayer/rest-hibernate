## Rest, Hibernate, Database 
Rest-Service <br />
Implementation of a persistence layer with Hibernate<br />



### Technologies
Application: SpringBoot <br />
Rest: SpringRest, JSON <br />
ORM: JPA, Hibernate, Association, JPQL <br />
Databases: MySQL, MSSQL <br />
Testing: Rest-assured  <br />


### Data Model Rest
Data types for JSON-serialization: <br />
CityJson, HotelJson <br />


### Data Model JPA
Entities: <br />
City, Hotel <br />

Associations, Relations: <br />
City:Hotel = 1:N <br />

Dao: <br /> 
Implements CRUD operations <br />

Implementation of Associaton in Database:  <br />
Hibernate creates joincolumn/foreign key column according to the @ManyToOne annotation <br />



### Steps
##### MySQL
Use persistence unit 'jpa-example-mysql'  <br />
Start MySQL <br />
Create table 'jpa_example' <br />

##### MSSQLSERVER
Use persistence unit 'jpa-example-mssqlserver'  <br />
Start MSSQLSERVER <br />
Create table 'jpa_example' <br />



##### Run Rest Service
cd CityHotelService  <br />
*gradle clean assemble* <br />
*java -jar build/libs/jar-name.jar*  <br />


##### Run Test Rest-assured
cd ClientRestAssured  <br />
*gradle bootRun*  <br />






