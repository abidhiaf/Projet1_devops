FROM openjdk:11-jre-slim
WORKDIR /app
ADD *.jar gestion-station-ski-1.0.jar
EXPOSE 8089
CMD java -jar gestion-station-ski-1.0.jar
ENTRYPOINT [ "java", "-jar", "gestion-station-ski-1.0.jar" ]