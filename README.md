Complete Documentation is in following Wiki file

[Complete Documentation of GamesDashboard](https://github.com/rohanmengade/game-dashboard/wiki/Complete-Documentation-of-Project)

Prerequisites

Java 11

mysql 5.7


Dependencies
Spring Boot 2.2.1
		
Travis-CI
		
Docker
		
Junit5

Build

mvn clean package

Build Docker Image

docker build -t rohan/game-dashboard:tagName .

Run with Intellij Idea

Import Project as a maven to IDE

Build Project

Download Envfile plugin (Preferences -> Plugins -> search for "envfile")

Add Spring Boot Run Configuration

Run/Debug Configurations -> EnvFile -> Click on + -> Add default.env file which is located on prospect-forwarder/ folder

Run Game Dashboard app




