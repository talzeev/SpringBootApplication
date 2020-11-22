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
cd newFolder
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
In this case, I use Altair GraphQL Client for using the server.

If the external API is running, MongoDB is installed and this project running successfully, you would be able to use all the queries listed here:

```graphQL
queries:

seedVehiclesfromApi [Vehicle]
(
getAllVehicles [Vehicle]
getVehicleById ( id ID ) Vehicle
getVehiclesByName ( name String ) [Vehicle]
getVehiclesByService ( serviceName String, serviceStatus String ) [Vehicle]
```

