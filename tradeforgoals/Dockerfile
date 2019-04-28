FROM maven:3.6.0-jdk-11-slim AS Build

#
## Make sure the correct application.properties are used 
#
ARG datasource_url=jdbc:mysql://localhost:3306/tradeforgoals?serverTimezone=UTC
ARG datasource_username=root
ARG datasource_password=
ARG database_platform=org.hibernate.dialect.MySQL5Dialect
ARG server_port=8080

#
# Build stage
#
COPY src /home/app/src
# COPY application-properties-replace.sh /home/app/application-properties-replace.sh
# RUN chmod 777 /home/app/application-properties-replace.sh
# RUN sh -c /home/app/application-properties-replace.sh ${datasource_url} ${datasource_username} ${datasource_password} ${database_platform} ${server_port}
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# #
# # Package stage
# #
FROM tomcat:9-jre8
MAINTAINER tradeforgoals
COPY --from=build /home/app/target/tradeforgoals-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/tradeforgoals.war
# COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
# COPY manager.xml /usr/local/tomcat/conf/Catalina/localhost/manager.xml

EXPOSE 8080