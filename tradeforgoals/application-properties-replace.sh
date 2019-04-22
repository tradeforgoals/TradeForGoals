#!/bin/sh

sed -i -r "s/spring.datasource.url=?([^\n]+)$/spring.datasource.url=$1/g" /home/app/src/main/resources/application.properties
sed -i -r "s/spring.datasource.username=?([^\n]+)$/spring.datasource.username=$2/g" /home/app/src/main/resources/application.properties
sed -i -r "s/spring.datasource.password=?([^\n]+)$/spring.datasource.password=$3/g" /home/app/src/main/resources/application.properties
sed -i -r "s/spring.jpa.database_platform=?([^\n]+)$/spring.jpa.database_platform=$4/g" /home/app/src/main/resources/application.properties
sed -i -r "s/server.port=?([^\n]+)$/server.port=$5/g" /home/app/src/main/resources/application.properties
