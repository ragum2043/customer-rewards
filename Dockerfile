FROM maven:3.8.2-jdk-11
WORKDIR ./
COPY . .
RUN mvn clean package
CMD mvn spring-boot:run