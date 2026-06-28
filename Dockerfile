FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src

RUN chmod +x mvnw
RUN ./mvnw -q -DskipTests package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/apiProject-0.0.1-SNAPSHOT.jar"]
