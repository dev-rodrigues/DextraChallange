FROM openjdk

WORKDIR /app

COPY ./ /app/

ENTRYPOINT ["mvn", "clean", "install", "java", "-jar", "MarvelBackend-0.0.1-SNAPSHOT.jar"]