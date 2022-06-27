FROM openjdk:11
VOLUME /tmp
EXPOSE 8088
ADD ./target/bootcoin-0.0.1-SNAPSHOT.jar bootcoin.jar
ENTRYPOINT ["java","-jar","bootcoin.jar"]