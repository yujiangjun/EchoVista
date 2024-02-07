FROM openjdk:22-ea-21
ADD User/target/User-1.0-SNAPSHOT.jar user-center.jar
ENTRYPOINT ["java","-jar"]
CMD ["user-center.jar"]