FROM  openjdk:17-oracle
EXPOSE 8080
WORKDIR /usr/solomon/src
COPY build/libs/solomonProject-0.0.1-SNAPSHOT.war /usr/solomon/src/

CMD ["java", "-jar", "solomonProject-0.0.1-SNAPSHOT.war"]