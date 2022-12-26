FROM openjdk:17
ADD /build/libs/sidiayapi-0.0.1-SNAPSHOT-plain.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]