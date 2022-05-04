FROM openjdk:11
ADD build/libs/*.jar docker_config-service.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/docker_config-service.jar"]