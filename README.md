<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&weight=600&size=50&pause=1000&center=true&vCenter=true&width=835&height=70&lines=JWT+Authentication" alt="Typing SVG" /></a>

<p>This project demonstrates a comprehensive implementation of JWT (JSON Web Token) based authentication in a Spring Boot application. The project is structured with multiple components to handle various aspects of the application, ensuring clean and maintainable code.</p>

<h2>Project Structure</h2>

* Entity: Defines the data model and maps it to the database.
* DTO (Data Transfer Object): Facilitates the transfer of data between different layers of the application.
* Repository: Handles all database operations and data persistence.
* Service: Contains the business logic and interacts with the Repository layer.
* Config: Configures security settings, including JWT authentication and authorization.
* Controller: Manages incoming HTTP requests, processes them, and returns appropriate responses.
* Util: Contains utility classes for various operations, particularly for handling JWT tokens.

<h2>Features</h2>

* JWT Generation: Generates JWT tokens upon successful authentication, which are then used for securing subsequent requests.
* User Authentication: Validates user credentials and issues JWT tokens, ensuring secure access to protected resources.

<h2>Technologies Used</h2>

* Spring Boot: Framework to create standalone, production-grade Spring-based applications.
* Spring Security: Provides authentication and authorization support, securing the application.
* JSON Web Token (JWT): Mechanism for securely transmitting information between parties as a JSON object.
* JPA/Hibernate: ORM (Object Relational Mapping) framework to interact with the database.
* MySQL (or any other database): Relational database for storing application data.
* Maven: Build automation tool for managing project dependencies.

<h2>Getting Started</h2>
<h3>Prerequisites</h3>

* JDK 17 or later: Ensure that your system is running Java Development Kit 17 or a later version.
* Maven 3.6 or later: Maven is required to manage dependencies and build the project.
* MySQL (or any other database): A database to store application data.
* IDE: Use an Integrated Development Environment like IntelliJ IDEA or Eclipse for development.

<h3>Installation and Setup</h3>
<h4>Clone the Repository:</h4>

    git clone https://github.com/sandundil2002/JWT-Authentication.git
    cd JWT-Authentication

<h4>Configure the Database:</h4>

* Update the application.properties file with your database connection details.

      spring.application.name=JWT-Authentication
      spring.datasource.url = jdbc:mysql://localhost:3306/yourDatabaseName?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
      spring.datasource.username=yourDatabaseUsername
      spring.datasource.password = yourDatabasePassword
      spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
      spring.jpa.hibernate.ddl-auto = update
      spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver
      spring.jpa.open-in-view=false
      spring.jpa.show-sql= true
      jwt.secret=e#s$p%o$r^t9

<h4>Build the Project:</h4>

    mvn clean install

<h4>Run the Application:</h4>

    mvn spring-boot:run

<h4>Access the Application:</h4>

* The application will be available at http://localhost:8080.

<h2>API Documentation</h2>

<p>You can view and interact with the API using Postman. Detailed documentation for all endpoints, including request formats and expected responses, is available via the following link:</p>

<a href="https://documenter.getpostman.com/view/35384990/2sAXjDevXr">Postman API Documentation</a>


