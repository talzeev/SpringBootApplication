# SpringBootApplication - Volvo Group

Assignment Backend for Volvo Group Tal Berenstein.

## Installation

It is assumed that MongoDB it's currently installed and running on localhost:27017 (Route "mongodb://localhost:27017"). Also, an external API running on "localhost:1337/vehicle" (With the routes 'list', 'info', and 'service'.

This project use [JAVA 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and Gradle 6.6 (Gradle 6.6 can be installed and used easily with [SDKMAN!](https://sdkman.io/install). 
To install Gradle 6.6 with SDKMAN! it's just run these commands:

```bash
$ sdk list gradle
$ sdk install gradle 6.6
$ sdk use gradle 6.6
```

Associated dependences can be found in build.gradle.

1.- Clone this project in a newFolder

2.- Run:

```bash
cd newFolder/SpringBootApplication
gradle bootRun
```
You should see:

```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v2.2.11.RELEASE)

 (...)
(...)
<=========----> 75% EXECUTING [2m 45s]
> :bootRun

```


## Usage
In this case, I use Altair GraphQL and Postmant as a GraphQL client, but It can be used with another client also.

If the external API is running, MongoDB is installed and this project running successfully, you would be able to use all the queries listed here:

```graphQL

seedVehiclesfromApi [Vehicle]
```
Fetch data from external API, handle errors, insert in the Mongo DataBase created in the constructor. Return all info from the collection (vehicles) after being created.

```graphQL
getAllVehicles [Vehicle]
```
Return all info from the collection.

```graphQL
getVehicleById ( id ID ) Vehicle
```
Accepts a string. Return a vehicle where the vehicle id matches the supplied string.

```graphQL
getVehiclesByName ( name String ) [Vehicle]
```
Accepts a string. Return vehicles where the vehicle name partially or fully matches the supplied string. (The string input can be wherever in the name, not just the beginning).

```graphQL
getVehiclesByService ( serviceName String, serviceStatus String ) [Vehicle]
```
Accepts a service name and a service status. Return all vehicles with the serviceName given. (Sadly, I couldn't achieve the complete requirement with the version of java-driver I am using).

All the commits are in this repository and they can be checked.

More than the result, I am glad to participate in the project, It was a good challenge.

Tal Berenstein.

PS: It's 17:46 at the moment, I will keep going with the last requirement with a bit more time than I have today.
