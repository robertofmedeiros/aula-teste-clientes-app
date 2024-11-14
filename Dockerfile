FROM maven:3.8.7-eclipse-temurin-19-alpine
WORKDIR /app
COPY . /usr/src/mymaven/
RUN mvn clean install -Dmaven.test.skip=true -P prod
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/aula-teste-cliente-api.jar", , "--spring.profiles.active=prod"]