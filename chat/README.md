Chat-Service Box Project

This projects implements chat-service by using Spring boot with Web-Socket dependencies. 

Developer TOOLS:
1. Eclipse JDK Java 7 +
2. Hibernate JPA
3. REST APIs
4. Reactor Netty Web socket dependency
5. LOMBOK
6. POSTMAN


Development URL and PORT:

URL: http://localhost:8180

Database: H2 Database engine
URL: http://localhost:8180/h2-console

REST APIs:

GET: http://localhost:8180/rest/v1/user
POST: http://localhost:8180/rest/v1/user/registration
POST: http://localhost:8180/rest/v1/chat/{userName}

How to run:

1. Run as Spring-boot application:
	or on terminal: spring-boot:run
	or package it as execuatble jar and run it as java -jar chat-service.jar
	or run it as service with httpd configuration to symlink and run it as service chat-service start