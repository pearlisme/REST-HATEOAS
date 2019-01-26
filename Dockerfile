FROM openjdk:8
ADD target/docker-rest-hateos.jar docker-rest-hateos.jar
EXPOSE 8002
ENTRYPOINT ["java" , "-jar" , "docker-rest-hateos.jar"]