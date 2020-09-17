# Python base image.
FROM maven:latest

# copy our application in
COPY . /build

WORKDIR /build

# change the working directory to where we are building
# the application


# use maven to build the application
RUN mvn clean package

# create a new build stage from the Java image
# which has java installed already
FROM openjdk:8

WORKDIR /opt/game_library 

# change the working directory to where the application
# is going to be installed

RUN ls
# copy the JAR file that was created in the previous
# build stage to the application folder in this build stage
COPY --from=0 /build/target/game_library.jar /game_library.jar
EXPOSE 9000
# create an entrypoint to run the application
CMD ["java", "-jar", "/game_library.jar"]               
