FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /opt/pet-clinic

COPY pet-clinic-web/target/pet-clinic-web-0.0.2.jar /opt/pet-clinic/pet-clinic-web-0.0.2.jar

EXPOSE 8080

CMD exec $JAVA_HOME/bin/java -jar /opt/pet-clinic/pet-clinic-web-0.0.2.jar
