FROM tomee:8-jre-7.0.3-plume

EXPOSE 8080

ADD target/aseguradora.war /usr/local/tomee/webapps/aseguradora.war

