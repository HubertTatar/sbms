FROM centos

RUN yum install -y java

VOLUME /tmp
ADD build/libs/eurekaserver-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
EXPOSE 8000
