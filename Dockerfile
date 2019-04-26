FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./gradlew build --refresh-dependencies
ENTRYPOINT ["java", "-jar", "/app/build/libs/loans-all-0.0.1.jar"]
