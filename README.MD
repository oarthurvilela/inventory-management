# Java Inventory Management Rest API

## Table of contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Built with](#built-with)
- [Install and run the project](#install-and-run-the-project)
- [Endpoints](#endpoints)


## Overview
- REST API model.
- CRUDs:
  - Address
  - Category
  - Product
  - Supplier

## Prerequisites
* Java JDK 17
* Maven 3.*
* Docker

## Built with
* Java 17
* Maven
* Spring Boot
* Lombok
* Postgres
* Docker
* Swagger

## Install and run the project
1. Download or clone the project.
2. Build the project using following maven command from project root folder where pom.xml file place.
  * `mvn clean package`
3. Create and Run docker image from following command.
  * `docker compose up --build -d`

## Endpoints
Running the project access the following address to view the endpoints on Swagger:
* http://localhost:8080/swagger-ui/index.html#/