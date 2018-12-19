<p align="center">
  <a href="https://spring.io/">
    <img src="https://spring.io/img/homepage/icon-spring-boot.svg" alt="Logo" width=72 height=72>
  </a>

  <h3 align="center">API RestFull with Spring Boot</h3>

  <p align="center">
    This example app shows how to build a basic api rest, using Spring Boot, which creates and reads CSV files..
  </p>
</p>

## Contents

- [Quick start](#quick-start)
- [What's included](#whats-included)
- [Authors](#authors)
- [License](#license)

## Quick start

**Warning**

> Verify that you are running at least JDK 8+ and Maven 3.3+ by running java -version and mvn -version in a terminal/console window. Older versions produce errors, but newer versions are fine.

1. Go to project folder and execute command.
 ```bash
 mvn spring-boot:run
 ```

 3. URL application:
 ```bash
 http://localhost:8080/cidades
 ```
 
 **Notes**
 > This application handles the cities.csv file located in the project's root directory.
 
 > The method that creates the cidade.csv file should not be run with the file open.

## What's included

* Generates the cities.csv file in the project root directory
* Read CSV file from cities and return in JSON format
* Returns only cities that are capitals and sort by name
* Get the data of the city informing the IBGE ID
* Return the name of cities based on a selected state
* Allows you to select a column (from the CSV) and enter it with a string to filter and return all objects that contain such a string
* Returns the total number of records

## Authors

* **Wilson Filho**  - [Linkedin](https://www.linkedin.com/in/wilson-filho-4424b5bb)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
