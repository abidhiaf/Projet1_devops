FROM openjdk:11-jre-slim
WORKDIR /app
ADD target/gestion-station-ski-1.0.jar gestion-station-ski.jar-1.0.jar
EXPOSE 8089
CMD java -jar gestion-station-ski-1.0.jar
ENTRYPOINT [ "java", "-jar", "gestion-station-ski-1.0.jar" ]