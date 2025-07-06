FROM eclipse-temurin:21-jre-jammy
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/fsse2501-project-backend-0.0.1-SNAPSHOT.jar Project_Backend.jar
ENTRYPOINT ["java","-jar","/Project_Backend.jar"]