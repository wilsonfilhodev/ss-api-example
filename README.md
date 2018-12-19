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

**POST** http://localhost:8080/cidades
```
  [
    {
        "ibgeId": "1100015",
        "uf": "RO",
        "name": "Alta Floresta D'Oeste",
        "lon": -61.9998238963,
        "lat": -11.9355403048,
        "noAccents": "Alta Floresta D'Oeste",
        "microRegion": "Cacoal",
        "mesoRegion": "Leste Rondoniense"
    },
    {
        "ibgeId": "3303955",
        "uf": "RJ",
        "name": "Pinheiral",
        "capital": false,
        "lon": -44.000354557,
        "lat": -22.5156739858,
        "noAccents": "Pinheiral",
        "alternativeNames": "",
        "microRegion": "Vale do Paraba Fluminense",
        "mesoRegion": "Sul Fluminense"
    },
    {
        "ibgeId": "1100023",
        "uf": "RO",
        "name": "Ariquemes",
        "capital": true,
        "lon": -63.033269278,
        "lat": -9.9084628666,
        "noAccents": "Ariquemes",
        "microRegion": "Ariquemes",
        "mesoRegion": "Leste Rondoniense"
    }
  ]
```

**Notes**
> An array of cities must be sent. It is not allowed to send only the city object.

* Read CSV file from cities and return in JSON format

**GET** http://localhost:8080/cidades

```
  Example return data.
  
  [
    {
        "ibgeId": "3303906",
        "uf": "RJ",
        "name": "Petrpolis",
        "capital": false,
        "lon": -43.1773365767,
        "lat": -22.510598612,
        "noAccents": "Petropolis",
        "alternativeNames": "",
        "microRegion": "Serrana",
        "mesoRegion": "Metropolitana do Rio de Janeiro"
    }
  ]
```

* Returns only cities that are capitals and sort by name

**GET** http://localhost:8080/cidades?capitais

```
  Example return data.
  
  [
    {
        "ibgeId": "2800308",
        "uf": "SE",
        "name": "Aracaju",
        "capital": true,
        "lon": -37.0482126395,
        "lat": -10.9072157979,
        "noAccents": "Aracaju",
        "alternativeNames": "",
        "microRegion": "Aracaju",
        "mesoRegion": "Leste Sergipano"
    },
    {
        "ibgeId": "1501402",
        "uf": "PA",
        "name": "Belm",
        "capital": true,
        "lon": -48.4878256875,
        "lat": -1.459845,
        "noAccents": "Belem",
        "alternativeNames": "",
        "microRegion": "Belm",
        "mesoRegion": "Metropolitana de Belm"
    },
    {
        "ibgeId": "3106200",
        "uf": "MG",
        "name": "Belo Horizonte",
        "capital": true,
        "lon": -43.9264531735,
        "lat": -19.9375242938,
        "noAccents": "Belo Horizonte",
        "alternativeNames": "",
        "microRegion": "Belo Horizonte",
        "mesoRegion": "Metropolitana de Belo Horizonte"
    }
  ]
```

* Get the data of the city informing the IBGE ID

**GET** http://localhost:8080/cidades/2927408

```
  Example return data.
  
  {
    "ibgeId": "2927408",
    "uf": "BA",
    "name": "Salvador",
    "capital": true,
    "lon": -38.488061484,
    "lat": -13.0147719115,
    "noAccents": "Salvador",
    "alternativeNames": "",
    "microRegion": "Salvador",
    "mesoRegion": "Metropolitana de Salvador"
  }
```

* Return the name of cities based on a selected state

**GET** http://localhost:8080/cidades?estado=ba

```
  Example return data.
  
  [
    "Abara",
    "Abar",
    "Acajutiba",
    "Adustina",
    "gua Fria",
    "rico Cardoso",
    "Aiquara",
    "Alagoinhas"
 ]
```

* Allows you to select a column (from the CSV) and enter it with a string to filter and return all objects that contain such a string

**GET** http://localhost:8080/cidades?coluna=uf&valor=ba (Example 1)

**GET**  http://localhost:8080/cidades?coluna=microregion&valor=ji-paran (Example 2)

```
  Example 1 return data.
  
  [
    {
        "ibgeId": "2900108",
        "uf": "BA",
        "name": "Abara",
        "capital": false,
        "lon": -41.6616084802,
        "lat": -13.2535318933,
        "noAccents": "Abaira",
        "alternativeNames": "",
        "microRegion": "Seabra",
        "mesoRegion": "Centro Sul Baiano"
    },
    {
        "ibgeId": "2900207",
        "uf": "BA",
        "name": "Abar",
        "capital": false,
        "lon": -39.1165879396,
        "lat": -8.7234182457,
        "noAccents": "Abare",
        "alternativeNames": "",
        "microRegion": "Paulo Afonso",
        "mesoRegion": "Vale So-Franciscano da Bahia"
    }
 ]
```

```
  Example 2 return data.
  
  [
    {
        "ibgeId": "1100114",
        "uf": "RO",
        "name": "Jaru",
        "capital": false,
        "lon": -62.4762307081,
        "lat": -10.4359487679,
        "noAccents": "Jaru",
        "alternativeNames": "",
        "microRegion": "Ji-Paran",
        "mesoRegion": "Leste Rondoniense"
    },
    {
        "ibgeId": "1100122",
        "uf": "RO",
        "name": "Ji-Paran",
        "capital": false,
        "lon": -61.9450945827,
        "lat": -10.8820513183,
        "noAccents": "Ji-Parana",
        "alternativeNames": "",
        "microRegion": "Ji-Paran",
        "mesoRegion": "Leste Rondoniense"
    },
    {
        "ibgeId": "1100155",
        "uf": "RO",
        "name": "Ouro Preto do Oeste",
        "capital": false,
        "lon": -62.2610551904,
        "lat": -10.7235739008,
        "noAccents": "Ouro Preto do Oeste",
        "alternativeNames": "",
        "microRegion": "Ji-Paran",
        "mesoRegion": "Leste Rondoniense"
    }
  ]
```

* Returns the total number of records

**GET** http://localhost:8080/cidades?quantidade-registros

```
  Example return data.
  
  5565
```

## Authors

* **Wilson Filho**  - [Linkedin](https://www.linkedin.com/in/wilson-filho-4424b5bb)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
