FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} aula-teste-cliente-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/aula-teste-cliente-api.jar"]