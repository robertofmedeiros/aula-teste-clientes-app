FROM maven:3.8.7-eclipse-temurin-19-alpine
WORKDIR /app
COPY . .
RUN mvn clean install -Dmaven.test.skip=true -P prod
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/aula-teste-cliente-api-0.0.1-SNAPSHOT.jar", , "--spring.profiles.active=prod"]