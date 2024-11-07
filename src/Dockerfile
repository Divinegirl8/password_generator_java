FROM ubuntu:latest
LABEL authors="apple"

# Install required packages: Maven and OpenJDK
RUN apt-get update && \
    apt-get install -y maven openjdk-11-jdk && \
    apt-get clean

# Set the working directory
WORKDIR /app

# Copy your application code to the container (assumes your code is in the same directory as the Dockerfile)
COPY . .

# Package the application using Maven
RUN mvn package

# Set ENTRYPOINT to run `top` in batch mode
ENTRYPOINT ["top", "-b"]
