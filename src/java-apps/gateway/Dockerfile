FROM java:8
LABEL developer="Tibin Lukose"
VOLUME /tmp
ARG JAR_FILE="target/gateway.jar"
ADD ${JAR_FILE} app.jar
COPY entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/entrypoint.sh
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]