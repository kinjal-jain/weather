FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD weatherapp-0.0.1.jar weatherapp.jar
RUN sh -c 'touch /weatherapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /weatherapp.jar" ]