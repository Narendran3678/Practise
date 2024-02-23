#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER narendran3678@gmail.com

# Add the application's jar to the image
COPY target/Account-2023.1.jar Account-2023.1.jar

# execute the application
ENTRYPOINT ["java","-jar","Account-2023.1.jar"]