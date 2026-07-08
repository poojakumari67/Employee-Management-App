FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew bootJar

EXPOSE 8080

CMD ["sh", "-c", "java -jar build/libs/*.jar"]