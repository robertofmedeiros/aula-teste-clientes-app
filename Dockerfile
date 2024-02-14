FROM openjdk:17
VOLUME /tmp
ADD target/aula-teste-cliente-api.jar aula-teste-cliente-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","aula-teste-cliente-api.jar"]