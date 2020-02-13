# Game Dashboard For Competitor Analysis

### Prerequisites
- Java 11
- mysql 5.7

### Dependencies
- Spring Boot 2.2.1
- Travis-CI
- Docker
- Junit5

### Build
```
mvn clean package
```
#### Build Docker Image 
```
docker build -t rohan/game-dashboard:tagName .
```

### Run with Intellij Idea

- Import Project as a maven to IDE
- Build Project
- Download Envfile plugin (Preferences -> Plugins -> search for "envfile")
- Add Spring Boot Run Configuration
- Run/Debug Configurations -> EnvFile -> Click on + -> Add default.env file which is located on prospect-forwarder/ folder
- Run Game Dashboard app 
###########################################################################

1. UML


2. Metrics
[![Quality gate](http://localhost:9000/api/project_badges/quality_gate?project=com.game.dashboard%3Agame-dashboard)](http://localhost:9000/dashboard?id=com.game.dashboard%3Agame-dashboard)

3. Clean Code Development

Class Names — Classes and objects should have noun or noun phrase:  GameData, UploadService
Method Names —Methods should have verb or verb phrase names and indicate what they does: getId(),storeGameData(file) etc.
A function shouldn’t have more than 3 arguments. In this code, it is 1 or 2 arguments.
 




