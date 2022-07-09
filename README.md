# Fuelconsumption-api

For starts this project you need install Docker and start a MySQL docker Image.

Open the terminal and follow the steps:

``` sudo docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql -d mysql:8.0 ```

Find the container Id:

``` sudo docker ps -a ```

Access the container:

``` sudo docker exec -it {idDoContainer} bin/bash ```

In docker:
```  mysql -u root -p ```

**Password: root**

In mysql, create a database:
``` create database FuelConsumption; ```

After that is just run the project.

This objective of this project is create fuel consumption management application (API) for small transportation company.

# Technology Used
* Spring Boot 2.7.1
* Java 8
* JUnit 5
* Gradle
* Docker
* MySQL

For use this API you need follow the steps below:

Any parameter wrong will receive an Bad_Request HTTP.

![image](https://user-images.githubusercontent.com/49644607/178124762-9438cd53-ce69-4c91-acb4-2017da38e164.png)

* JSON Format:
```
{
"fuel": “DIESEL”,
“volume”: “5”,
“value”: “3.75”
“date” “01.21.2018”
}
```


The Get will return all fuel consumption grouping by month:

![image](https://user-images.githubusercontent.com/49644607/178124821-3ffa8d37-546d-41d2-a9d7-c952be7b441f.png)

![image](https://user-images.githubusercontent.com/49644607/178124829-d0849674-2ef4-40fd-b492-262b3dc3d0c0.png)

