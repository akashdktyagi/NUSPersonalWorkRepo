# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
WORKDIR /usr/app
EXPOSE 8081
COPY target/JavaBrainsSpringApp-1.0-SNAPSHOT.jar /usr/app
ENTRYPOINT ["sh","-c"]
CMD ["exec java -jar JavaBrainsSpringApp-1.0-SNAPSHOT.jar"]
