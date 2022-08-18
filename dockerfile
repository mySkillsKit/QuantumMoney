FROM openjdk:11
VOLUME /tmp
ADD build/libs/QuantumMoney-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5500
ENTRYPOINT ["java","-jar","/app.jar"]