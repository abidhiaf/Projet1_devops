FROM openjdk:11-jre-slim
WORKDIR /app
ADD *.jar devops-project.jar
EXPOSE 8089
CMD java -jar gestion-station-ski.jar
ENTRYPOINT [ "java", "-jar", "gestion-station-ski.jar" ]