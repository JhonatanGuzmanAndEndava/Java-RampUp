# Java Ramp up Projects

## Prerequisites

1. JDK 1.8+
2. Gradle 4.1+
3. Git 2.0+

## Cloning the application

 ```bash
 git clone https://[user]@bitbucket.endava.com/scm/bd/java-rampup.git
 ```
Where user is the Bitbucket user

## Running the applications

 Use the gradle tasks for to run the applications as is described below:

### Algorithmic Challenge
 
 ```bash
 ./gradlew run
 ```

 ### Data Processing Challenge
 
  ```bash
 ./gradlew run
 ```

 ### API Challenge

 ```bash
 ./gradlew bootRun
 ```

 Note: If you want to run the application using Docker, you should execute the commands below:

 ```bash
 docker build -t javarampup-apichallenge .
 docker run -d -p 8080:8080 javarampup-apichallenge:latest
 ```

 Note: If you need to know more details about this project you can visit the [Confluence Site](https://confluence.endava.com/pages/viewpage.action?pageId=28450373)