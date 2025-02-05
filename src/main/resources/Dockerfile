FROM frolvlad/alpine-java:jdk8-slim
RUN apk add -U tzdata
RUN cp /usr/share/zoneinfo/America/Santiago /etc/localtime
RUN date
RUN mkdir -p /api-sidep-unidadeducativa/lib/
RUN mkdir -p /api-sidep-unidadeducativa/config/
RUN mkdir -p /api-sidep-unidadeducativa/logs/
ADD bootstrap.yml /api-sidep-unidadeducativa/config
ADD logback.xml /api-sidep-unidadeducativa/config
ADD application-api-sidep-unidadeducativa-messages.properties /api-sidep-unidadeducativa/config
WORKDIR /api-sidep-unidadeducativa
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","lib/app.jar"]
EXPOSE 9302
HEALTHCHECK --interval=2s --retries=15 --timeout=2s --start-period=8s CMD curl --connect-timeout 1 -f http://127.0.0.1:9302/api-sidep-unidadeducativa
ADD api-sidep-unidadeducativa.jar /api-sidep-unidadeducativa/lib/app.jar
