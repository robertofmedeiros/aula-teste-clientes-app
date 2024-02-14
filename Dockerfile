FROM openjdk:17
WORKDIR /app
COPY . .
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/aula-teste-cliente-api-0.0.1-SNAPSHOT.jar"]