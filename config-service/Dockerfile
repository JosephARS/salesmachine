#FROM openjdk:11
#ADD build/libs/*.jar docker_config-service.jar
#EXPOSE 8888
#ENTRYPOINT ["java","-jar","/docker_config-service.jar"]


FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]