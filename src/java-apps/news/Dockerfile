FROM java:8
LABEL developer="Tibin Lukose"
VOLUME /tmp
ARG JAR_FILE="target/news-app.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dserver.port=8080","-jar","/app.jar"]

