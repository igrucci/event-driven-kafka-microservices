Ordering Event-Driven System | Java, Spring Boot, Kafka, SQL, RestAPI 

• Order Service: This service accepts JSON files that contain order information.
 
• Kafka: Order Service asynchronously passes the order information to Kafka, allowing other services to subscribe 
and react to these events. 

• Stock Service: This service is subscribed to Kafka events and uses Hibernate to send order data to the PostgreSQL 
database. 

• Email Service: This service is subscribed to Kafka events and uses Spring Email to send order notifications to 
customers’ email.
